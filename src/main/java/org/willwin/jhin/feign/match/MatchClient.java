package org.willwin.jhin.feign.match;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.willwin.jhin.model.domain.match.Match;
import org.willwin.jhin.model.domain.match.MatchTimeline;
import org.willwin.jhin.riot.RiotFeignConfiguration;

import java.net.URI;
import java.util.List;

@FeignClient(
        name = "matchClient",
        url = "${riot.default-api-url}",
        configuration = RiotFeignConfiguration.class
)
public interface MatchClient
{

    @RateLimiter(name = "get-match-ids-by-puuid")
    @CircuitBreaker(name = "get-match-ids-by-puuid")
    @Retry(name = "get-match-ids-by-puuid")
    @GetMapping("/lol/match/v5/matches/by-puuid/{puuid}/ids")
    ResponseEntity<@NonNull List<String>> getMatchIdsByPuuid(
            URI host,
            @PathVariable String puuid,
            @RequestParam(required = false) Long startTime,
            @RequestParam(required = false) Long endTime,
            @RequestParam(required = false) Integer queue,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer start,
            @RequestParam(required = false) Integer count);

    @RateLimiter(name = "get-match-by-puuid")
    @CircuitBreaker(name = "get-match-by-puuid")
    @Retry(name = "get-match-by-puuid")
    @GetMapping("/lol/match/v5/matches/{matchId}")
    ResponseEntity<@NonNull Match> getMatchById(
            URI host,
            @PathVariable String matchId);

    @RateLimiter(name = "get-match-timeline-by-puuid")
    @CircuitBreaker(name = "get-match-timeline-by-puuid")
    @Retry(name = "get-match-timeline-by-puuid")
    @GetMapping("/lol/match/v5/matches/{matchId}/timeline")
    ResponseEntity<@NonNull MatchTimeline> getMatchTimelineById(
            URI host,
            @PathVariable String matchId);

}
