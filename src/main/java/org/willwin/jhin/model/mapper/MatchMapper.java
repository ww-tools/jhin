package org.willwin.jhin.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.willwin.jhin.model.document.match.BanDocument;
import org.willwin.jhin.model.document.match.ChallengesDocument;
import org.willwin.jhin.model.document.match.ChampionStatsDocument;
import org.willwin.jhin.model.document.match.DamageStatsDocument;
import org.willwin.jhin.model.document.match.EventDocument;
import org.willwin.jhin.model.document.match.FeatDocument;
import org.willwin.jhin.model.document.match.FrameDocument;
import org.willwin.jhin.model.document.match.MatchDocument;
import org.willwin.jhin.model.document.match.MatchInfoDocument;
import org.willwin.jhin.model.document.match.MatchMetadataDocument;
import org.willwin.jhin.model.document.match.MatchTimelineDocument;
import org.willwin.jhin.model.document.match.MissionsDocument;
import org.willwin.jhin.model.document.match.ObjectiveDocument;
import org.willwin.jhin.model.document.match.ObjectivesDocument;
import org.willwin.jhin.model.document.match.ParticipantDocument;
import org.willwin.jhin.model.document.match.ParticipantFrameDocument;
import org.willwin.jhin.model.document.match.PerkSelectionDocument;
import org.willwin.jhin.model.document.match.PerkStyleDocument;
import org.willwin.jhin.model.document.match.PerksDocument;
import org.willwin.jhin.model.document.match.PositionDocument;
import org.willwin.jhin.model.document.match.StatPerksDocument;
import org.willwin.jhin.model.document.match.TeamDocument;
import org.willwin.jhin.model.document.match.TimelineInfoDocument;
import org.willwin.jhin.model.document.match.TimelineMetadataDocument;
import org.willwin.jhin.model.document.match.TimelineParticipantDocument;
import org.willwin.jhin.model.document.match.VictimDamageDocument;
import org.willwin.jhin.model.domain.match.Ban;
import org.willwin.jhin.model.domain.match.Challenges;
import org.willwin.jhin.model.domain.match.ChampionStats;
import org.willwin.jhin.model.domain.match.DamageStats;
import org.willwin.jhin.model.domain.match.Event;
import org.willwin.jhin.model.domain.match.Feat;
import org.willwin.jhin.model.domain.match.Frame;
import org.willwin.jhin.model.domain.match.Match;
import org.willwin.jhin.model.domain.match.MatchInfo;
import org.willwin.jhin.model.domain.match.MatchMetadata;
import org.willwin.jhin.model.domain.match.MatchTimeline;
import org.willwin.jhin.model.domain.match.Missions;
import org.willwin.jhin.model.domain.match.Objective;
import org.willwin.jhin.model.domain.match.Objectives;
import org.willwin.jhin.model.domain.match.Participant;
import org.willwin.jhin.model.domain.match.ParticipantFrame;
import org.willwin.jhin.model.domain.match.PerkSelection;
import org.willwin.jhin.model.domain.match.PerkStyle;
import org.willwin.jhin.model.domain.match.Perks;
import org.willwin.jhin.model.domain.match.Position;
import org.willwin.jhin.model.domain.match.StatPerks;
import org.willwin.jhin.model.domain.match.Team;
import org.willwin.jhin.model.domain.match.TimelineInfo;
import org.willwin.jhin.model.domain.match.TimelineMetadata;
import org.willwin.jhin.model.domain.match.TimelineParticipant;
import org.willwin.jhin.model.domain.match.VictimDamage;
import org.willwin.jhin.model.mapper.configuration.BaseMapperConfiguration;

/**
 * MapStruct mapper for converting between Match-related domain objects and their corresponding documents.
 * This mapper handles the transformation from domain model to MongoDB document model for all match entities.
 */
@Mapper(config = BaseMapperConfiguration.class)
public interface MatchMapper
{

    // Main Match mappings
    @Mapping(
            target = "id",
            source = "metadata.matchId"
    )
    MatchDocument toDocument(Match match);

    Match toDomain(MatchDocument document);

    // MatchInfo mappings
    MatchInfoDocument toDocument(MatchInfo matchInfo);

    MatchInfo toDomain(MatchInfoDocument document);

    // MatchMetadata mappings  
    MatchMetadataDocument toDocument(MatchMetadata matchMetadata);

    MatchMetadata toDomain(MatchMetadataDocument document);

    // MatchTimeline mappings
    @Mapping(
            target = "id",
            source = "metadata.matchId"
    )
    MatchTimelineDocument toDocument(MatchTimeline matchTimeline);

    MatchTimeline toDomain(MatchTimelineDocument document);

    // TimelineInfo mappings
    TimelineInfoDocument toDocument(TimelineInfo timelineInfo);

    TimelineInfo toDomain(TimelineInfoDocument document);

    // TimelineMetadata mappings
    TimelineMetadataDocument toDocument(TimelineMetadata timelineMetadata);

    TimelineMetadata toDomain(TimelineMetadataDocument document);

    // TimelineParticipant mappings
    TimelineParticipantDocument toDocument(TimelineParticipant timelineParticipant);

    TimelineParticipant toDomain(TimelineParticipantDocument document);

    // Participant mappings
    ParticipantDocument toDocument(Participant participant);

    Participant toDomain(ParticipantDocument document);

    // Team mappings
    TeamDocument toDocument(Team team);

    Team toDomain(TeamDocument document);

    // Ban mappings
    BanDocument toDocument(Ban ban);

    Ban toDomain(BanDocument document);

    // Objectives mappings
    ObjectivesDocument toDocument(Objectives objectives);

    Objectives toDomain(ObjectivesDocument document);

    // Objective mappings
    ObjectiveDocument toDocument(Objective objective);

    Objective toDomain(ObjectiveDocument document);

    // Challenges mappings
    ChallengesDocument toDocument(Challenges challenges);

    Challenges toDomain(ChallengesDocument document);

    // Missions mappings
    MissionsDocument toDocument(Missions missions);

    Missions toDomain(MissionsDocument document);

    // Perks mappings
    PerksDocument toDocument(Perks perks);

    Perks toDomain(PerksDocument document);

    // PerkStyle mappings
    PerkStyleDocument toDocument(PerkStyle perkStyle);

    PerkStyle toDomain(PerkStyleDocument document);

    // PerkSelection mappings
    PerkSelectionDocument toDocument(PerkSelection perkSelection);

    PerkSelection toDomain(PerkSelectionDocument document);

    // StatPerks mappings
    StatPerksDocument toDocument(StatPerks statPerks);

    StatPerks toDomain(StatPerksDocument document);

    // Frame mappings
    FrameDocument toDocument(Frame frame);

    Frame toDomain(FrameDocument document);

    // ParticipantFrame mappings
    ParticipantFrameDocument toDocument(ParticipantFrame participantFrame);

    ParticipantFrame toDomain(ParticipantFrameDocument document);

    // ChampionStats mappings
    ChampionStatsDocument toDocument(ChampionStats championStats);

    ChampionStats toDomain(ChampionStatsDocument document);

    // DamageStats mappings
    DamageStatsDocument toDocument(DamageStats damageStats);

    DamageStats toDomain(DamageStatsDocument document);

    // Event mappings
    EventDocument toDocument(Event event);

    Event toDomain(EventDocument document);

    // Position mappings
    PositionDocument toDocument(Position position);

    Position toDomain(PositionDocument document);

    // VictimDamage mappings
    VictimDamageDocument toDocument(VictimDamage victimDamage);

    VictimDamage toDomain(VictimDamageDocument document);

    // Feat mappings
    FeatDocument toDocument(Feat feat);

    Feat toDomain(FeatDocument document);

}
