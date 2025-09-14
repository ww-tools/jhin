package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB embedded document representing a single team feat in a League of Legends match.
 * This document is used as an embedded document within TeamDocument feats field.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeatDocument
{

    /**
     * The state/status of this feat.
     * Different numbers represent different achievement states.
     */
    @Field("feat_state")
    private Integer featState;

}
