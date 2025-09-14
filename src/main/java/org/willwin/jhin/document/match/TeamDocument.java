package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

/**
 * MongoDB embedded document representing a team in a League of Legends match.
 * This document is used as an embedded document within MatchInfoDocument.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamDocument
{

    /**
     * List of champions banned by this team during champion select.
     */
    @Field("bans")
    private List<BanDocument> bans;

    /**
     * Map of team feats achieved during the match.
     * Keys are feat names (e.g., "EPIC_MONSTER_KILL", "FIRST_BLOOD", "FIRST_TURRET").
     */
    @Field("feats")
    private Map<String, FeatDocument> feats;

    /**
     * Detailed objective statistics for this team.
     */
    @Field("objectives")
    private ObjectivesDocument objectives;

    /**
     * The unique identifier for this team.
     * Typically 100 for blue side, 200 for red side.
     */
    @Field("team_id")
    private Integer teamId;

    /**
     * Whether this team won the match.
     */
    @Field("win")
    private Boolean win;

}
