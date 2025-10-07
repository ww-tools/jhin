package org.willwin.jhin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.willwin.jhin.model.document.account.AccountDocument;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.model.domain.account.Account;
import org.willwin.jhin.model.mapper.AccountMapper;
import org.willwin.jhin.repository.AccountRepository;
import org.willwin.jhin.riot.RiotClient;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountUpdateService
{

    private final RiotClient riotClient;

    private final AccountMapper accountMapper;

    private final AccountRepository accountRepository;

    public AccountDocument updateAccount(Platform platform, String puuid) {
        Account account =  riotClient.getAccountByPuuid(platform, puuid);
        return updateAccount(platform, account);
    }

    public AccountDocument updateAccount(
            Platform platform,
            String gameName,
            String tagLine)
    {
        Account account = riotClient.getAccountByRiotId(platform, gameName, tagLine);
        return updateAccount(platform, account);
    }

    private AccountDocument updateAccount(Platform platform, Account account) {
        String puuid = account.getPuuid();
        AccountDocument accountDocument = accountRepository.findById(puuid).orElse(null);
        if (accountDocument == null) {
            accountDocument = accountMapper.toDocument(account);
        }
        List<String> matchIds = riotClient.getMatchIdsByPuuid(platform, puuid, accountDocument.getLastMatchListUpdateDate());
        if (accountDocument.getMatchIds() == null) {
            accountDocument.setMatchIds(new ArrayList<>());
        }
        accountDocument.getMatchIds().addAll(matchIds);
        accountDocument.setLastMatchListUpdateDate(Instant.now());
        accountDocument.setPlatform(platform);
        return accountRepository.save(accountDocument);
    }
}
