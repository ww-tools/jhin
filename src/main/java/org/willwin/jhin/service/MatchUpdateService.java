package org.willwin.jhin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.willwin.jhin.model.document.match.MatchDocument;
import org.willwin.jhin.model.document.match.MatchTimelineDocument;
import org.willwin.jhin.model.domain.Platform;
import org.willwin.jhin.model.domain.match.Match;
import org.willwin.jhin.model.domain.match.MatchTimeline;
import org.willwin.jhin.model.mapper.MatchMapper;
import org.willwin.jhin.repository.MatchRepository;
import org.willwin.jhin.repository.MatchTimelineRepository;
import org.willwin.jhin.riot.RiotClient;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchUpdateService
{

    private final RiotClient riotClient;

    private final MatchRepository matchRepository;

    private final MatchTimelineRepository matchTimelineRepository;

    private final MatchMapper matchMapper;

    public MatchDocument updateMatch(Platform platform, String matchId)
    {
        Optional<MatchDocument> existingMatchDocument = matchRepository.findById(
                matchId);
        log.debug("Updating match {} for platform {}", matchId, platform);
        if (existingMatchDocument.isPresent())
        {
            log.debug(
                    "Match {} already exists for platform {}", matchId,
                    platform
            );
            MatchTimelineDocument matchTimelineDocument = updateMatchTimeline(
                    platform, matchId);
            existingMatchDocument.get().setTimeline(matchTimelineDocument);
            return matchRepository.save(existingMatchDocument.get());
        }
        Match match = riotClient.getMatchById(platform, matchId);
        log.debug("Match {} found for platform {}", matchId, platform);
        MatchDocument matchDocument = matchMapper.toDocument(match);
        matchDocument.setTimeline(updateMatchTimeline(platform, matchId));
        return matchRepository.save(matchDocument);
    }

    private MatchTimelineDocument updateMatchTimeline(
            Platform platform,
            String matchId)
    {
        Optional<MatchTimelineDocument> existingMatchTimelineDocument = matchTimelineRepository.findById(
                matchId);
        log.debug(
                "Updating match timeline for match {} for platform {}", matchId,
                platform
        );
        if (existingMatchTimelineDocument.isPresent())
        {
            log.debug(
                    "Match timeline for match {} already exists for platform {}",
                    matchId, platform
            );
            return existingMatchTimelineDocument.get();
        }
        MatchTimeline matchTimeline = riotClient.getMatchTimelineById(
                platform, matchId);
        log.debug(
                "Match timeline for match {} found for platform {}", matchId,
                platform
        );
        MatchTimelineDocument matchTimelineDocument = matchMapper.toDocument(
                matchTimeline);
        return matchTimelineRepository.save(matchTimelineDocument);
    }

}
