package org.willwin.jhin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.willwin.jhin.model.document.account.AccountDocument;

@Repository
public interface AccountRepository extends MongoRepository<AccountDocument, String>
{

}
