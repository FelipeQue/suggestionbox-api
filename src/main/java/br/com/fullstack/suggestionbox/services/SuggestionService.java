package br.com.fullstack.suggestionbox.services;

import br.com.fullstack.suggestionbox.dtos.SuggestionRequest;
import br.com.fullstack.suggestionbox.dtos.SuggestionResponse;

public interface SuggestionService {

    SuggestionResponse create(SuggestionRequest request);

}
