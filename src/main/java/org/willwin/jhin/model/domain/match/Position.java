package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a position coordinate on the Summoner's Rift map.
 * Used to track participant and event locations during the match timeline.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position
{

    /**
     * The x-coordinate on the map.
     */
    private Integer x;

    /**
     * The y-coordinate on the map.
     */
    private Integer y;

}
