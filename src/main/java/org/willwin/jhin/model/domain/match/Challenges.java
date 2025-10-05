package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Domain object representing challenge statistics for a participant in a League of Legends match.
 * Contains extensive challenge data tracking various achievements and performance metrics.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Challenges
{

    private Integer abilityUses;

    private Integer acesBefore15Minutes;

    private Integer alliedJungleMonsterKills;

    private Integer assistStreakCount;

    private Integer baronBuffGoldAdvantageOverThreshold;

    private Integer baronTakedowns;

    private Integer blastConeOppositeOpponentCount;

    private Double bountyGold;

    private Integer buffsStolen;

    private Integer completeSupportQuestInTime;

    private Double controlWardTimeCoverageInRiverOrEnemyHalf;

    private Integer controlWardsPlaced;

    private Double damagePerMinute;

    private Double damageTakenOnTeamPercentage;

    private Integer dancedWithRiftHerald;

    private Integer deathsByEnemyChamps;

    private Integer dodgeSkillShotsSmallWindow;

    private Integer doubleAces;

    private Integer dragonTakedowns;

    private Double earliestBaron;

    private Double earliestDragonTakedown;

    private Integer earlyLaningPhaseGoldExpAdvantage;

    private Double effectiveHealAndShielding;

    private Integer elderDragonKillsWithOpposingSoul;

    private Integer elderDragonMultikills;

    private Integer enemyChampionImmobilizations;

    private Integer enemyJungleMonsterKills;

    private Integer epicMonsterKillsNearEnemyJungler;

    private Integer epicMonsterKillsWithin30SecondsOfSpawn;

    private Integer epicMonsterSteals;

    private Integer epicMonsterStolenWithoutSmite;

    private Integer firstTurretKilled;

    private Double firstTurretKilledTime;

    private Integer fistBumpParticipation;

    private Integer flawlessAces;

    private Integer fullTeamTakedown;

    private Double gameLength;

    private Integer getTakedownsInAllLanesEarlyJungleAsLaner;

    private Double goldPerMinute;

    private Integer hadOpenNexus;

    private Double healFromMapSources;

    private Integer highestChampionDamage;

    private Integer highestCrowdControlScore;

    private Integer highestWardKills;

    private Integer immobilizeAndKillWithAlly;

    private Integer infernalScalePickup;

    private Integer initialBuffCount;

    private Integer initialCrabCount;

    private Double jungleCsBefore10Minutes;

    private Integer junglerKillsEarlyJungle;

    private Integer junglerTakedownsNearDamagedEpicMonster;

    private Integer kTurretsDestroyedBeforePlatesFall;

    private Double kda;

    private Integer killAfterHiddenWithAlly;

    private Double killParticipation;

    private Integer killedChampTookFullTeamDamageSurvived;

    private Integer killingSprees;

    private Integer killsNearEnemyTurret;

    private Integer killsOnLanersEarlyJungleAsJungler;

    private Integer killsOnOtherLanesEarlyJungleAsLaner;

    private Integer killsOnRecentlyHealedByAramPack;

    private Integer killsUnderOwnTurret;

    private Integer killsWithHelpFromEpicMonster;

    private Integer knockEnemyIntoTeamAndKill;

    private Integer landSkillShotsEarlyGame;

    private Integer laneMinionsFirst10Minutes;

    private Integer laningPhaseGoldExpAdvantage;

    private Integer legendaryCount;

    private List<Integer> legendaryItemUsed;

    private Integer lostAnInhibitor;

    private Double maxCsAdvantageOnLaneOpponent;

    private Integer maxKillDeficit;

    private Integer maxLevelLeadLaneOpponent;

    private Integer mejaisFullStackInTime;

    private Double moreEnemyJungleThanOpponent;

    private Integer multiKillOneSpell;

    private Integer multiTurretRiftHeraldCount;

    private Integer multikills;

    private Integer multikillsAfterAggressiveFlash;

    private Integer outerTurretExecutesBefore10Minutes;

    private Integer outnumberedKills;

    private Integer outnumberedNexusKill;

    private Integer perfectDragonSoulsTaken;

    private Integer perfectGame;

    private Integer pickKillWithAlly;

    private Integer playedChampSelectPosition;

    private Integer poroExplosions;

    private Integer quickCleanse;

    private Integer quickFirstTurret;

    private Integer quickSoloKills;

    private Integer riftHeraldTakedowns;

    private Integer saveAllyFromDeath;

    private Integer scuttleCrabKills;

    private Double shortestTimeToAceFromFirstTakedown;

    private Integer skillshotsDodged;

    private Integer skillshotsHit;

    private Integer snowballsHit;

    private Integer soloBaronKills;

    private Integer soloKills;

    private Integer soloTurretsLategame;

    private Integer stealthWardsPlaced;

    private Integer survivedSingleDigitHpCount;

    private Integer survivedThreeImmobilizesInFight;

    private Integer swarmDefeatAatrox;

    private Integer swarmDefeatBriar;

    private Integer swarmDefeatMiniBosses;

    private Integer swarmEvolveWeapon;

    private Integer swarmHave3Passives;

    private Integer swarmKillEnemy;

    private Integer swarmPickupGold;

    private Integer swarmReachLevel50;

    private Integer swarmSurvive15Min;

    private Integer swarmWinWith5EvolvedWeapons;

    private Integer takedownOnFirstTurret;

    private Integer takedowns;

    private Integer takedownsAfterGainingLevelAdvantage;

    private Integer takedownsBeforeJungleMinionSpawn;

    private Integer takedownsFirstXMinutes;

    private Integer takedownsInAlcove;

    private Integer takedownsInEnemyFountain;

    private Integer teamBaronKills;

    private Double teamDamagePercentage;

    private Integer teamElderDragonKills;

    private Integer teamRiftHeraldKills;

    private Integer teleportTakedowns;

    private Integer tookLargeDamageSurvived;

    private Integer turretPlatesTaken;

    private Integer turretTakedowns;

    private Integer turretsTakenWithRiftHerald;

    private Integer twentyMinionsIn3SecondsCount;

    private Integer twoWardsOneSweeperCount;

    private Integer unseenRecalls;

    private Double visionScoreAdvantageLaneOpponent;

    private Double visionScorePerMinute;

    private Integer voidMonsterKill;

    private Integer wardTakedowns;

    private Integer wardTakedownsBefore20M;

    private Integer wardsGuarded;

}
