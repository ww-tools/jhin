package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.willwin.jhin.document.BaseDocument;

/**
 * MongoDB document representing a League of Legends match timeline from Riot Games API.
 * This document is used to persist detailed timeline data in the MongoDB database.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "match_timelines")
public class MatchTimelineDocument extends BaseDocument
{

    /**
     * The document ID in MongoDB.
     * Auto-generated unique identifier for the document.
     */
    @Id
    private String id;

    /**
     * Detailed timeline information including frames, events, and participant data.
     */
    @Field("info")
    private TimelineInfoDocument info;

    /**
     * Metadata about the match timeline including basic identifiers.
     */
    @Field("metadata")
    private TimelineMetadataDocument metadata;

}
