package org.willwin.jhin.domain.riot.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a League of Legends match from Riot Games API.
 * This is the main match object containing metadata and detailed match information.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match
{

    /**
     * Detailed information about the match including participants, teams, and game statistics.
     */
    private MatchInfo info;

    /**
     * Metadata about the match including basic identifiers.
     */
    private MatchMetadata metadata;

}
