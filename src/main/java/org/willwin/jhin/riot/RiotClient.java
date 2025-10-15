package org.willwin.jhin.riot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.willwin.jhin.feign.account.AccountClient;
import org.willwin.jhin.feign.match.MatchClient;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.model.domain.Region;
import org.willwin.jhin.model.domain.account.Account;
import org.willwin.jhin.model.domain.match.Match;
import org.willwin.jhin.model.domain.match.MatchTimeline;

import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class RiotClient
{

    private final RiotClientRateLimiter rateLimiter;

    private final AccountClient accountClient;

    private final MatchClient matchClient;

    public Account getAccountByPuuid(Platform platform, String puuid)
    {
        URI host = Region.getRegionForPlatform(platform).getUri();
        return rateLimiter
                .withRateLimit(
                        () -> accountClient.getAccountByPuuid(host, puuid))
                .getBody();
    }

    public Account getAccountByRiotId(
            Platform platform,
            String gameName,
            String tagLine)
    {
        URI host = Region.getRegionForPlatform(platform).getUri();
        return rateLimiter
                .withRateLimit(
                        () -> accountClient.getAccountByRiotId(
                                host, gameName,
                                tagLine
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
        List<String> matchIds = new ArrayList<>();
        List<String> page;
        AtomicInteger startIndex = new AtomicInteger(0);
        while ((page = rateLimiter
                .withRateLimit(() -> matchClient.getMatchIdsByPuuid(
                        host, puuid, startTimeSeconds, null, null, null,
                        startIndex.getAndAdd(100), 100
                ))
                .getBody()) != null && !page.isEmpty())
        {
            matchIds.addAll(page);
        }
        return matchIds;
    }

    public Match getMatchById(Platform platform, String matchId)
    {
        URI host = Region.getRegionForPlatform(platform).getUri();
        return rateLimiter
                .withRateLimit(() -> matchClient.getMatchById(host, matchId))
                .getBody();
    }

    public MatchTimeline getMatchTimelineById(Platform platform, String matchId)
    {
        URI host = Region.getRegionForPlatform(platform).getUri();
        return rateLimiter
                .withRateLimit(
                        () -> matchClient.getMatchTimelineById(host, matchId))
                .getBody();
    }

}
