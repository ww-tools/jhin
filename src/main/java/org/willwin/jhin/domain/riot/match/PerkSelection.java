package org.willwin.jhin.domain.riot.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a single perk/rune selection for a participant.
 * Contains the perk ID and its associated variable values.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerkSelection
{

    /**
     * The unique identifier for this perk/rune.
     */
    private Integer perk;

    /**
     * First variable value associated with this perk.
     * Usage depends on the specific perk selected.
     */
    private Integer var1;

    /**
     * Second variable value associated with this perk.
     * Usage depends on the specific perk selected.
     */
    private Integer var2;

    /**
     * Third variable value associated with this perk.
     * Usage depends on the specific perk selected.
     */
    private Integer var3;

}
