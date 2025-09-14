package org.willwin.jhin.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * MongoDB embedded document representing a participant in a League of Legends match.
 * This document is used as an embedded document within MatchInfoDocument.
 * Contains comprehensive participant statistics, items, perks, and match performance data.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDocument
{

    // Ping fields
    @Field("all_in_pings")
    private Integer allInPings;

    @Field("assist_me_pings")
    private Integer assistMePings;

    // Basic stats
    @Field("assists")
    private Integer assists;

    @Field("baron_kills")
    private Integer baronKills;

    @Field("basic_pings")
    private Integer basicPings;

    @Field("bounty_level")
    private Integer bountyLevel;

    // Nested objects
    @Field("challenges")
    private ChallengesDocument challenges;

    @Field("champ_experience")
    private Integer champExperience;

    @Field("champ_level")
    private Integer champLevel;

    @Field("champion_id")
    private Integer championId;

    @Field("champion_name")
    private String championName;

    @Field("champion_transform")
    private Integer championTransform;

    @Field("command_pings")
    private Integer commandPings;

    @Field("consumables_purchased")
    private Integer consumablesPurchased;

    @Field("damage_dealt_to_buildings")
    private Integer damageDealtToBuildings;

    @Field("damage_dealt_to_objectives")
    private Integer damageDealtToObjectives;

    @Field("damage_dealt_to_turrets")
    private Integer damageDealtToTurrets;

    @Field("damage_self_mitigated")
    private Integer damageSelfMitigated;

    @Field("danger_pings")
    private Integer dangerPings;

    @Field("deaths")
    private Integer deaths;

    @Field("detector_wards_placed")
    private Integer detectorWardsPlaced;

    @Field("double_kills")
    private Integer doubleKills;

    @Field("dragon_kills")
    private Integer dragonKills;

    @Field("eligible_for_progression")
    private Boolean eligibleForProgression;

    @Field("enemy_missing_pings")
    private Integer enemyMissingPings;

    @Field("enemy_vision_pings")
    private Integer enemyVisionPings;

    @Field("first_blood_assist")
    private Boolean firstBloodAssist;

    @Field("first_blood_kill")
    private Boolean firstBloodKill;

    @Field("first_tower_assist")
    private Boolean firstTowerAssist;

    @Field("first_tower_kill")
    private Boolean firstTowerKill;

    @Field("game_ended_in_early_surrender")
    private Boolean gameEndedInEarlySurrender;

    @Field("game_ended_in_surrender")
    private Boolean gameEndedInSurrender;

    @Field("get_back_pings")
    private Integer getBackPings;

    @Field("gold_earned")
    private Integer goldEarned;

    @Field("gold_spent")
    private Integer goldSpent;

    @Field("hold_pings")
    private Integer holdPings;

    @Field("individual_position")
    private String individualPosition;

    @Field("inhibitor_kills")
    private Integer inhibitorKills;

    @Field("inhibitor_takedowns")
    private Integer inhibitorTakedowns;

    @Field("inhibitors_lost")
    private Integer inhibitorsLost;

    // Item fields
    @Field("item0")
    private Integer item0;

    @Field("item1")
    private Integer item1;

    @Field("item2")
    private Integer item2;

    @Field("item3")
    private Integer item3;

    @Field("item4")
    private Integer item4;

    @Field("item5")
    private Integer item5;

    @Field("item6")
    private Integer item6;

    @Field("items_purchased")
    private Integer itemsPurchased;

    @Field("killing_sprees")
    private Integer killingSprees;

    @Field("kills")
    private Integer kills;

    @Field("lane")
    private String lane;

    @Field("largest_critical_strike")
    private Integer largestCriticalStrike;

    @Field("largest_killing_spree")
    private Integer largestKillingSpree;

    @Field("largest_multi_kill")
    private Integer largestMultiKill;

    @Field("longest_time_spent_living")
    private Integer longestTimeSpentLiving;

    @Field("magic_damage_dealt")
    private Integer magicDamageDealt;

    @Field("magic_damage_dealt_to_champions")
    private Integer magicDamageDealtToChampions;

    @Field("magic_damage_taken")
    private Integer magicDamageTaken;

    @Field("missions")
    private MissionsDocument missions;

    @Field("need_vision_pings")
    private Integer needVisionPings;

    @Field("neutral_minions_killed")
    private Integer neutralMinionsKilled;

    @Field("nexus_kills")
    private Integer nexusKills;

    @Field("nexus_lost")
    private Integer nexusLost;

    @Field("nexus_takedowns")
    private Integer nexusTakedowns;

    @Field("objectives_stolen")
    private Integer objectivesStolen;

    @Field("objectives_stolen_assists")
    private Integer objectivesStolenAssists;

    @Field("on_my_way_pings")
    private Integer onMyWayPings;

    @Field("participant_id")
    private Integer participantId;

    @Field("penta_kills")
    private Integer pentaKills;

    @Field("perks")
    private PerksDocument perks;

    @Field("physical_damage_dealt")
    private Integer physicalDamageDealt;

    @Field("physical_damage_dealt_to_champions")
    private Integer physicalDamageDealtToChampions;

    @Field("physical_damage_taken")
    private Integer physicalDamageTaken;

    @Field("placement")
    private Integer placement;

    @Field("player_augment1")
    private Integer playerAugment1;

    @Field("player_augment2")
    private Integer playerAugment2;

    @Field("player_augment3")
    private Integer playerAugment3;

    @Field("player_augment4")
    private Integer playerAugment4;

    @Field("player_augment5")
    private Integer playerAugment5;

    @Field("player_augment6")
    private Integer playerAugment6;

    // PlayerScore fields
    @Field("player_score_0")
    private Integer playerScore0;

    @Field("player_score_1")
    private Integer playerScore1;

    @Field("player_score_10")
    private Integer playerScore10;

    @Field("player_score_11")
    private Integer playerScore11;

    @Field("player_score_2")
    private Integer playerScore2;

    @Field("player_score_3")
    private Integer playerScore3;

    @Field("player_score_4")
    private Integer playerScore4;

    @Field("player_score_5")
    private Integer playerScore5;

    @Field("player_score_6")
    private Integer playerScore6;

    @Field("player_score_7")
    private Integer playerScore7;

    @Field("player_score_8")
    private Integer playerScore8;

    @Field("player_score_9")
    private Integer playerScore9;

    @Field("player_subteam_id")
    private Integer playerSubteamId;

    @Field("profile_icon")
    private Integer profileIcon;

    @Field("push_pings")
    private Integer pushPings;

    @Field("puuid")
    private String puuid;

    @Field("quadra_kills")
    private Integer quadraKills;

    @Field("retreat_pings")
    private Integer retreatPings;

    @Field("riot_id_game_name")
    private String riotIdGameName;

    @Field("riot_id_tagline")
    private String riotIdTagline;

    @Field("role")
    private String role;

    @Field("sight_wards_bought_in_game")
    private Integer sightWardsBoughtInGame;

    // Spell cast fields
    @Field("spell1_casts")
    private Integer spell1Casts;

    @Field("spell2_casts")
    private Integer spell2Casts;

    @Field("spell3_casts")
    private Integer spell3Casts;

    @Field("spell4_casts")
    private Integer spell4Casts;

    @Field("subteam_placement")
    private Integer subteamPlacement;

    // Summoner spell fields
    @Field("summoner1_casts")
    private Integer summoner1Casts;

    @Field("summoner1_id")
    private Integer summoner1Id;

    @Field("summoner2_casts")
    private Integer summoner2Casts;

    @Field("summoner2_id")
    private Integer summoner2Id;

    @Field("summoner_id")
    private String summonerId;

    @Field("summoner_level")
    private Integer summonerLevel;

    @Field("summoner_name")
    private String summonerName;

    @Field("team_early_surrendered")
    private Boolean teamEarlySurrendered;

    @Field("team_id")
    private Integer teamId;

    @Field("team_position")
    private String teamPosition;

    @Field("time_ccing_others")
    private Integer timeCCingOthers;

    @Field("time_played")
    private Integer timePlayed;

    @Field("total_ally_jungle_minions_killed")
    private Integer totalAllyJungleMinionsKilled;

    @Field("total_damage_dealt")
    private Integer totalDamageDealt;

    @Field("total_damage_dealt_to_champions")
    private Integer totalDamageDealtToChampions;

    @Field("total_damage_shielded_on_teammates")
    private Integer totalDamageShieldedOnTeammates;

    @Field("total_damage_taken")
    private Integer totalDamageTaken;

    @Field("total_enemy_jungle_minions_killed")
    private Integer totalEnemyJungleMinionsKilled;

    @Field("total_heal")
    private Integer totalHeal;

    @Field("total_heals_on_teammates")
    private Integer totalHealsOnTeammates;

    @Field("total_minions_killed")
    private Integer totalMinionsKilled;

    @Field("total_time_cc_dealt")
    private Integer totalTimeCCDealt;

    @Field("total_time_spent_dead")
    private Integer totalTimeSpentDead;

    @Field("total_units_healed")
    private Integer totalUnitsHealed;

    @Field("triple_kills")
    private Integer tripleKills;

    @Field("true_damage_dealt")
    private Integer trueDamageDealt;

    @Field("true_damage_dealt_to_champions")
    private Integer trueDamageDealtToChampions;

    @Field("true_damage_taken")
    private Integer trueDamageTaken;

    @Field("turret_kills")
    private Integer turretKills;

    @Field("turret_takedowns")
    private Integer turretTakedowns;

    @Field("turrets_lost")
    private Integer turretsLost;

    @Field("unreal_kills")
    private Integer unrealKills;

    @Field("vision_cleared_pings")
    private Integer visionClearedPings;

    @Field("vision_score")
    private Integer visionScore;

    @Field("vision_wards_bought_in_game")
    private Integer visionWardsBoughtInGame;

    @Field("wards_killed")
    private Integer wardsKilled;

    @Field("wards_placed")
    private Integer wardsPlaced;

    @Field("win")
    private Boolean win;

}
