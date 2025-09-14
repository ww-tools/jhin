package org.willwin.jhin.domain.riot.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a League of Legends match timeline from Riot Games API.
 * Contains detailed frame-by-frame events and participant states throughout the match.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchTimeline
{

    /**
     * Detailed timeline information including frames, events, and game data.
     */
    private TimelineInfo info;

    /**
     * Metadata about the timeline including basic identifiers and participant list.
     */
    private TimelineMetadata metadata;

}
