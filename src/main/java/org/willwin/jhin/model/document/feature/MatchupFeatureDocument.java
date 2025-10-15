package org.willwin.jhin.model.document.feature;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;
import org.willwin.jhin.model.domain.match.IndividualPosition;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchupFeatureDocument
{

    @Field("champion_id")
    private Integer championId;

    @Field("items")
    private List<ItemDocument> items;

    @Field("lane")
    private IndividualPosition lane;

    @Field("opponent_champion_id")
    private Integer opponentChampionId;

    @Field("win")
    private Boolean win;

}
