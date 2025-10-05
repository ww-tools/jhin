package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

/**
 * MongoDB document representing a single frame in the match timeline.
 * Each frame contains events that occurred and participant states at a specific timestamp.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FrameDocument
{

    @Field("events")
    private List<EventDocument> events;

    @Field("participant_frames")
    private Map<String, ParticipantFrameDocument> participantFrames;

    @Field("timestamp")
    private Long timestamp;

}
