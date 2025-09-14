package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB embedded document representing a single perk/rune selection for a participant.
 * This document is used as an embedded document within PerkStyleDocument.
 * Contains the perk ID and its associated variable values.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerkSelectionDocument
{

    /**
     * The unique identifier for this perk/rune.
     */
    @Field("perk")
    private Integer perk;

    /**
     * First variable value associated with this perk.
     * Usage depends on the specific perk selected.
     */
    @Field("var1")
    private Integer var1;

    /**
     * Second variable value associated with this perk.
     * Usage depends on the specific perk selected.
     */
    @Field("var2")
    private Integer var2;

    /**
     * Third variable value associated with this perk.
     * Usage depends on the specific perk selected.
     */
    @Field("var3")
    private Integer var3;

}
