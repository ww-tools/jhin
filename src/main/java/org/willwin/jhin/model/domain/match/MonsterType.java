package org.willwin.jhin.model.domain.match;

/**
 * Enum representing the type of elite monster killed in an elite monster kill event.
 */
public enum MonsterType
{
    /**
     * Baron Nashor - the most powerful neutral monster.
     */
    BARON_NASHOR,

    /**
     * Dragon - elemental dragons and Elder Dragon.
     */
    DRAGON,

    /**
     * Herald - Rift Herald.
     */
    RIFTHERALD,

    /**
     * Vilemaw - Twisted Treeline boss (legacy).
     */
    VILEMAW,

    /**
     * Horde - monsters in special game modes.
     */
    HORDE,

    ATAKHAN
}
