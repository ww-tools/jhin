package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB document representing detailed damage breakdown for a victim in a kill event.
 * Contains information about who dealt damage, what spells were used, and damage amounts.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VictimDamageDocument
{

    @Field("basic")
    private Boolean basic;

    @Field("magic_damage")
    private Integer magicDamage;

    @Field("name")
    private String name;

    @Field("participant_id")
    private Integer participantId;

    @Field("physical_damage")
    private Integer physicalDamage;

    @Field("spell_name")
    private String spellName;

    @Field("spell_slot")
    private Integer spellSlot;

    @Field("true_damage")
    private Integer trueDamage;

    @Field("type")
    private String type;

}
