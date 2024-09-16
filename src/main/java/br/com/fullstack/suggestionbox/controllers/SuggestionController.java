package br.com.fullstack.suggestionbox.controllers;

import br.com.fullstack.suggestionbox.dtos.SuggestionRequest;
import br.com.fullstack.suggestionbox.dtos.SuggestionResponse;
import br.com.fullstack.suggestionbox.services.SuggestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("suggestions")
public class SuggestionController {

    private final SuggestionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuggestionResponse create(@RequestBody SuggestionRequest request){
        log.info("POST /suggestions -> Controller called.");
        return service.create(request);
    }


}
