package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing champion statistics at a specific point in the match timeline.
 * Contains comprehensive champion attributes including combat stats, resistances, and resources.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChampionStats
{

    /**
     * Ability haste (cooldown reduction) value.
     */
    private Integer abilityHaste;

    /**
     * Ability power (magic damage scaling) value.
     */
    private Integer abilityPower;

    /**
     * Armor value (physical damage resistance).
     */
    private Integer armor;

    /**
     * Armor penetration flat value.
     */
    private Integer armorPen;

    /**
     * Armor penetration percentage value.
     */
    private Integer armorPenPercent;

    /**
     * Attack damage value.
     */
    private Integer attackDamage;

    /**
     * Attack speed value.
     */
    private Integer attackSpeed;

    /**
     * Bonus armor penetration percentage value.
     */
    private Integer bonusArmorPenPercent;

    /**
     * Bonus magic penetration percentage value.
     */
    private Integer bonusMagicPenPercent;

    /**
     * Crowd control reduction percentage.
     */
    private Integer ccReduction;

    /**
     * Cooldown reduction percentage (legacy stat).
     */
    private Integer cooldownReduction;

    /**
     * Current health value.
     */
    private Integer health;

    /**
     * Maximum health value.
     */
    private Integer healthMax;

    /**
     * Health regeneration per second.
     */
    private Integer healthRegen;

    /**
     * Lifesteal percentage.
     */
    private Integer lifesteal;

    /**
     * Magic penetration flat value.
     */
    private Integer magicPen;

    /**
     * Magic penetration percentage value.
     */
    private Integer magicPenPercent;

    /**
     * Magic resistance value.
     */
    private Integer magicResist;

    /**
     * Movement speed value.
     */
    private Integer movementSpeed;

    /**
     * Omnivamp percentage (healing from all damage).
     */
    private Integer omnivamp;

    /**
     * Physical vamp percentage (healing from physical damage).
     */
    private Integer physicalVamp;

    /**
     * Current power/mana/energy value.
     */
    private Integer power;

    /**
     * Maximum power/mana/energy value.
     */
    private Integer powerMax;

    /**
     * Power/mana/energy regeneration per second.
     */
    private Integer powerRegen;

    /**
     * Spell vamp percentage (healing from spell damage).
     */
    private Integer spellVamp;

}
