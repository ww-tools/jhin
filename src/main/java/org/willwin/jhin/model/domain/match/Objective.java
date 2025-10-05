package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a single objective in a League of Legends match.
 * Contains information about whether the team got the first kill and total kills for this objective.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Objective
{

    /**
     * Whether this team achieved the first kill/takedown for this objective.
     */
    private Boolean first;

    /**
     * The total number of kills/takedowns this team achieved for this objective.
     */
    private Integer kills;

}
