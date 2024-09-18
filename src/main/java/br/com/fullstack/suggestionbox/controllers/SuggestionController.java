package br.com.fullstack.suggestionbox.controllers;

import br.com.fullstack.suggestionbox.dtos.*;
import br.com.fullstack.suggestionbox.services.SuggestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("suggestions")
@Tag(name = "Suggestions", description = "Create and read suggestions, add comments to a suggestion.")
public class SuggestionController {

    private final SuggestionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create a new suggestion.", summary = "Create suggestion")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Success!") })
    public SuggestionResponse create(@Valid @RequestBody SuggestionRequest request){
        log.info("POST /suggestions -> Controller called.");
        return service.create(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "List all suggestions.", summary = "List suggestions")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success!") })
    public Page<SuggestionResponse> list(
            @RequestParam(required = false) @ParameterObject() SuggestionFilter filter,
            @ParameterObject() @PageableDefault(size = 15) Pageable pageable){
        log.info("GET /suggestions -> Controller called.");
        return service.list(filter, pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Find a specific suggestion by id.", summary = "Find suggestion by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success!") })
    public SuggestionDetailResponse search(
            @Parameter(example = "1", description = "Suggestion id.") @PathVariable(name = "id") Long id){
        log.info("GET /suggestions/{id} -> Controller called.");
        return service.search(id);
    }

    @PostMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Add a comment to a suggestion, using the suggestion id.", summary = "Add comment")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Success!") })
    public CommentResponse addComment(
            @Parameter(example = "1", description = "Suggestion id.") @PathVariable(name = "id") Long suggestionId,
            @Valid @RequestBody CommentRequest request){
        log.info("POST /suggestions/{id}/comments -> Controller called.");
        return service.addComment(suggestionId, request);
    }


}
