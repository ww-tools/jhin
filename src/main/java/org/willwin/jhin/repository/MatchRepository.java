package org.willwin.jhin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.willwin.jhin.model.document.match.MatchDocument;

@Repository
public interface MatchRepository extends MongoRepository<MatchDocument, String>
{

}
