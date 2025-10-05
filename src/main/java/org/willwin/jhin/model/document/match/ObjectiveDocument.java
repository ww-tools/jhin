package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB embedded document representing a single objective statistic.
 * This document is used as an embedded document within ObjectivesDocument.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectiveDocument
{

    /**
     * Whether this team was the first to achieve this objective.
     */
    @Field("first")
    private Boolean first;

    /**
     * The number of times this team achieved this objective.
     */
    @Field("kills")
    private Integer kills;

}
