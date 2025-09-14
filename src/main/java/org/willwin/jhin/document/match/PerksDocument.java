package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * MongoDB embedded document representing the complete perks/runes setup for a participant.
 * This document is used as an embedded document within ParticipantDocument.
 * Contains both statistical perks and rune tree selections.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerksDocument
{

    /**
     * Statistical perks/runes selected by the participant.
     * Contains defensive, flexible, and offensive stat modifications.
     */
    @Field("stat_perks")
    private StatPerksDocument statPerks;

    /**
     * List of perk styles/trees selected by the participant.
     * Typically contains primary and secondary rune trees.
     */
    @Field("styles")
    private List<PerkStyleDocument> styles;

}
