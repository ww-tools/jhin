package org.willwin.jhin.model.domain.match;

/**
 * Enum representing the subtype of elite monster killed in an elite monster kill event.
 * Primarily used for dragon subtypes.
 */
public enum MonsterSubType
{
    /**
     * Fire Dragon - grants Attack Damage and Ability Power.
     */
    FIRE_DRAGON,

    /**
     * Water Dragon - grants Ability Haste and Mana/Energy Regeneration.
     */
    WATER_DRAGON,

    /**
     * Earth Dragon - grants Armor and Magic Resistance.
     */
    EARTH_DRAGON,

    /**
     * Air Dragon - grants Movement Speed and Slow Resistance.
     */
    AIR_DRAGON,

    /**
     * Hextech Dragon - grants Attack Speed and Ability Haste.
     */
    HEXTECH_DRAGON,

    /**
     * Chemtech Dragon - grants damage against enemies with more current health.
     */
    CHEMTECH_DRAGON,

    /**
     * Elder Dragon - the most powerful dragon.
     */
    ELDER_DRAGON,

    /**
     * No specific subtype.
     */
    NONE
}
