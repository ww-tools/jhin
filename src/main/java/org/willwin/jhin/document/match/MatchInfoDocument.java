package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import org.willwin.jhin.domain.riot.Platform;
import org.willwin.jhin.domain.riot.match.EndOfGameResult;
import org.willwin.jhin.domain.riot.match.GameMode;
import org.willwin.jhin.domain.riot.match.GameType;

import java.util.List;

/**
 * MongoDB embedded document representing detailed match information for a League of Legends match.
 * This document is used as an embedded document within MatchDocument.
 * Contains match details, participants, teams, and game statistics.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchInfoDocument
{

    @Field("end_of_game_result")
    private EndOfGameResult endOfGameResult;

    @Field("game_creation")
    private Long gameCreation;

    @Field("game_duration")
    private Integer gameDuration;

    @Field("game_end_timestamp")
    private Long gameEndTimestamp;

    @Field("game_id")
    private Long gameId;

    @Field("game_mode")
    private GameMode gameMode;

    @Field("game_name")
    private String gameName;

    @Field("game_start_timestamp")
    private Long gameStartTimestamp;

    @Field("game_type")
    private GameType gameType;

    @Field("game_version")
    private String gameVersion;

    @Field("map_id")
    private Integer mapId;

    @Field("participants")
    private List<ParticipantDocument> participants;

    @Field("platform_id")
    private Platform platformId;

    @Field("queue_id")
    private Integer queueId;

    @Field("teams")
    private List<TeamDocument> teams;

    @Field("tournament_code")
    private String tournamentCode;

}
