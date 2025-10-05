package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing mission/player score data for a participant in a League of Legends match.
 * Contains various player score fields typically used for missions or objectives.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Missions
{

    private Integer playerScore0;

    private Integer playerScore1;

    private Integer playerScore10;

    private Integer playerScore11;

    private Integer playerScore2;

    private Integer playerScore3;

    private Integer playerScore4;

    private Integer playerScore5;

    private Integer playerScore6;

    private Integer playerScore7;

    private Integer playerScore8;

    private Integer playerScore9;

}
