package org.willwin.jhin.domain.riot.match;

/**
 * Enum representing the role of a participant in a League of Legends match.
 */
public enum Role
{
    /**
     * Duo role - bottom lane carry or support.
     */
    DUO,

    /**
     * Duo carry role - ADC (Attack Damage Carry).
     */
    DUO_CARRY,

    /**
     * Duo support role - Support.
     */
    DUO_SUPPORT,

    /**
     * Solo role - top or mid lane.
     */
    SOLO,

    /**
     * None/unassigned role.
     */
    NONE
}
