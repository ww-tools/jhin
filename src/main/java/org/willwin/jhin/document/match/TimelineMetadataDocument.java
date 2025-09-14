package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * MongoDB document representing metadata for the match timeline.
 * Contains basic identifiers and participant information.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimelineMetadataDocument
{

    @Field("data_version")
    private String dataVersion;

    @Field("match_id")
    private String matchId;

    @Field("participants")
    private List<String> participants;

}
