package org.willwin.jhin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.willwin.jhin.model.document.feature.MatchFeatureDocument;

@Repository
public interface MatchFeatureRepository extends MongoRepository<MatchFeatureDocument, String>
{

}
