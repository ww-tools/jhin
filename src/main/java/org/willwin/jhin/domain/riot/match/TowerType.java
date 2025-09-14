package org.willwin.jhin.domain.riot.match;

/**
 * Enum representing the type of tower destroyed in a tower destruction event.
 */
public enum TowerType
{
    /**
     * Outer tower (first tower in each lane).
     */
    OUTER_TURRET,

    /**
     * Inner tower (second tower in each lane).
     */
    INNER_TURRET,

    /**
     * Base tower (third tower in each lane, protecting inhibitors).
     */
    BASE_TURRET,

    /**
     * Nexus tower (protects the Nexus).
     */
    NEXUS_TURRET
}
