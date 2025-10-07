package org.willwin.jhin.riot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.willwin.jhin.feign.account.AccountClient;
import org.willwin.jhin.feign.match.MatchClient;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.model.domain.Region;
import org.willwin.jhin.model.domain.account.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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

    public List<String> getMatchIdsByPuuid(
            Platform platform,
            String puuid,
            Instant startTime)
    {
        URI host = Region.getRegionForPlatform(platform).getUri();
        Long startTimeSeconds = startTime != null ?
                startTime.getEpochSecond() :
                null;
        return Flux
                .range(0, Integer.MAX_VALUE)
                .map(i -> i * 100)
                .concatMap(startIndex -> Mono
                        .fromCallable(() -> rateLimiter.withRateLimit(
                                () -> matchClient.getMatchIdsByPuuid(
                                        host, puuid, startTimeSeconds, null,
                                        null, null, startIndex, 100
                                )))
                        .filter(response -> Objects.nonNull(response.getBody()))
                        .mapNotNull(response -> Objects.requireNonNull(
                                response.getBody())))
                .takeWhile(matchIds -> !matchIds.isEmpty())
                .flatMap(Flux::fromIterable)
                .sort(Comparator.reverseOrder())
                .collectList()
                .block();
    }

}
