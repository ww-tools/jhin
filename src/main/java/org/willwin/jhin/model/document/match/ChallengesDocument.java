package org.willwin.jhin.model.document.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * MongoDB embedded document representing challenge statistics for a participant in a League of Legends match.
 * This document is used as an embedded document within ParticipantDocument.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChallengesDocument
{

    @Field("ability_uses")
    private Integer abilityUses;

    @Field("aces_before_15_minutes")
    private Integer acesBefore15Minutes;

    @Field("allied_jungle_monster_kills")
    private Integer alliedJungleMonsterKills;

    @Field("12_assist_streak_count")
    private Integer assistStreakCount;

    @Field("baron_buff_gold_advantage_over_threshold")
    private Integer baronBuffGoldAdvantageOverThreshold;

    @Field("baron_takedowns")
    private Integer baronTakedowns;

    @Field("blast_cone_opposite_opponent_count")
    private Integer blastConeOppositeOpponentCount;

    @Field("bounty_gold")
    private Double bountyGold;

    @Field("buffs_stolen")
    private Integer buffsStolen;

    @Field("complete_support_quest_in_time")
    private Integer completeSupportQuestInTime;

    @Field("control_ward_time_coverage_in_river_or_enemy_half")
    private Double controlWardTimeCoverageInRiverOrEnemyHalf;

    @Field("control_wards_placed")
    private Integer controlWardsPlaced;

    @Field("damage_per_minute")
    private Double damagePerMinute;

    @Field("damage_taken_on_team_percentage")
    private Double damageTakenOnTeamPercentage;

    @Field("danced_with_rift_herald")
    private Integer dancedWithRiftHerald;

    @Field("deaths_by_enemy_champs")
    private Integer deathsByEnemyChamps;

    @Field("dodge_skill_shots_small_window")
    private Integer dodgeSkillShotsSmallWindow;

    @Field("double_aces")
    private Integer doubleAces;

    @Field("dragon_takedowns")
    private Integer dragonTakedowns;

    @Field("earliest_baron")
    private Double earliestBaron;

    @Field("earliest_dragon_takedown")
    private Double earliestDragonTakedown;

    @Field("early_laning_phase_gold_exp_advantage")
    private Integer earlyLaningPhaseGoldExpAdvantage;

    @Field("effective_heal_and_shielding")
    private Double effectiveHealAndShielding;

    @Field("elder_dragon_kills_with_opposing_soul")
    private Integer elderDragonKillsWithOpposingSoul;

    @Field("elder_dragon_multikills")
    private Integer elderDragonMultikills;

    @Field("enemy_champion_immobilizations")
    private Integer enemyChampionImmobilizations;

    @Field("enemy_jungle_monster_kills")
    private Integer enemyJungleMonsterKills;

    @Field("epic_monster_kills_near_enemy_jungler")
    private Integer epicMonsterKillsNearEnemyJungler;

    @Field("epic_monster_kills_within_30_seconds_of_spawn")
    private Integer epicMonsterKillsWithin30SecondsOfSpawn;

    @Field("epic_monster_steals")
    private Integer epicMonsterSteals;

    @Field("epic_monster_stolen_without_smite")
    private Integer epicMonsterStolenWithoutSmite;

    @Field("first_turret_killed")
    private Integer firstTurretKilled;

    @Field("first_turret_killed_time")
    private Double firstTurretKilledTime;

    @Field("fist_bump_participation")
    private Integer fistBumpParticipation;

    @Field("flawless_aces")
    private Integer flawlessAces;

    @Field("full_team_takedown")
    private Integer fullTeamTakedown;

    @Field("game_length")
    private Double gameLength;

    @Field("get_takedowns_in_all_lanes_early_jungle_as_laner")
    private Integer getTakedownsInAllLanesEarlyJungleAsLaner;

    @Field("gold_per_minute")
    private Double goldPerMinute;

    @Field("had_open_nexus")
    private Integer hadOpenNexus;

    @Field("heal_from_map_sources")
    private Double healFromMapSources;

    @Field("highest_champion_damage")
    private Integer highestChampionDamage;

    @Field("highest_crowd_control_score")
    private Integer highestCrowdControlScore;

    @Field("highest_ward_kills")
    private Integer highestWardKills;

    @Field("immobilize_and_kill_with_ally")
    private Integer immobilizeAndKillWithAlly;

    @Field("infernal_scale_pickup")
    private Integer infernalScalePickup;

    @Field("initial_buff_count")
    private Integer initialBuffCount;

    @Field("initial_crab_count")
    private Integer initialCrabCount;

    @Field("jungle_cs_before_10_minutes")
    private Double jungleCsBefore10Minutes;

    @Field("jungler_kills_early_jungle")
    private Integer junglerKillsEarlyJungle;

    @Field("jungler_takedowns_near_damaged_epic_monster")
    private Integer junglerTakedownsNearDamagedEpicMonster;

    @Field("k_turrets_destroyed_before_plates_fall")
    private Integer kTurretsDestroyedBeforePlatesFall;

    @Field("kda")
    private Double kda;

    @Field("kill_after_hidden_with_ally")
    private Integer killAfterHiddenWithAlly;

    @Field("kill_participation")
    private Double killParticipation;

    @Field("killed_champ_took_full_team_damage_survived")
    private Integer killedChampTookFullTeamDamageSurvived;

    @Field("killing_sprees")
    private Integer killingSprees;

    @Field("kills_near_enemy_turret")
    private Integer killsNearEnemyTurret;

    @Field("kills_on_laners_early_jungle_as_jungler")
    private Integer killsOnLanersEarlyJungleAsJungler;

    @Field("kills_on_other_lanes_early_jungle_as_laner")
    private Integer killsOnOtherLanesEarlyJungleAsLaner;

    @Field("kills_on_recently_healed_by_aram_pack")
    private Integer killsOnRecentlyHealedByAramPack;

    @Field("kills_under_own_turret")
    private Integer killsUnderOwnTurret;

    @Field("kills_with_help_from_epic_monster")
    private Integer killsWithHelpFromEpicMonster;

    @Field("knock_enemy_into_team_and_kill")
    private Integer knockEnemyIntoTeamAndKill;

    @Field("land_skill_shots_early_game")
    private Integer landSkillShotsEarlyGame;

    @Field("lane_minions_first_10_minutes")
    private Integer laneMinionsFirst10Minutes;

    @Field("laning_phase_gold_exp_advantage")
    private Integer laningPhaseGoldExpAdvantage;

    @Field("legendary_count")
    private Integer legendaryCount;

    @Field("legendary_item_used")
    private List<Integer> legendaryItemUsed;

    @Field("lost_an_inhibitor")
    private Integer lostAnInhibitor;

    @Field("max_cs_advantage_on_lane_opponent")
    private Double maxCsAdvantageOnLaneOpponent;

    @Field("max_kill_deficit")
    private Integer maxKillDeficit;

    @Field("max_level_lead_lane_opponent")
    private Integer maxLevelLeadLaneOpponent;

    @Field("mejais_full_stack_in_time")
    private Integer mejaisFullStackInTime;

    @Field("more_enemy_jungle_than_opponent")
    private Double moreEnemyJungleThanOpponent;

    @Field("multi_kill_one_spell")
    private Integer multiKillOneSpell;

    @Field("multi_turret_rift_herald_count")
    private Integer multiTurretRiftHeraldCount;

    @Field("multikills")
    private Integer multikills;

    @Field("multikills_after_aggressive_flash")
    private Integer multikillsAfterAggressiveFlash;

    @Field("outer_turret_executes_before_10_minutes")
    private Integer outerTurretExecutesBefore10Minutes;

    @Field("outnumbered_kills")
    private Integer outnumberedKills;

    @Field("outnumbered_nexus_kill")
    private Integer outnumberedNexusKill;

    @Field("perfect_dragon_souls_taken")
    private Integer perfectDragonSoulsTaken;

    @Field("perfect_game")
    private Integer perfectGame;

    @Field("pick_kill_with_ally")
    private Integer pickKillWithAlly;

    @Field("played_champ_select_position")
    private Integer playedChampSelectPosition;

    @Field("poro_explosions")
    private Integer poroExplosions;

    @Field("quick_cleanse")
    private Integer quickCleanse;

    @Field("quick_first_turret")
    private Integer quickFirstTurret;

    @Field("quick_solo_kills")
    private Integer quickSoloKills;

    @Field("rift_herald_takedowns")
    private Integer riftHeraldTakedowns;

    @Field("save_ally_from_death")
    private Integer saveAllyFromDeath;

    @Field("scuttle_crab_kills")
    private Integer scuttleCrabKills;

    @Field("shortest_time_to_ace_from_first_takedown")
    private Double shortestTimeToAceFromFirstTakedown;

    @Field("skillshots_dodged")
    private Integer skillshotsDodged;

    @Field("skillshots_hit")
    private Integer skillshotsHit;

    @Field("snowballs_hit")
    private Integer snowballsHit;

    @Field("solo_baron_kills")
    private Integer soloBaronKills;

    @Field("solo_kills")
    private Integer soloKills;

    @Field("solo_turrets_lategame")
    private Integer soloTurretsLategame;

    @Field("stealth_wards_placed")
    private Integer stealthWardsPlaced;

    @Field("survived_single_digit_hp_count")
    private Integer survivedSingleDigitHpCount;

    @Field("survived_three_immobilizes_in_fight")
    private Integer survivedThreeImmobilizesInFight;

    @Field("swarm_defeat_aatrox")
    private Integer swarmDefeatAatrox;

    @Field("swarm_defeat_briar")
    private Integer swarmDefeatBriar;

    @Field("swarm_defeat_mini_bosses")
    private Integer swarmDefeatMiniBosses;

    @Field("swarm_evolve_weapon")
    private Integer swarmEvolveWeapon;

    @Field("swarm_have_3_passives")
    private Integer swarmHave3Passives;

    @Field("swarm_kill_enemy")
    private Integer swarmKillEnemy;

    @Field("swarm_pickup_gold")
    private Integer swarmPickupGold;

    @Field("swarm_reach_level_50")
    private Integer swarmReachLevel50;

    @Field("swarm_survive_15_min")
    private Integer swarmSurvive15Min;

    @Field("swarm_win_with_5_evolved_weapons")
    private Integer swarmWinWith5EvolvedWeapons;

    @Field("takedown_on_first_turret")
    private Integer takedownOnFirstTurret;

    @Field("takedowns")
    private Integer takedowns;

    @Field("takedowns_after_gaining_level_advantage")
    private Integer takedownsAfterGainingLevelAdvantage;

    @Field("takedowns_before_jungle_minion_spawn")
    private Integer takedownsBeforeJungleMinionSpawn;

    @Field("takedowns_first_x_minutes")
    private Integer takedownsFirstXMinutes;

    @Field("takedowns_in_alcove")
    private Integer takedownsInAlcove;

    @Field("takedowns_in_enemy_fountain")
    private Integer takedownsInEnemyFountain;

    @Field("team_baron_kills")
    private Integer teamBaronKills;

    @Field("team_damage_percentage")
    private Double teamDamagePercentage;

    @Field("team_elder_dragon_kills")
    private Integer teamElderDragonKills;

    @Field("team_rift_herald_kills")
    private Integer teamRiftHeraldKills;

    @Field("teleport_takedowns")
    private Integer teleportTakedowns;

    @Field("took_large_damage_survived")
    private Integer tookLargeDamageSurvived;

    @Field("turret_plates_taken")
    private Integer turretPlatesTaken;

    @Field("turret_takedowns")
    private Integer turretTakedowns;

    @Field("turrets_taken_with_rift_herald")
    private Integer turretsTakenWithRiftHerald;

    @Field("twenty_minions_in_3_seconds_count")
    private Integer twentyMinionsIn3SecondsCount;

    @Field("two_wards_one_sweeper_count")
    private Integer twoWardsOneSweeperCount;

    @Field("unseen_recalls")
    private Integer unseenRecalls;

    @Field("vision_score_advantage_lane_opponent")
    private Double visionScoreAdvantageLaneOpponent;

    @Field("vision_score_per_minute")
    private Double visionScorePerMinute;

    @Field("void_monster_kill")
    private Integer voidMonsterKill;

    @Field("ward_takedowns")
    private Integer wardTakedowns;

    @Field("ward_takedowns_before_20m")
    private Integer wardTakedownsBefore20M;

    @Field("wards_guarded")
    private Integer wardsGuarded;

}
