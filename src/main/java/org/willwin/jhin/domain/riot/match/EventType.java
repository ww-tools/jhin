package org.willwin.jhin.domain.riot.match;

/**
 * Enum representing the type of event that occurred during a match timeline.
 */
public enum EventType
{
    /**
     * Item purchased event.
     */
    ITEM_PURCHASED,

    /**
     * Champion kill event.
     */
    CHAMPION_KILL,

    /**
     * Ward placed event.
     */
    WARD_PLACED,

    /**
     * Ward killed event.
     */
    WARD_KILL,

    /**
     * Skill level up event.
     */
    SKILL_LEVEL_UP,

    /**
     * Item destroyed event.
     */
    ITEM_DESTROYED,

    /**
     * Item sold event.
     */
    ITEM_SOLD,

    /**
     * Item undo event.
     */
    ITEM_UNDO,

    /**
     * Building kill event.
     */
    BUILDING_KILL,

    /**
     * Elite monster kill event.
     */
    ELITE_MONSTER_KILL,

    /**
     * Turret plate destroyed event.
     */
    TURRET_PLATE_DESTROYED,

    /**
     * Level up event.
     */
    LEVEL_UP,

    /**
     * Game end event.
     */
    GAME_END,

    /**
     * Pause end event.
     */
    PAUSE_END,

    /**
     * Ascended event.
     */
    ASCENDED_EVENT,

    /**
     * Capture point event.
     */
    CAPTURE_POINT,

    /**
     * Poro king summon event.
     */
    PORO_KING_SUMMON
}
