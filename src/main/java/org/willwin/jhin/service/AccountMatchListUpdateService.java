package org.willwin.jhin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.willwin.jhin.model.document.account.AccountDocument;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.repository.AccountRepository;
import org.willwin.jhin.riot.RiotClient;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountMatchListUpdateService
{

    private final RiotClient riotClient;

    private final AccountRepository accountRepository;

    private final AccountUpdateService accountUpdateService;

    public AccountDocument updateAccountMatchList(
            Platform platform,
            String puuid)
    {
        Optional<AccountDocument> existingAccountDocument = accountRepository.findById(
                puuid);
        log.debug("Updating match list for account {}", puuid);
        if (existingAccountDocument.isPresent())
        {
            log.debug("Account {} already exists", puuid);
            return updateAccountMatchList(
                    platform, existingAccountDocument.get());
        }
        AccountDocument accountDocument = accountUpdateService.updateAccount(
                platform, puuid);
        log.debug("Account {} found", puuid);
        return updateAccountMatchList(platform, accountDocument);
    }

    public AccountDocument updateAccountMatchList(
            Platform platform,
            String gameName,
            String tagLine)
    {
        Optional<AccountDocument> existingAccountDocument = accountRepository.findByGameNameAndTagLine(
                gameName, tagLine);
        log.debug("Updating match list for account {}:{}", gameName, tagLine);
        if (existingAccountDocument.isPresent())
        {
            log.debug("Account {}:{} already exists", gameName, tagLine);
            return updateAccountMatchList(
                    platform, existingAccountDocument.get());
        }
        AccountDocument accountDocument = accountUpdateService.updateAccount(
                platform, gameName, tagLine);
        log.debug("Account {}:{} found", gameName, tagLine);
        return updateAccountMatchList(platform, accountDocument);
    }

    public AccountDocument updateAccountMatchList(
            Platform platform,
            @NonNull AccountDocument accountDocument)
    {
        List<String> matchIds = riotClient.getMatchIdsByPuuid(
                platform,
                accountDocument.getPuuid(),
                accountDocument.getLastMatchListUpdateDate()
        );
        log.debug(
                "Found {} matches for account {}", matchIds.size(),
                accountDocument.getPuuid()
        );
        if (accountDocument.getMatchIds() == null)
        {
            accountDocument.setMatchIds(new ArrayList<>());
        }
        accountDocument.getMatchIds().addAll(matchIds);
        accountDocument.setLastMatchListUpdateDate(Instant.now());
        return accountRepository.save(accountDocument);
    }

}
