package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB embedded document representing team objectives in a League of Legends match.
 * This document is used as an embedded document within TeamDocument.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectivesDocument
{

    /**
     * Atakhan objective statistics.
     */
    @Field("atakhan")
    private ObjectiveDocument atakhan;

    /**
     * Baron objective statistics.
     */
    @Field("baron")
    private ObjectiveDocument baron;

    /**
     * Champion kill statistics.
     */
    @Field("champion")
    private ObjectiveDocument champion;

    /**
     * Dragon objective statistics.
     */
    @Field("dragon")
    private ObjectiveDocument dragon;

    /**
     * Horde objective statistics.
     */
    @Field("horde")
    private ObjectiveDocument horde;

    /**
     * Inhibitor objective statistics.
     */
    @Field("inhibitor")
    private ObjectiveDocument inhibitor;

    /**
     * Rift Herald objective statistics.
     */
    @Field("rift_herald")
    private ObjectiveDocument riftHerald;

    /**
     * Tower objective statistics.
     */
    @Field("tower")
    private ObjectiveDocument tower;

}
