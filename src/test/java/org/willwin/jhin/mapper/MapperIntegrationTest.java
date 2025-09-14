package org.willwin.jhin.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.willwin.jhin.document.account.AccountDocument;
import org.willwin.jhin.document.match.MatchDocument;
import org.willwin.jhin.document.summoner.SummonerDocument;
import org.willwin.jhin.domain.riot.account.Account;
import org.willwin.jhin.domain.riot.match.Match;
import org.willwin.jhin.domain.riot.match.MatchInfo;
import org.willwin.jhin.domain.riot.match.MatchMetadata;
import org.willwin.jhin.domain.riot.summoner.Summoner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test to verify MapStruct mappers are properly configured and working with Spring Boot.
 */
@SpringBootTest
class MapperIntegrationTest
{

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private SummonerMapper summonerMapper;

    @Test
    void testAccountMapperInjection()
    {
        assertThat(accountMapper).isNotNull();
    }

    @Test
    void testSummonerMapperInjection()
    {
        assertThat(summonerMapper).isNotNull();
    }

    @Test
    void testMatchMapperInjection()
    {
        assertThat(matchMapper).isNotNull();
    }

    @Test
    void testAccountMapping()
    {
        // Given
        Account account = Account
                .builder()
                .gameName("TestPlayer")
                .puuid("test-puuid-123")
                .tagLine("EUW")
                .build();

        // When
        AccountDocument document = accountMapper.toDocument(account);

        // Then
        assertThat(document).isNotNull();
        assertThat(document.getGameName()).isEqualTo("TestPlayer");
        assertThat(document.getPuuid()).isEqualTo("test-puuid-123");
        assertThat(document.getTagLine()).isEqualTo("EUW");
        assertThat(document.getId()).isEqualTo(
                "test-puuid-123"); // PUUID mapped to ID

        // Test reverse mapping
        Account mappedBack = accountMapper.toDomain(document);
        assertThat(mappedBack.getGameName()).isEqualTo(account.getGameName());
        assertThat(mappedBack.getPuuid()).isEqualTo(account.getPuuid());
        assertThat(mappedBack.getTagLine()).isEqualTo(account.getTagLine());
    }

    @Test
    void testSummonerMapping()
    {
        // Given
        Summoner summoner = Summoner
                .builder()
                .profileIconId(123)
                .puuid("summoner-puuid-456")
                .revisionDate(1234567890L)
                .summonerLevel(30)
                .build();

        // When
        SummonerDocument document = summonerMapper.toDocument(summoner);

        // Then
        assertThat(document).isNotNull();
        assertThat(document.getProfileIconId()).isEqualTo(123);
        assertThat(document.getPuuid()).isEqualTo("summoner-puuid-456");
        assertThat(document.getRevisionDate()).isEqualTo(1234567890L);
        assertThat(document.getSummonerLevel()).isEqualTo(30);
        assertThat(document.getId()).isEqualTo(
                "summoner-puuid-456"); // PUUID mapped to ID

        // Test reverse mapping
        Summoner mappedBack = summonerMapper.toDomain(document);
        assertThat(mappedBack.getProfileIconId()).isEqualTo(
                summoner.getProfileIconId());
        assertThat(mappedBack.getPuuid()).isEqualTo(summoner.getPuuid());
        assertThat(mappedBack.getRevisionDate()).isEqualTo(
                summoner.getRevisionDate());
        assertThat(mappedBack.getSummonerLevel()).isEqualTo(
                summoner.getSummonerLevel());
    }

    @Test
    void testMatchMapping()
    {
        // Given - Simple match with basic info and metadata
        MatchMetadata metadata = MatchMetadata
                .builder()
                .matchId("EUW1_1234567890")
                .build();

        MatchInfo info = MatchInfo
                .builder()
                .gameId(1234567890L)
                .gameDuration(1800)
                .build();

        Match match = Match.builder().metadata(metadata).info(info).build();

        // When
        MatchDocument document = matchMapper.toDocument(match);

        // Then
        assertThat(document).isNotNull();
        assertThat(document.getMetadata()).isNotNull();
        assertThat(document.getInfo()).isNotNull();
        assertThat(document.getMetadata().getMatchId()).isEqualTo(
                "EUW1_1234567890");
        assertThat(document.getInfo().getGameId()).isEqualTo(1234567890L);
        assertThat(document.getInfo().getGameDuration()).isEqualTo(1800L);

        // Test reverse mapping
        Match mappedBack = matchMapper.toDomain(document);
        assertThat(mappedBack.getMetadata().getMatchId()).isEqualTo(
                match.getMetadata().getMatchId());
        assertThat(mappedBack.getInfo().getGameId()).isEqualTo(
                match.getInfo().getGameId());
        assertThat(mappedBack.getInfo().getGameDuration()).isEqualTo(
                match.getInfo().getGameDuration());
    }

}
