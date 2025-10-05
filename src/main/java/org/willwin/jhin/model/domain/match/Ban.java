package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a champion ban in a League of Legends match.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ban
{

    /**
     * The ID of the banned champion.
     */
    private Integer championId;

    /**
     * The turn order in which this champion was banned.
     * Values range from 1-10 for the ban phase sequence.
     */
    private Integer pickTurn;

}
