package org.willwin.jhin.domain.riot.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing statistical perks/runes for a participant.
 * Contains the three stat modification runes selected by the player.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatPerks
{

    /**
     * The defensive stat perk selected.
     * Examples: Health, Armor, Magic Resistance.
     */
    private Integer defense;

    /**
     * The flexible stat perk selected.
     * Can be either offensive or defensive depending on selection.
     */
    private Integer flex;

    /**
     * The offensive stat perk selected.
     * Examples: Attack Damage, Ability Power, Attack Speed.
     */
    private Integer offense;

}
