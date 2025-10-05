package org.willwin.jhin.model.domain.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a Riot Games League of Legends account.
 * This class models the account information returned by the Riot Games API.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account
{

    /**
     * The player's chosen game name (display name).
     */
    private String gameName;

    /**
     * The encrypted PUUID (Player Universally Unique Identifier).
     * This is a unique identifier for the player across all Riot games.
     */
    private String puuid;

    /**
     * The player's tag line (similar to a discriminator).
     */
    private String tagLine;

}
