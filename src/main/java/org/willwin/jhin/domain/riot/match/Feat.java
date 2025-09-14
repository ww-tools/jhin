package org.willwin.jhin.domain.riot.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a team feat/achievement in a League of Legends match.
 * Feats track special team accomplishments during the match.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feat
{

    /**
     * The state of this feat.
     * Represents the achievement status or completion level.
     */
    private Integer featState;

}
