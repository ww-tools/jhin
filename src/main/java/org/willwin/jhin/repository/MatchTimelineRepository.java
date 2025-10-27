package org.willwin.jhin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.willwin.jhin.model.document.match.MatchTimelineDocument;

public interface MatchTimelineRepository
        extends MongoRepository<MatchTimelineDocument, String>
{

}
