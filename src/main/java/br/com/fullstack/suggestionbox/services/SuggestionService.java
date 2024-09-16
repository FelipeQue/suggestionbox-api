package br.com.fullstack.suggestionbox.services;

import br.com.fullstack.suggestionbox.dtos.SuggestionFilter;
import br.com.fullstack.suggestionbox.dtos.SuggestionRequest;
import br.com.fullstack.suggestionbox.dtos.SuggestionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SuggestionService {

    SuggestionResponse create(SuggestionRequest request);

    Page<SuggestionResponse> list(SuggestionFilter filter, Pageable pageable);
}
