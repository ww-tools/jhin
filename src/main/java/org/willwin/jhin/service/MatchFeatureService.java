package org.willwin.jhin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.willwin.jhin.model.document.feature.ItemDocument;
import org.willwin.jhin.model.document.feature.MatchFeatureDocument;
import org.willwin.jhin.model.document.feature.MatchupFeatureDocument;
import org.willwin.jhin.model.document.match.EventDocument;
import org.willwin.jhin.model.document.match.FrameDocument;
import org.willwin.jhin.model.document.match.MatchDocument;
import org.willwin.jhin.model.document.match.MatchTimelineDocument;
import org.willwin.jhin.model.document.match.ParticipantDocument;
import org.willwin.jhin.model.domain.match.IndividualPosition;
import org.willwin.jhin.repository.MatchFeatureRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchFeatureService
{

    private final MatchFeatureRepository matchFeatureRepository;

    public void updateMatchFeature(MatchDocument match)
    {

        if (matchFeatureRepository.existsById(match.getId()))
        {
            log.debug(
                    "Match feature for match {} already exists", match.getId());
            return;
        }
        log.debug("Updating match feature for match {}", match.getId());
        MatchFeatureDocument matchFeature = new MatchFeatureDocument();
        matchFeature.setId(match.getId());
        matchFeature.setGameVersion(match.getInfo().getGameVersion());

        MatchTimelineDocument timeline = match.getTimeline();

        Map<Integer, ParticipantDocument> participants = match
                .getInfo()
                .getParticipants()
                .stream()
                .collect(Collectors.toMap(
                        ParticipantDocument::getParticipantId,
                        participant -> participant
                ));

        Map<Integer, List<EventDocument>> itemPurchasedEvents = timeline
                .getInfo()
                .getFrames()
                .stream()
                .map(FrameDocument::getEvents)
                .flatMap(List::stream)
                .filter(event -> event.getType().equals("ITEM_PURCHASED"))
                .collect(
                        Collectors.groupingBy(EventDocument::getParticipantId));

        List<MatchupFeatureDocument> matchupFeatures = new ArrayList<>();

        participants.forEach((participantId, participant) ->
        {
            ParticipantDocument opponent = findOpponent(
                    participant, match.getInfo().getParticipants());
            if (opponent == null)
            {
                return;
            }
            List<EventDocument> itemPurchasedEventsForParticipant = itemPurchasedEvents
                    .getOrDefault(participantId, List.of())
                    .stream()
                    .sorted(Comparator.comparing(EventDocument::getTimestamp))
                    .toList();
            List<ItemDocument> items = new ArrayList<>();
            for (int i = 0; i < itemPurchasedEventsForParticipant.size(); i++)
            {
                EventDocument event = itemPurchasedEventsForParticipant.get(i);
                ItemDocument item = new ItemDocument();
                item.setItemId(event.getItemId());
                item.setPurchaseTime(event.getTimestamp());
                item.setPurchaseOrder(i);
                items.add(item);
            }
            MatchupFeatureDocument matchupFeature = new MatchupFeatureDocument();
            matchupFeature.setChampionId(participant.getChampionId());
            matchupFeature.setOpponentChampionId(opponent.getChampionId());
            matchupFeature.setLane(participant.getIndividualPosition());
            matchupFeature.setItems(items);
            matchupFeature.setWin(participant.getWin());
            matchupFeatures.add(matchupFeature);
        });

        matchFeature.setMatchupFeatures(matchupFeatures);

        matchFeatureRepository.save(matchFeature);
    }

    private ParticipantDocument findOpponent(
            ParticipantDocument participant,
            List<ParticipantDocument> participants)
    {
        IndividualPosition lane = participant.getIndividualPosition();
        return participants
                .stream()
                .filter(opponent -> opponent.getIndividualPosition() == lane && !Objects.equals(
                        opponent.getTeamId(), participant.getTeamId()))
                .findFirst()
                .orElse(null);
    }

}
