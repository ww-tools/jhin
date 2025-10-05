package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB document representing a position coordinate on the map.
 * Used for tracking participant positions and event locations in the timeline.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionDocument
{

    /**
     * X coordinate on the map.
     */
    @Field("x")
    private Integer x;

    /**
     * Y coordinate on the map.
     */
    @Field("y")
    private Integer y;

}
