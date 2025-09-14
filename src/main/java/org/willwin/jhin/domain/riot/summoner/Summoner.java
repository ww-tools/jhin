package org.willwin.jhin.domain.riot.summoner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a Riot Games League of Legends summoner.
 * This class models the summoner information returned by the Riot Games API.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Summoner
{

    /**
     * The profile icon ID for the summoner.
     * This represents the summoner's chosen profile picture.
     */
    private Integer profileIconId;

    /**
     * The encrypted PUUID (Player Universally Unique Identifier).
     * This is a unique identifier for the player across all Riot games.
     */
    private String puuid;

    /**
     * The revision date timestamp for the summoner data.
     * This indicates when the summoner data was last updated.
     */
    private Long revisionDate;

    /**
     * The current level of the summoner.
     * This represents the summoner's experience level in League of Legends.
     */
    private Integer summonerLevel;

}
