package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * MongoDB embedded document representing a perk/rune style (tree) for a participant.
 * This document is used as an embedded document within PerksDocument.
 * Contains information about the rune tree and the specific runes selected within it.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerkStyleDocument
{

    /**
     * Description of this perk style.
     * Examples: "primaryStyle", "subStyle"
     */
    @Field("description")
    private String description;

    /**
     * List of perk selections made within this style/tree.
     */
    @Field("selections")
    private List<PerkSelectionDocument> selections;

    /**
     * The unique identifier for this perk style/tree.
     * Examples: 8100 (Domination), 8200 (Sorcery), etc.
     */
    @Field("style")
    private Integer style;

}
