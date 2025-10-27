package org.willwin.jhin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.willwin.jhin.model.document.feature.MatchupPredictionDocument;
import org.willwin.jhin.repository.MatchupPredictionRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/matchups")
@CrossOrigin(origins = {"http://localhost:3000"})
class MatchupPredictionController {

    private final MatchupPredictionRepository repository;

    public MatchupPredictionController(MatchupPredictionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{championId}")
    public ResponseEntity<Map<Integer, List<Integer>>> getMatchupsByChampion(@PathVariable Integer championId) {
        return repository.findTopByChampionIdOrderByGameVersionDesc(championId)
                .or(() -> repository.findByChampionId(championId))
                .map(MatchupPredictionDocument::getMatchups)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Integer>> listChampionIdsWithPredictions() {
        List<Integer> ids = repository.findAll().stream()
                .map(MatchupPredictionDocument::getChampionId)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return ResponseEntity.ok(ids);
    }
}
