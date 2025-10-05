package org.willwin.jhin.model.domain.match;

/**
 * Enum representing the lane assignment of a participant or where an event occurred in a League of Legends match.
 */
public enum Lane
{
    /**
     * Top lane.
     */
    TOP,

    /**
     * Top lane (descriptive form).
     */
    TOP_LANE,

    /**
     * Middle lane.
     */
    MID,

    /**
     * Middle lane (descriptive form).
     */
    MID_LANE,

    /**
     * Bottom lane.
     */
    BOTTOM,

    /**
     * Bottom lane (descriptive form).
     */
    BOT_LANE,

    /**
     * Jungle.
     */
    JUNGLE,

    /**
     * None/unassigned lane.
     */
    NONE
}
