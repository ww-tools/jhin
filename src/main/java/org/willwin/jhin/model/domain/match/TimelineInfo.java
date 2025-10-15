package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Domain object representing detailed information about the match timeline.
 * Contains all frames and game-specific timeline data.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimelineInfo
{

    /**
     * Result of the game ending (e.g., GAME_COMPLETE).
     */
    private String endOfGameResult;

    /**
     * Interval between frames in milliseconds.
     */
    private Long frameInterval;

    /**
     * List of timeline frames containing events and participant states.
     */
    private List<Frame> frames;

    /**
     * Game ID (numeric match identifier).
     */
    private Long gameId;

    /**
     * List of participants with their ID and PUUID mapping.
     */
    private List<TimelineParticipant> participants;

}
