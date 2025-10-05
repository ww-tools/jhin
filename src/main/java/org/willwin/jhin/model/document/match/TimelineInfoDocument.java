package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import org.willwin.jhin.model.domain.match.EndOfGameResult;

import java.util.List;

/**
 * MongoDB document representing detailed information about the match timeline.
 * Contains all frames and game-specific timeline data.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimelineInfoDocument
{

    @Field("end_of_game_result")
    private EndOfGameResult endOfGameResult;

    @Field("frame_interval")
    private Long frameInterval;

    @Field("frames")
    private List<FrameDocument> frames;

    @Field("game_id")
    private Long gameId;

    @Field("participants")
    private List<TimelineParticipantDocument> participants;

}
