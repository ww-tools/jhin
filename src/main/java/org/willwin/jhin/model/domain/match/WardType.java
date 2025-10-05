package org.willwin.jhin.model.domain.match;

/**
 * Enum representing the type of ward placed in a ward placement event.
 */
public enum WardType
{
    /**
     * Yellow trinket ward (Stealth Ward).
     */
    YELLOW_TRINKET,

    /**
     * Control Ward (Pink Ward).
     */
    CONTROL_WARD,

    /**
     * Blue trinket ward (Farsight Orb).
     */
    BLUE_TRINKET,

    /**
     * Stealth Ward from support item.
     */
    SIGHT_WARD,

    /**
     * Vision Ward (legacy).
     */
    VISION_WARD,

    /**
     * Undefined ward type.
     */
    UNDEFINED
}
