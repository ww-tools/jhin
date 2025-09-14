package org.willwin.jhin.domain.riot.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Domain object representing metadata for the match timeline.
 * Contains basic identifiers and participant information.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimelineMetadata
{

    /**
     * Data version of the timeline API.
     */
    private String dataVersion;

    /**
     * Unique match identifier.
     */
    private String matchId;

    /**
     * List of encrypted participant PUUIDs in order of participantId.
     */
    private List<String> participants;

}
