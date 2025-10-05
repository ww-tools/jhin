package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing damage statistics for a participant at a specific point in the match timeline.
 * Contains comprehensive damage metrics including dealt, taken, and champion-specific damage.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DamageStats
{

    /**
     * Total magic damage dealt.
     */
    private Integer magicDamageDone;

    /**
     * Magic damage dealt specifically to champions.
     */
    private Integer magicDamageDoneToChampions;

    /**
     * Total magic damage taken from all sources.
     */
    private Integer magicDamageTaken;

    /**
     * Total physical damage dealt.
     */
    private Integer physicalDamageDone;

    /**
     * Physical damage dealt specifically to champions.
     */
    private Integer physicalDamageDoneToChampions;

    /**
     * Total physical damage taken from all sources.
     */
    private Integer physicalDamageTaken;

    /**
     * Total damage dealt (all types combined).
     */
    private Integer totalDamageDone;

    /**
     * Total damage dealt specifically to champions (all types combined).
     */
    private Integer totalDamageDoneToChampions;

    /**
     * Total damage taken from all sources (all types combined).
     */
    private Integer totalDamageTaken;

    /**
     * Total true damage dealt.
     */
    private Integer trueDamageDone;

    /**
     * True damage dealt specifically to champions.
     */
    private Integer trueDamageDoneToChampions;

    /**
     * Total true damage taken from all sources.
     */
    private Integer trueDamageTaken;

}
