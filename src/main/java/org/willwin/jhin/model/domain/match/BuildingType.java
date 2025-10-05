package org.willwin.jhin.model.domain.match;

/**
 * Enum representing the type of building destroyed in a building kill event.
 */
public enum BuildingType
{
    /**
     * Tower building (outer, inner, or base tower).
     */
    TOWER_BUILDING,

    /**
     * Inhibitor building.
     */
    INHIBITOR_BUILDING,

    /**
     * Nexus building.
     */
    NEXUS_BUILDING
}
