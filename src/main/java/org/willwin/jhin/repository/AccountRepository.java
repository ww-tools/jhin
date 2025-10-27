package org.willwin.jhin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.willwin.jhin.model.document.account.AccountDocument;

import java.util.Optional;

public interface AccountRepository
        extends MongoRepository<AccountDocument, String>
{

    Optional<AccountDocument> findByGameNameAndTagLine(
            String gameName,
            String tagLine);

}
