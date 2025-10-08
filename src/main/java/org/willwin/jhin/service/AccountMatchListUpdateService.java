package org.willwin.jhin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.willwin.jhin.model.document.account.AccountDocument;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.repository.AccountRepository;
import org.willwin.jhin.riot.RiotClient;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (existingAccountDocument.isPresent())
        {
            return updateAccountMatchList(
                    platform, existingAccountDocument.get());
        }
        AccountDocument accountDocument = accountUpdateService.updateAccount(
                platform, puuid);
        return updateAccountMatchList(platform, accountDocument);
    }

    public AccountDocument updateAccountMatchList(
            Platform platform,
            String gameName,
            String tagLine)
    {
        Optional<AccountDocument> existingAccountDocument = accountRepository.findByGameNameAndTagLine(
                gameName, tagLine);
        if (existingAccountDocument.isPresent())
        {
            return updateAccountMatchList(
                    platform, existingAccountDocument.get());
        }
        AccountDocument accountDocument = accountUpdateService.updateAccount(
                platform, gameName, tagLine);
        return updateAccountMatchList(platform, accountDocument);
    }

    private AccountDocument updateAccountMatchList(
            Platform platform,
            @NonNull AccountDocument accountDocument)
    {
        List<String> matchIds = riotClient.getMatchIdsByPuuid(
                platform, accountDocument.getPuuid(),
                accountDocument.getLastMatchListUpdateDate()
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
