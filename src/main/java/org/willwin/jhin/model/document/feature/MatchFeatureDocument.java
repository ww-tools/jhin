package org.willwin.jhin.model.document.feature;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.willwin.jhin.model.document.BaseDocument;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "match_features")
public class MatchFeatureDocument extends BaseDocument
{

    @Field("game_version")
    private String gameVersion;

    @Id
    private String id;

    @Field("queue_id")
    private Integer queueId;

    @Field("matchup_features")
    private List<MatchupFeatureDocument> matchupFeatures;

}
