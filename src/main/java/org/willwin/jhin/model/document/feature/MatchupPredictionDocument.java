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
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "matchup_predictions")
public class MatchupPredictionDocument extends BaseDocument
{

    @Id
    private String id;

    @Field("game_version")
    private String gameVersion;

    @Field("champion_id")
    private Integer championId;

    @Field("matchups")
    private Map<Integer, List<Integer>> matchups;
}
