package org.willwin.jhin.riot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.willwin.jhin.feign.account.AccountClient;
import org.willwin.jhin.feign.match.MatchClient;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.model.domain.Region;
import org.willwin.jhin.model.domain.account.Account;

@Component
@RequiredArgsConstructor
public class RiotClient
{

    private final RiotClientRateLimiter rateLimiter;

    private final AccountClient accountClient;

    private final MatchClient matchClient;

    public Account getAccountByPuuid(Platform platform, String puuid)
    {
        return rateLimiter
                .withRateLimit(() -> accountClient.getAccountByPuuid(
                        Region.getRegionForPlatform(platform).getUri(), puuid))
                .getBody();
    }

    public Account getAccountByRiotId(
            Platform platform,
            String gameName,
            String tagLine)
    {
        return rateLimiter
                .withRateLimit(() -> accountClient.getAccountByRiotId(
                        Region.getRegionForPlatform(platform).getUri(),
                        gameName, tagLine
                ))
                .getBody();
    }

}
