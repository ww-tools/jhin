package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Domain object representing the complete perks/runes setup for a participant.
 * Contains both statistical perks and rune tree selections.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Perks
{

    /**
     * Statistical perks/runes selected by the participant.
     * Contains defensive, flexible, and offensive stat modifications.
     */
    private StatPerks statPerks;

    /**
     * List of perk styles/trees selected by the participant.
     * Typically contains primary and secondary rune trees.
     */
    private List<PerkStyle> styles;

}
