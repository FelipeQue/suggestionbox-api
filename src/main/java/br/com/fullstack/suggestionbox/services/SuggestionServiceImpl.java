package br.com.fullstack.suggestionbox.services;

import br.com.fullstack.suggestionbox.dtos.SuggestionFilter;
import br.com.fullstack.suggestionbox.dtos.SuggestionRequest;
import br.com.fullstack.suggestionbox.dtos.SuggestionResponse;
import br.com.fullstack.suggestionbox.entities.Suggestion;
import br.com.fullstack.suggestionbox.repositories.SuggestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<SuggestionResponse> list(SuggestionFilter filter, Pageable pageable) {
        log.info("GET /suggestions -> Service called.");
        Page<Suggestion> suggestions;
        if (filter != null && filter.getTitle() != null){
            log.info("Filtering by title: " + filter.getTitle());
            String titleFilter = filter.getTitle();
            suggestions = repository.findAllByTitleContainingIgnoreCaseOrderByUpdatedAtDesc(titleFilter, pageable);
        } else {
            log.info("No filters where defined.");
            suggestions = repository.findAllByOrderByUpdatedAtDesc(pageable);
        }
        return suggestions.map(SuggestionResponse::new);
    }


}
