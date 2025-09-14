package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB embedded document representing statistical perks/runes for a participant.
 * This document is used as an embedded document within PerksDocument.
 * Contains the three stat modification runes selected by the player.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatPerksDocument
{

    /**
     * The defensive stat perk selected.
     * Examples: Health, Armor, Magic Resistance.
     */
    @Field("defense")
    private Integer defense;

    /**
     * The flexible stat perk selected.
     * Can be either offensive or defensive depending on selection.
     */
    @Field("flex")
    private Integer flex;

    /**
     * The offensive stat perk selected.
     * Examples: Attack Damage, Ability Power, Attack Speed.
     */
    @Field("offense")
    private Integer offense;

}
