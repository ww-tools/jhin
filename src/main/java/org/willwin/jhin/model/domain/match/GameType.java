package org.willwin.jhin.model.domain.match;

/**
 * Enum representing the type of game played in a League of Legends match.
 */
public enum GameType
{
    /**
     * Matched game - standard matchmade game.
     */
    MATCHED_GAME,

    /**
     * Custom game - custom lobby game.
     */
    CUSTOM_GAME,

    /**
     * Tutorial game - tutorial mode.
     */
    TUTORIAL_GAME
}
