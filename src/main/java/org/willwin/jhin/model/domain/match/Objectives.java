package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing all objectives for a team in a League of Legends match.
 * Contains statistics for different objective types like Baron, Dragon, towers, etc.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Objectives
{

    /**
     * Atakhan objective statistics.
     */
    private Objective atakhan;

    /**
     * Baron objective statistics.
     */
    private Objective baron;

    /**
     * Champion kill objective statistics.
     */
    private Objective champion;

    /**
     * Dragon objective statistics.
     */
    private Objective dragon;

    /**
     * Horde objective statistics.
     */
    private Objective horde;

    /**
     * Inhibitor objective statistics.
     */
    private Objective inhibitor;

    /**
     * Rift Herald objective statistics.
     */
    private Objective riftHerald;

    /**
     * Tower/Turret objective statistics.
     */
    private Objective tower;

}
