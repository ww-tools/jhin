package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB embedded document representing participant missions/objectives for a League of Legends match.
 * This document is used as an embedded document within ParticipantDocument.
 * Contains PlayerScore fields that track various mission objectives.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionsDocument
{

    @Field("player_score_0")
    private Integer playerScore0;

    @Field("player_score_1")
    private Integer playerScore1;

    @Field("player_score_10")
    private Integer playerScore10;

    @Field("player_score_11")
    private Integer playerScore11;

    @Field("player_score_2")
    private Integer playerScore2;

    @Field("player_score_3")
    private Integer playerScore3;

    @Field("player_score_4")
    private Integer playerScore4;

    @Field("player_score_5")
    private Integer playerScore5;

    @Field("player_score_6")
    private Integer playerScore6;

    @Field("player_score_7")
    private Integer playerScore7;

    @Field("player_score_8")
    private Integer playerScore8;

    @Field("player_score_9")
    private Integer playerScore9;

}
