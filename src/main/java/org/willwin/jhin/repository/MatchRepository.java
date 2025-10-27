package org.willwin.jhin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.willwin.jhin.model.document.match.MatchDocument;

public interface MatchRepository extends MongoRepository<MatchDocument, String>
{

}
