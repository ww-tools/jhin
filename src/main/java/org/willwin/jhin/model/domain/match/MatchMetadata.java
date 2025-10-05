package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Domain object representing match metadata from Riot Games API.
 * Contains basic match identifiers and participant PUUIDs.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchMetadata
{

    /**
     * The data version for this match.
     * Indicates the version of the data structure used.
     */
    private String dataVersion;

    /**
     * The unique identifier for this match.
     * Format: [PLATFORM]_[MATCH_ID] (e.g., "NA1_5365766331")
     */
    private String matchId;

    /**
     * List of participant PUUIDs (Player Universally Unique Identifiers).
     * These are encrypted identifiers for the players in the match.
     */
    private List<String> participants;

}
