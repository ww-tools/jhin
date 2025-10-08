package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.willwin.jhin.model.document.BaseDocument;

/**
 * MongoDB document representing a League of Legends match from Riot Games API.
 * This document is used to persist match data in the MongoDB database.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "matches")
public class MatchDocument extends BaseDocument
{

    /**
     * The document ID in MongoDB.
     * Auto-generated unique identifier for the document.
     */
    @Id
    private String id;

    /**
     * Detailed information about the match including participants, teams, and game statistics.
     */
    @Field("info")
    private MatchInfoDocument info;

    /**
     * Metadata about the match including basic identifiers.
     */
    @Field("metadata")
    private MatchMetadataDocument metadata;

    @DBRef
    @Field("timeline")
    private MatchTimelineDocument timeline;

}
