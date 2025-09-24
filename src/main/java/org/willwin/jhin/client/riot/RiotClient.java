package org.willwin.jhin.client.riot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.service.registry.ImportHttpServices;
import org.willwin.jhin.client.riot.account.AccountClient;
import org.willwin.jhin.client.riot.match.MatchClient;
import org.willwin.jhin.domain.riot.Platform;
import org.willwin.jhin.domain.riot.Region;
import org.willwin.jhin.domain.riot.account.Account;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ImportHttpServices(
        group = "riot",
        basePackageClasses = RiotClient.class
)
@Component
@RequiredArgsConstructor
public class RiotClient
{

    private final RiotClientProperties properties;

    private final AccountClient accountClient;

    private final MatchClient matchClient;

    public Mono<Account> getAccountByPuuid(Platform platform, String puuid)
    {
        return accountClient.getAccountByPuuid(
                Objects
                        .requireNonNull(Region.getRegionForPlatform(platform))
                        .getHost(), puuid
        ).mapNotNull(HttpEntity::getBody);
    }

    public Mono<Account> getAccountByAccountId(
            Platform platform,
            String gameName,
            String tagLine)
    {
        return accountClient.getAccountByRiotId(
                Objects
                        .requireNonNull(Region.getRegionForPlatform(platform))
                        .getHost(), gameName, tagLine
        ).mapNotNull(HttpEntity::getBody);
    }

    public Mono<List<String>> getMatchIds(Platform platform, String puuid)
    {
        List<String> matchIds = new ArrayList<>();
        Long startTime = properties
                .getMatchListStart()
                .toEpochSecond(LocalTime.MIN, ZoneOffset.UTC);
        Long endTime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        return Mono.just(matchIds);
    }


}
