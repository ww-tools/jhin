package org.willwin.jhin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
        Pageable pageable = Pageable.ofSize(100);
        Slice<AccountDocument> slice = accountRepository.findAll(pageable);

        if (!slice.hasContent())
        {
            log.debug(
                    "Updating accounts: No accounts found, creating seed account");
            AccountDocument seed = accountUpdateService.updateAccount(
                    Platform.NA1, "will win", "NA1");
            accountMatchListUpdateService.updateAccountMatchList(
                    seed.getPlatform(), seed);
            return;
        }

        int totalAccounts = 0;
        do
        {
            totalAccounts += slice.getNumberOfElements();
            Flux
                    .fromIterable(slice.getContent())
                    .parallel(3)
                    .runOn(Schedulers.parallel())
                    .subscribe(
                            account -> accountMatchListUpdateService.updateAccountMatchList(
                                    account.getPlatform(), account));
            pageable = slice.nextPageable();
            if (slice.hasNext())
            {
                slice = accountRepository.findAll(pageable);
            }
        } while (slice.hasNext());

        log.debug("Updating accounts: Found {} accounts", totalAccounts);
    }

    @Scheduled(
            fixedRate = 12,
            initialDelay = 14,
            timeUnit = TimeUnit.MINUTES
    )
    void updateAllMatches()
    {
        Pageable pageable = Pageable.ofSize(100);
        Slice<AccountDocument> slice;
        int totalMatches = 0;

        do
        {
            slice = accountRepository.findAll(pageable);
            List<String> matchIds = slice
                    .getContent()
                    .stream()
                    .map(AccountDocument::getMatchIds)
                    .flatMap(List::stream)
                    .distinct()
                    .toList();

            totalMatches += matchIds.size();

            Flux
                    .fromIterable(matchIds)
                    .parallel(3)
                    .runOn(Schedulers.parallel())
                    .subscribe(matchId -> matchUpdateService.updateMatch(
                            Platform.NA1, matchId));

            pageable = slice.nextPageable();
        } while (slice.hasNext());

        log.debug("Updating matches: Found {} matches", totalMatches);
    }

    @Scheduled(
            fixedRate = 12,
            initialDelay = 0,
            timeUnit = TimeUnit.MINUTES
    )
    void updateAllMatchFeatures()
    {
        Pageable pageable = Pageable.ofSize(100);
        Slice<MatchDocument> slice;
        int totalMatches = 0;
        do
        {
            slice = matchRepository.findAll(pageable);
            totalMatches += slice.getNumberOfElements();
            Flux
                    .fromIterable(slice.getContent())
                    .parallel(3)
                    .runOn(Schedulers.parallel())
                    .subscribe(matchFeatureService::updateMatchFeature);
            pageable = slice.nextPageable();
        } while (slice.hasNext());
        log.debug("Updating match features: Found {} matches", totalMatches);
    }

    @Scheduled(
            fixedRate = 12,
            initialDelay = 18,
            timeUnit = TimeUnit.MINUTES
    )
    void crawlNewAccounts()
    {
        Pageable pageable = Pageable.ofSize(100);
        Slice<MatchDocument> slice;
        int totalParticipants = 0;

        do
        {
            slice = matchRepository.findAll(pageable);
            List<Pair<Platform, String>> puuids = slice
                    .getContent()
                    .stream()
                    .flatMap(match -> match
                            .getMetadata()
                            .getParticipants()
                            .stream()
                            .map(participant -> Pair.of(
                                    match.getInfo().getPlatformId(),
                                    participant
                            )))
                    .distinct()
                    .toList();

            totalParticipants += puuids.size();

            Flux
                    .fromIterable(puuids)
                    .parallel(3)
                    .runOn(Schedulers.parallel())
                    .subscribe(
                            participant -> accountUpdateService.updateAccount(
                                    participant.getFirst(),
                                    participant.getSecond()
                            ));

            pageable = slice.nextPageable();
        } while (slice.hasNext());

        log.debug(
                "Updating accounts: Found {} participants", totalParticipants);
    }

}
