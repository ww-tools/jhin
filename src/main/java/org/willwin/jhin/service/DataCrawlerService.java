package org.willwin.jhin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.willwin.jhin.model.document.account.AccountDocument;
import org.willwin.jhin.model.document.match.MatchDocument;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.repository.AccountRepository;
import org.willwin.jhin.repository.MatchRepository;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataCrawlerService
{

    private final AccountRepository accountRepository;

    private final MatchRepository matchRepository;

    private final AccountMatchListUpdateService accountMatchListUpdateService;

    private final MatchUpdateService matchUpdateService;

    private final AccountUpdateService accountUpdateService;

    private final MatchFeatureService matchFeatureService;

    @Scheduled(
            fixedRate = 12,
            initialDelay = 10,
            timeUnit = TimeUnit.MINUTES
    )
    void updateAllAccounts()
    {
        List<AccountDocument> accounts = accountRepository.findAll();
        log.debug("Updating accounts: Found {} accounts", accounts.size());
        if (accounts.isEmpty())
        {
            AccountDocument seed = accountUpdateService.updateAccount(
                    Platform.NA1, "will win", "NA1");
            accounts.add(seed);
        }
        Flux
                .fromIterable(accounts)
                .parallel(3)
                .runOn(Schedulers.parallel())
                .subscribe(
                        account -> accountMatchListUpdateService.updateAccountMatchList(
                                account.getPlatform(), account));
    }

    @Scheduled(
            fixedRate = 12,
            initialDelay = 14,
            timeUnit = TimeUnit.MINUTES
    )
    void updateAllMatches()
    {
        List<AccountDocument> accounts = accountRepository.findAll();
        List<String> matchIds = accounts
                .stream()
                .map(AccountDocument::getMatchIds)
                .flatMap(List::stream)
                .toList();
        log.debug("Updating matches: Found {} matches", matchIds.size());
        Flux
                .fromIterable(matchIds)
                .parallel(3)
                .runOn(Schedulers.parallel())
                .subscribe(
                        matchId -> matchUpdateService.updateMatch(
                                Platform.NA1, matchId));
    }

    @Scheduled(
            fixedRate = 12,
            initialDelay = 16,
            timeUnit = TimeUnit.MINUTES
    )
    void updateAllMatchFeatures()
    {
        List<MatchDocument> matches = matchRepository.findAll();
        log.debug("Updating match features: Found {} matches", matches.size());
        Flux
                .fromIterable(matches)
                .parallel(3)
                .runOn(Schedulers.parallel())
                .subscribe(matchFeatureService::updateMatchFeature);
    }

    @Scheduled(
            fixedRate = 12,
            initialDelay = 18,
            timeUnit = TimeUnit.MINUTES
    )
    void crawlNewAccounts()
    {
        List<MatchDocument> matches = matchRepository.findAll();
        List<Pair<Platform, String>> puuids = matches
                .stream()
                .flatMap(match -> match
                        .getMetadata()
                        .getParticipants()
                        .stream()
                        .map(participant -> Pair.of(
                                match.getInfo().getPlatformId(), participant)))
                .distinct()
                .toList();
        log.debug("Updating accounts: Found {} participants", puuids.size());
        Flux
                .fromIterable(puuids)
                .parallel(3)
                .runOn(Schedulers.parallel())
                .subscribe(participant -> accountUpdateService.updateAccount(
                        participant.getFirst(), participant.getSecond()));
    }

}
