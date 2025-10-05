package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Domain object representing a team in a League of Legends match.
 * Contains team-specific information including bans, objectives, and match outcome.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team
{

    /**
     * List of champions banned by this team during the draft phase.
     */
    private List<Ban> bans;

    /**
     * Map of team feats/achievements and their states.
     * Keys are feat names (e.g., "EPIC_MONSTER_KILL", "FIRST_BLOOD", "FIRST_TURRET").
     */
    private Map<String, Feat> feats;

    /**
     * Objectives accomplished by this team during the match.
     */
    private Objectives objectives;

    /**
     * The team identifier (100 for blue team, 200 for red team).
     */
    private Integer teamId;

    /**
     * Whether this team won the match.
     */
    private Boolean win;

}
