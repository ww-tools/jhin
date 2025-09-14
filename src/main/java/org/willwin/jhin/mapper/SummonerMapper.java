package org.willwin.jhin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.willwin.jhin.document.summoner.SummonerDocument;
import org.willwin.jhin.domain.riot.summoner.Summoner;
import org.willwin.jhin.mapper.config.BaseMapperConfig;

/**
 * MapStruct mapper for converting between Summoner domain objects and SummonerDocument.
 * This mapper handles the transformation from domain model to MongoDB document model.
 */
@Mapper(config = BaseMapperConfig.class)
public interface SummonerMapper
{

    /**
     * Maps a Summoner domain object to SummonerDocument.
     * The PUUID is mapped to both the puuid field and id field (using PUUID as document ID).
     * BaseDocument audit fields (createdBy, createdDate, etc.) are ignored during mapping
     * as they are handled by MongoDB auditing.
     *
     * @param summoner the Summoner domain object to map
     * @return the corresponding SummonerDocument
     */
    @Mapping(
            target = "id",
            source = "puuid"
    )
    SummonerDocument toDocument(Summoner summoner);

    /**
     * Maps a SummonerDocument back to Summoner domain object.
     * The id field is ignored during reverse mapping.
     *
     * @param document the SummonerDocument to map
     * @return the corresponding Summoner domain object
     */
    @Mapping(
            target = "puuid",
            source = "puuid"
    )
    Summoner toDomain(SummonerDocument document);

}
