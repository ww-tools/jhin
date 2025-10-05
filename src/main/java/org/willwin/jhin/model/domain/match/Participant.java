package org.willwin.jhin.model.domain.match;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object representing a participant (player) in a League of Legends match.
 * Contains comprehensive statistics, items, runes, and performance data for a single player.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Participant
{

    // Ping statistics
    private Integer allInPings;

    private Integer assistMePings;

    // Core match statistics
    private Integer assists;

    private Integer baronKills;

    private Integer basicPings;

    // Complex nested objects
    private Challenges challenges;

    private Integer champExperience;

    private Integer champLevel;

    private Integer championId;

    private String championName;

    private Integer championTransform;

    private Integer commandPings;

    private Integer consumablesPurchased;

    private Integer damageDealtToBuildings;

    private Integer damageDealtToObjectives;

    private Integer damageDealtToTurrets;

    private Integer damageSelfMitigated;

    private Integer dangerPings;

    private Integer deaths;

    private Integer detectorWardsPlaced;

    private Integer doubleKills;

    private Integer dragonKills;

    private Boolean eligibleForProgression;

    private Integer enemyMissingPings;

    private Integer enemyVisionPings;

    private Boolean firstBloodAssist;

    private Boolean firstBloodKill;

    private Boolean firstTowerAssist;

    private Boolean firstTowerKill;

    private Boolean gameEndedInEarlySurrender;

    private Boolean gameEndedInSurrender;

    private Integer getBackPings;

    private Integer goldEarned;

    private Integer goldSpent;

    private Integer holdPings;

    private IndividualPosition individualPosition;

    private Integer inhibitorKills;

    private Integer inhibitorTakedowns;

    private Integer inhibitorsLost;

    // Items (0-6)
    private Integer item0;

    private Integer item1;

    private Integer item2;

    private Integer item3;

    private Integer item4;

    private Integer item5;

    private Integer item6;

    private Integer itemsPurchased;

    private Integer killingSprees;

    private Integer kills;

    private Lane lane;

    private Integer largestCriticalStrike;

    private Integer largestKillingSpree;

    private Integer largestMultiKill;

    private Integer longestTimeSpentLiving;

    private Integer magicDamageDealt;

    private Integer magicDamageDealtToChampions;

    private Integer magicDamageTaken;

    private Missions missions;

    private Integer needVisionPings;

    private Integer neutralMinionsKilled;

    private Integer nexusKills;

    private Integer nexusLost;

    private Integer nexusTakedowns;

    private Integer objectivesStolen;

    private Integer objectivesStolenAssists;

    private Integer onMyWayPings;

    private Integer participantId;

    private Integer pentaKills;

    private Perks perks;

    private Integer physicalDamageDealt;

    private Integer physicalDamageDealtToChampions;

    private Integer physicalDamageTaken;

    private Integer placement;

    // Player augments (1-6)
    private Integer playerAugment1;

    private Integer playerAugment2;

    private Integer playerAugment3;

    private Integer playerAugment4;

    private Integer playerAugment5;

    private Integer playerAugment6;

    // Basic player score fields
    private Integer playerScore0;

    private Integer playerScore1;

    private Integer playerScore10;

    private Integer playerScore11;

    private Integer playerScore2;

    private Integer playerScore3;

    private Integer playerScore4;

    private Integer playerScore5;

    private Integer playerScore6;

    private Integer playerScore7;

    private Integer playerScore8;

    private Integer playerScore9;

    private Integer playerSubteamId;

    private Integer profileIcon;

    private Integer pushPings;

    private String puuid;

    private Integer quadraKills;

    private Integer retreatPings;

    private String riotIdGameName;

    private String riotIdTagline;

    private Role role;

    private Integer sightWardsBoughtInGame;

    // Spell casts (1-4)
    private Integer spell1Casts;

    private Integer spell2Casts;

    private Integer spell3Casts;

    private Integer spell4Casts;

    private Integer subteamPlacement;

    // Summoner spells (1-2)
    private Integer summoner1Casts;

    private Integer summoner1Id;

    private Integer summoner2Casts;

    private Integer summoner2Id;

    private String summonerId;

    private Integer summonerLevel;

    private String summonerName;

    private Boolean teamEarlySurrendered;

    private Integer teamId;

    private IndividualPosition teamPosition;

    private Integer timeCCingOthers;

    private Integer timePlayed;

    private Integer totalAllyJungleMinionsKilled;

    private Integer totalDamageDealt;

    private Integer totalDamageDealtToChampions;

    private Integer totalDamageShieldedOnTeammates;

    private Integer totalDamageTaken;

    private Integer totalEnemyJungleMinionsKilled;

    private Integer totalHeal;

    private Integer totalHealsOnTeammates;

    private Integer totalMinionsKilled;

    private Integer totalTimeCCDealt;

    private Integer totalTimeSpentDead;

    private Integer totalUnitsHealed;

    private Integer tripleKills;

    private Integer trueDamageDealt;

    private Integer trueDamageDealtToChampions;

    private Integer trueDamageTaken;

    private Integer turretKills;

    private Integer turretTakedowns;

    private Integer turretsLost;

    private Integer unrealKills;

    private Integer visionClearedPings;

    private Integer visionScore;

    private Integer visionWardsBoughtInGame;

    private Integer wardsKilled;

    private Integer wardsPlaced;

    private Boolean win;

}
