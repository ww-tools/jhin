package org.willwin.jhin.domain.riot.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing damage dealt to a victim in a champion kill event.
 * Contains detailed breakdown of damage sources, types, and amounts.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VictimDamage
{

    /**
     * Whether this damage instance was from a basic attack.
     */
    private Boolean basic;

    /**
     * Amount of magic damage dealt.
     */
    private Integer magicDamage;

    /**
     * Name of the champion or entity that dealt the damage.
     */
    private String name;

    /**
     * Participant ID of the damage dealer.
     */
    private Integer participantId;

    /**
     * Amount of physical damage dealt.
     */
    private Integer physicalDamage;

    /**
     * Name of the spell or ability that dealt the damage.
     */
    private String spellName;

    /**
     * Spell slot number of the ability that dealt the damage.
     */
    private Integer spellSlot;

    /**
     * Amount of true damage dealt.
     */
    private Integer trueDamage;

    /**
     * Type classification of the damage source.
     */
    private String type;

}
