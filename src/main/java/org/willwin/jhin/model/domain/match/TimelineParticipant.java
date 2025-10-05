package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a participant reference in the timeline.
 * Maps participant ID to their encrypted PUUID.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimelineParticipant
{

    /**
     * Participant ID (1-10).
     */
    private Integer participantId;

    /**
     * Encrypted participant PUUID.
     */
    private String puuid;

}
