package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB document representing a participant reference in the timeline.
 * Maps participant ID to their encrypted PUUID.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimelineParticipantDocument
{

    @Field("participant_id")
    private Integer participantId;

    @Field("puuid")
    private String puuid;

}
