package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.willwin.jhin.model.domain.Platform;

import java.util.List;

/**
 * Domain object representing detailed information about a League of Legends match.
 * Contains comprehensive match data including participants, teams, game settings, and results.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchInfo
{

    /**
     * The result of the game at the end.
     * Examples: GAME_COMPLETE, SURRENDER, EARLY_SURRENDER
     */
    private EndOfGameResult endOfGameResult;

    /**
     * The timestamp when the game was created (in milliseconds since epoch).
     */
    private Long gameCreation;

    /**
     * The duration of the game in seconds.
     */
    private Integer gameDuration;

    /**
     * The timestamp when the game ended (in milliseconds since epoch).
     */
    private Long gameEndTimestamp;

    /**
     * The unique identifier for this specific game.
     */
    private Long gameId;

    /**
     * The game mode played.
     * Examples: CLASSIC, ARAM, URF, NEXUSBLITZ
     */
    private GameMode gameMode;

    /**
     * The internal name of the game.
     * Usually follows pattern: "teambuilder-match-{gameId}"
     */
    private String gameName;

    /**
     * The timestamp when the game started (in milliseconds since epoch).
     */
    private Long gameStartTimestamp;

    /**
     * The type of game played.
     * Examples: MATCHED_GAME, CUSTOM_GAME, TUTORIAL_GAME
     */
    private GameType gameType;

    /**
     * The version of the game client used for this match.
     */
    private String gameVersion;

    /**
     * The map identifier where the game was played.
     * Examples: 11 = Summoner's Rift, 12 = Howling Abyss (ARAM)
     */
    private Integer mapId;

    /**
     * List of all participants (players) in the match.
     * Contains detailed statistics and information for each player.
     */
    private List<Participant> participants;

    /**
     * The platform identifier where the match was played.
     * Examples: NA1, EUW1, KR, JP1
     */
    private Platform platformId;

    /**
     * The queue identifier for the game mode.
     * Examples: 420 = Ranked Solo/Duo, 440 = Ranked Flex, 450 = ARAM
     */
    private Integer queueId;

    /**
     * List of teams in the match (usually 2 teams).
     * Contains team-level statistics, objectives, and results.
     */
    private List<Team> teams;

    /**
     * Tournament code if this was a tournament match.
     * Empty string if not a tournament match.
     */
    private String tournamentCode;

}
