package org.willwin.jhin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.willwin.jhin.model.document.feature.MatchFeatureDocument;

public interface MatchFeatureRepository extends MongoRepository<MatchFeatureDocument, String>
{

}
