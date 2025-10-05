package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB document representing champion statistics at a specific point in the timeline.
 * Contains all combat and defensive stats for a champion during a frame.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChampionStatsDocument
{

    @Field("ability_haste")
    private Integer abilityHaste;

    @Field("ability_power")
    private Integer abilityPower;

    @Field("armor")
    private Integer armor;

    @Field("armor_pen")
    private Integer armorPen;

    @Field("armor_pen_percent")
    private Integer armorPenPercent;

    @Field("attack_damage")
    private Integer attackDamage;

    @Field("attack_speed")
    private Integer attackSpeed;

    @Field("bonus_armor_pen_percent")
    private Integer bonusArmorPenPercent;

    @Field("bonus_magic_pen_percent")
    private Integer bonusMagicPenPercent;

    @Field("cc_reduction")
    private Integer ccReduction;

    @Field("cooldown_reduction")
    private Integer cooldownReduction;

    @Field("health")
    private Integer health;

    @Field("health_max")
    private Integer healthMax;

    @Field("health_regen")
    private Integer healthRegen;

    @Field("lifesteal")
    private Integer lifesteal;

    @Field("magic_pen")
    private Integer magicPen;

    @Field("magic_pen_percent")
    private Integer magicPenPercent;

    @Field("magic_resist")
    private Integer magicResist;

    @Field("movement_speed")
    private Integer movementSpeed;

    @Field("omnivamp")
    private Integer omnivamp;

    @Field("physical_vamp")
    private Integer physicalVamp;

    @Field("power")
    private Integer power;

    @Field("power_max")
    private Integer powerMax;

    @Field("power_regen")
    private Integer powerRegen;

    @Field("spell_vamp")
    private Integer spellVamp;

}
