package org.willwin.jhin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.willwin.jhin.document.account.AccountDocument;
import org.willwin.jhin.domain.riot.account.Account;
import org.willwin.jhin.mapper.configuration.BaseMapperConfiguration;

/**
 * MapStruct mapper for converting between Account domain objects and AccountDocument.
 * This mapper handles the transformation from domain model to MongoDB document model.
 */
@Mapper(config = BaseMapperConfiguration.class)
public interface AccountMapper
{

    /**
     * Maps an Account domain object to AccountDocument.
     * The PUUID is mapped to both the puuid field and id field (using PUUID as document ID).
     * BaseDocument audit fields (createdBy, createdDate, etc.) are ignored during mapping
     * as they are handled by MongoDB auditing.
     *
     * @param account the Account domain object to map
     * @return the corresponding AccountDocument
     */
    @Mapping(
            target = "id",
            source = "puuid"
    )
    AccountDocument toDocument(Account account);

    /**
     * Maps an AccountDocument back to Account domain object.
     * The id field is ignored during reverse mapping.
     *
     * @param document the AccountDocument to map
     * @return the corresponding Account domain object
     */
    @Mapping(
            target = "puuid",
            source = "puuid"
    )
    Account toDomain(AccountDocument document);

}
