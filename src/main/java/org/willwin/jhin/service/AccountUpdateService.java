package org.willwin.jhin.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.willwin.jhin.model.document.account.AccountDocument;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.model.domain.account.Account;
import org.willwin.jhin.model.mapper.AccountMapper;
import org.willwin.jhin.repository.AccountRepository;
import org.willwin.jhin.riot.RiotClient;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class AccountUpdateService
{

    private final RiotClient riotClient;

    private final AccountMapper accountMapper;

    private final AccountRepository accountRepository;

    public AccountDocument updateAccount(Platform platform, String puuid)
    {
        Optional<AccountDocument> existingAccountDocument = accountRepository.findById(
                puuid);
        if (existingAccountDocument.isPresent())
        {
            return updateAccount(platform, existingAccountDocument.get());
        }
        Account account = riotClient.getAccountByPuuid(platform, puuid);
        return newAccount(platform, account);
    }

    public AccountDocument updateAccount(
            Platform platform,
            String gameName,
            String tagLine)
    {
        Optional<AccountDocument> existingAccountDocument = accountRepository.findByGameNameAndTagLine(
                gameName, tagLine);
        if (existingAccountDocument.isPresent())
        {
            return updateAccount(platform, existingAccountDocument.get());
        }
        Account account = riotClient.getAccountByRiotId(
                platform, gameName, tagLine);
        return newAccount(platform, account);
    }

    private AccountDocument updateAccount(
            Platform platform,
            @NonNull AccountDocument accountDocument)
    {
        Account account = riotClient.getAccountByPuuid(
                platform, accountDocument.getPuuid());
        accountDocument.setGameName(account.getGameName());
        accountDocument.setTagLine(account.getTagLine());
        return accountRepository.save(accountDocument);
    }

    private AccountDocument newAccount(Platform platform, Account account)
    {
        AccountDocument document = accountMapper.toDocument(account);
        document.setPlatform(platform);
        return accountRepository.save(document);
    }

}
