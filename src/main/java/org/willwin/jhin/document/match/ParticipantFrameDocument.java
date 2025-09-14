package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB document representing a participant's state during a specific frame in the match timeline.
 * Contains all statistics and information for a single participant at a specific point in time.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantFrameDocument
{

    @Field("champion_stats")
    private ChampionStatsDocument championStats;

    @Field("current_gold")
    private Integer currentGold;

    @Field("damage_stats")
    private DamageStatsDocument damageStats;

    @Field("gold_per_second")
    private Integer goldPerSecond;

    @Field("jungle_minions_killed")
    private Integer jungleMinionsKilled;

    @Field("level")
    private Integer level;

    @Field("minions_killed")
    private Integer minionsKilled;

    @Field("participant_id")
    private Integer participantId;

    @Field("position")
    private PositionDocument position;

    @Field("time_enemy_spent_controlled")
    private Integer timeEnemySpentControlled;

    @Field("total_gold")
    private Integer totalGold;

    @Field("xp")
    private Integer xp;

}
