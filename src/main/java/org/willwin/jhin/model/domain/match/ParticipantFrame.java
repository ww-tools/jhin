package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a participant's state during a specific frame in the match timeline.
 * Contains all statistics and information for a single participant at a specific point in time.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantFrame
{

    /**
     * Champion statistics for this participant at this frame.
     */
    private ChampionStats championStats;

    /**
     * Current gold available for spending.
     */
    private Integer currentGold;

    /**
     * Damage statistics for this participant at this frame.
     */
    private DamageStats damageStats;

    /**
     * Gold earned per second.
     */
    private Integer goldPerSecond;

    /**
     * Number of jungle minions killed.
     */
    private Integer jungleMinionsKilled;

    /**
     * Current champion level.
     */
    private Integer level;

    /**
     * Number of minions killed.
     */
    private Integer minionsKilled;

    /**
     * Participant ID (1-10).
     */
    private Integer participantId;

    /**
     * Position coordinates on the map.
     */
    private Position position;

    /**
     * Time in milliseconds that enemy spent controlled by this participant.
     */
    private Integer timeEnemySpentControlled;

    /**
     * Total gold earned throughout the game.
     */
    private Integer totalGold;

    /**
     * Total experience earned.
     */
    private Integer xp;

}
