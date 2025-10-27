package org.willwin.jhin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.willwin.jhin.model.document.feature.MatchupPredictionDocument;

import java.util.Optional;

public interface MatchupPredictionRepository extends MongoRepository<MatchupPredictionDocument, String> {
    Optional<MatchupPredictionDocument> findTopByChampionIdOrderByGameVersionDesc(Integer championId);
    Optional<MatchupPredictionDocument> findByChampionId(Integer championId);
}
