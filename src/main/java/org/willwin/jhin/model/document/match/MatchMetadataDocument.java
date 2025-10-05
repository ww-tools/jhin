package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * MongoDB embedded document representing match metadata information.
 * This document is used as an embedded document within MatchDocument.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchMetadataDocument
{

    /**
     * The data version for this match record.
     */
    @Field("data_version")
    private String dataVersion;

    /**
     * The unique match identifier.
     * Format: {platform}_{gameId}
     */
    @Field("match_id")
    private String matchId;

    /**
     * List of participant PUUIDs (Player Universally Unique Identifiers).
     * Contains the encrypted account IDs for all players in the match.
     */
    @Field("participants")
    private List<String> participants;

}
