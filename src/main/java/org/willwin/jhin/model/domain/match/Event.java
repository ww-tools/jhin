package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Domain object representing a timeline event that occurred during the match.
 * Different event types use different subsets of these fields.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event
{

    // Base fields present in all events

    /**
     * List of participant IDs that assisted in the kill.
     */
    private List<Integer> assistingParticipantIds;

    /**
     * Bounty gold awarded for the kill.
     */
    private Integer bounty;

    /**
     * Type of building destroyed.
     */
    private BuildingType buildingType;

    // ITEM_PURCHASED event fields

    /**
     * Creator participant ID for ward placement.
     */
    private Integer creatorId;

    /**
     * ID of the item involved in the event.
     */
    private Integer itemId;

    // CHAMPION_KILL event fields

    /**
     * Length of the kill streak.
     */
    private Integer killStreakLength;

    /**
     * Participant ID of the killer.
     */
    private Integer killerId;

    /**
     * Lane where the building was located.
     */
    private Lane laneType;

    /**
     * Type of level up (e.g., NORMAL).
     */
    private LevelUpType levelUpType;

    /**
     * Subtype of the monster.
     */
    private MonsterSubType monsterSubType;

    /**
     * Type of elite monster killed.
     */
    private MonsterType monsterType;

    /**
     * Participant ID involved in the event.
     */
    private Integer participantId;

    /**
     * Participant ID that destroyed/sold the item.
     */
    private Integer participantIdDestroyer;

    // SKILL_LEVEL_UP event fields

    /**
     * Position where the event occurred.
     */
    private Position position;

    /**
     * Real timestamp when the event occurred.
     */
    private Long realTimestamp;

    // WARD_PLACED event fields

    /**
     * Shutdown bounty gold awarded.
     */
    private Integer shutdownBounty;

    /**
     * Skill slot that was leveled up.
     */
    private Integer skillSlot;

    // ITEM_DESTROYED/ITEM_SOLD event fields

    /**
     * Team ID that owned the destroyed building.
     */
    private Integer teamId;

    // BUILDING_KILL event fields

    /**
     * Game timestamp when the event occurred (in milliseconds).
     */
    private Long timestamp;

    /**
     * Tower type for tower destruction events.
     */
    private TowerType towerType;

    /**
     * Type of the event (e.g., ITEM_PURCHASED, CHAMPION_KILL, WARD_PLACED).
     */
    private EventType type;

    /**
     * Detailed damage breakdown for the victim.
     */
    private List<VictimDamage> victimDamageDealt;

    // ELITE_MONSTER_KILL event fields

    /**
     * Participant ID of the victim.
     */
    private Integer victimId;

    /**
     * Type of ward placed.
     */
    private WardType wardType;

}
