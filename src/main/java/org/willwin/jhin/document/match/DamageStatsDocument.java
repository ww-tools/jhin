package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB document representing damage statistics at a specific point in the timeline.
 * Contains all damage dealt and taken statistics for a participant during a frame.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DamageStatsDocument
{

    @Field("magic_damage_done")
    private Integer magicDamageDone;

    @Field("magic_damage_done_to_champions")
    private Integer magicDamageDoneToChampions;

    @Field("magic_damage_taken")
    private Integer magicDamageTaken;

    @Field("physical_damage_done")
    private Integer physicalDamageDone;

    @Field("physical_damage_done_to_champions")
    private Integer physicalDamageDoneToChampions;

    @Field("physical_damage_taken")
    private Integer physicalDamageTaken;

    @Field("total_damage_done")
    private Integer totalDamageDone;

    @Field("total_damage_done_to_champions")
    private Integer totalDamageDoneToChampions;

    @Field("total_damage_taken")
    private Integer totalDamageTaken;

    @Field("true_damage_done")
    private Integer trueDamageDone;

    @Field("true_damage_done_to_champions")
    private Integer trueDamageDoneToChampions;

    @Field("true_damage_taken")
    private Integer trueDamageTaken;

}
