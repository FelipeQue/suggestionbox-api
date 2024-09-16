package br.com.fullstack.suggestionbox.services;

import br.com.fullstack.suggestionbox.dtos.SuggestionRequest;
import br.com.fullstack.suggestionbox.dtos.SuggestionResponse;
import br.com.fullstack.suggestionbox.entities.Suggestion;
import br.com.fullstack.suggestionbox.repositories.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService{

    private final SuggestionRepository repository;

    @Override
    public SuggestionResponse create(SuggestionRequest request) {
        log.info("POST /suggestions -> Service called.");
        Suggestion suggestion = new Suggestion(request);
        suggestion.setCreatedAt(LocalDateTime.now());
        suggestion.setUpdatedAt(LocalDateTime.now());
        Suggestion savedSuggestion = repository.save(suggestion);
        log.info("POST /suggestions -> Created suggestion with title " + suggestion.getTitle());
        return new SuggestionResponse(savedSuggestion);
    }
}
