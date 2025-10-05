package org.willwin.jhin.model.domain.match;

/**
 * Enum representing the result of how a game ended.
 */
public enum EndOfGameResult
{
    /**
     * Game completed normally through victory conditions.
     */
    GAME_COMPLETE,

    /**
     * Game ended due to surrender vote.
     */
    SURRENDER,

    /**
     * Game ended due to early surrender (before minimum time).
     */
    EARLY_SURRENDER
}
