package org.willwin.jhin.document.summoner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.willwin.jhin.document.BaseDocument;

/**
 * MongoDB document representing a Riot Games League of Legends summoner.
 * This document is used to persist summoner information in the MongoDB database.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "summoners")
public class SummonerDocument extends BaseDocument
{

    /**
     * The document ID in MongoDB.
     * Auto-generated unique identifier for the document.
     */
    @Id
    private String id;

    /**
     * The profile icon ID for the summoner.
     * This represents the summoner's chosen profile picture.
     */
    @Field("profile_icon_id")
    private Integer profileIconId;

    /**
     * The encrypted PUUID (Player Universally Unique Identifier).
     * This is a unique identifier for the player across all Riot games.
     * Indexed for efficient queries.
     */
    @Field("puuid")
    @Indexed(unique = true)
    private String puuid;

    /**
     * The revision date timestamp for the summoner data.
     * This indicates when the summoner data was last updated.
     */
    @Field("revision_date")
    private Long revisionDate;

    /**
     * The current level of the summoner.
     * This represents the summoner's experience level in League of Legends.
     */
    @Field("summoner_level")
    private Integer summonerLevel;

}
