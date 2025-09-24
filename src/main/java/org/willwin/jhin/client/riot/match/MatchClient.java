package org.willwin.jhin.client.riot.match;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.willwin.jhin.domain.riot.match.Match;
import org.willwin.jhin.domain.riot.match.MatchTimeline;
import reactor.core.publisher.Mono;

import java.util.List;

@HttpExchange("https://{host}/riot/match/v5/")
@Validated
public interface MatchClient
{

    @GetExchange("/matches/by-puuid/{puuid}/ids")
    Mono<ResponseEntity<@NonNull List<String>>> getMatchIdsByPuuid(
            @PathVariable String host,
            @PathVariable String puuid,
            @RequestParam Long startTime,
            @RequestParam Long endTime,
            @RequestParam Integer queue,
            @RequestParam
            @Pattern(regexp = "ranked|normal|tourney|tutorial")
            String type,
            @RequestParam
            @Min(0)
            Integer start,
            @RequestParam
            @Min(0)
            @Max(100)
            Integer count);

    @GetExchange("/matches/{matchId}")
    Mono<ResponseEntity<@NonNull Match>> getMatchById(
            @PathVariable String host,
            @PathVariable String matchId);

    @GetExchange("/matches/{matchId}/timeline")
    Mono<ResponseEntity<@NonNull MatchTimeline>> getMatchTimelineById(
            @PathVariable String host,
            @PathVariable String matchId);

}
