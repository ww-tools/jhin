package org.willwin.jhin.model.document.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.willwin.jhin.model.document.BaseDocument;
import org.willwin.jhin.model.domain.Platform;

import java.time.Instant;
import java.util.List;

/**
 * MongoDB document representing a Riot Games League of Legends account.
 * This document is used to persist account information in the MongoDB database.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accounts")
public class AccountDocument extends BaseDocument
{

    /**
     * The player's chosen game name (display name).
     */
    @Field("game_name")
    private String gameName;

    /**
     * The document ID in MongoDB.
     * Using the PUUID as the unique identifier for the document.
     */
    @Id
    private String id;

    @Field("last_match_list_update_date")
    private Instant lastMatchListUpdateDate;

    @Field("match_ids")
    private List<String> matchIds;

    @Field("platform")
    private Platform platform;

    /**
     * The encrypted PUUID (Player Universally Unique Identifier).
     * This is a unique identifier for the player across all Riot games.
     * Indexed for efficient queries.
     */
    @Field("puuid")
    @Indexed(unique = true)
    private String puuid;

    /**
     * The player's tag line (similar to a discriminator).
     */
    @Field("tag_line")
    private String tagLine;

}
