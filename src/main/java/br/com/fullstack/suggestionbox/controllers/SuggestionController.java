package br.com.fullstack.suggestionbox.controllers;

import br.com.fullstack.suggestionbox.dtos.*;
import br.com.fullstack.suggestionbox.services.SuggestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SuggestionResponse> list(SuggestionFilter filter, Pageable pageable){
        log.info("GET /suggestions -> Controller called.");
        return service.list(filter, pageable);
    }

    @PostMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse addComment(
            @PathVariable(name = "id") Long suggestionId,
            @RequestBody CommentRequest request){
        log.info("POST /suggestions/{id}/comments -> Controller called.");
        return service.addComment(suggestionId, request);
    }


}
