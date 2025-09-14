package org.willwin.jhin.domain.riot.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Domain object representing a perk/rune style (tree) for a participant.
 * Contains information about the rune tree and the specific runes selected within it.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerkStyle
{

    /**
     * Description of this perk style.
     * Examples: "primaryStyle", "subStyle"
     */
    private String description;

    /**
     * List of perk selections made within this style/tree.
     */
    private List<PerkSelection> selections;

    /**
     * The unique identifier for this perk style/tree.
     * Examples: 8100 (Domination), 8200 (Sorcery), etc.
     */
    private Integer style;

}
