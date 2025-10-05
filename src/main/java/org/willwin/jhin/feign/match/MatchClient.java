package org.willwin.jhin.feign.match;

import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.willwin.jhin.model.domain.match.Match;
import org.willwin.jhin.model.domain.match.MatchTimeline;

import java.net.URI;
import java.util.List;

@FeignClient("match-client")
public interface MatchClient
{

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

    @GetMapping("/lol/match/v5/matches/{matchId}")
    ResponseEntity<@NonNull Match> getMatchById(
            URI host,
            @PathVariable String matchId);

    @GetMapping("/lol/match/v5/matches/{matchId}/timeline")
    ResponseEntity<@NonNull MatchTimeline> getMatchTimelineById(
            URI host,
            @PathVariable String matchId);

}
