package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * MongoDB document representing a timeline event that occurred during the match.
 * Different event types use different subsets of these fields.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDocument
{

    // CHAMPION_KILL event fields
    @Field("assisting_participant_ids")
    private List<Integer> assistingParticipantIds;

    @Field("bounty")
    private Integer bounty;

    @Field("building_type")
    private String buildingType;

    // WARD_PLACED event fields
    @Field("creator_id")
    private Integer creatorId;

    // ITEM_PURCHASED event fields
    @Field("item_id")
    private Integer itemId;

    @Field("kill_streak_length")
    private Integer killStreakLength;

    @Field("killer_id")
    private Integer killerId;

    @Field("lane_type")
    private String laneType;

    // SKILL_LEVEL_UP event fields
    @Field("level_up_type")
    private String levelUpType;

    @Field("monster_sub_type")
    private String monsterSubType;

    // ELITE_MONSTER_KILL event fields
    @Field("monster_type")
    private String monsterType;

    @Field("participant_id")
    private Integer participantId;

    // ITEM_DESTROYED/ITEM_SOLD event fields
    @Field("participant_id_destroyer")
    private Integer participantIdDestroyer;

    @Field("position")
    private PositionDocument position;

    // Base fields present in all events
    @Field("real_timestamp")
    private Long realTimestamp;

    @Field("shutdown_bounty")
    private Integer shutdownBounty;

    @Field("skill_slot")
    private Integer skillSlot;

    // BUILDING_KILL event fields
    @Field("team_id")
    private Integer teamId;

    @Field("timestamp")
    private Long timestamp;

    @Field("tower_type")
    private String towerType;

    @Field("type")
    private String type;

    @Field("victim_damage_dealt")
    private List<VictimDamageDocument> victimDamageDealt;

    @Field("victim_id")
    private Integer victimId;

    @Field("ward_type")
    private String wardType;

}
