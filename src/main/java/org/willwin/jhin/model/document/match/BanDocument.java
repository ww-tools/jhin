package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB embedded document representing a champion ban in a League of Legends match.
 * This document is used as an embedded document within TeamDocument.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BanDocument
{

    /**
     * The ID of the banned champion.
     */
    @Field("champion_id")
    private Integer championId;

    /**
     * The turn order in which this ban was made during champion select.
     * Bans alternate between teams, so this indicates the sequence.
     */
    @Field("pick_turn")
    private Integer pickTurn;

}
