package org.willwin.jhin.domain.riot.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Domain object representing a single frame in the match timeline.
 * Each frame contains events that occurred and participant states at a specific timestamp.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Frame
{

    /**
     * List of events that occurred during this frame.
     */
    private List<Event> events;

    /**
     * Map of participant frames indexed by participant ID (as String).
     * Keys are participant IDs ("1", "2", ..., "10").
     * Values are ParticipantFrame objects containing participant state.
     */
    private Map<String, ParticipantFrame> participantFrames;

    /**
     * Timestamp of this frame in milliseconds from game start.
     */
    private Long timestamp;

}
