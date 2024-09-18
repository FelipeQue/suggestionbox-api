package br.com.fullstack.suggestionbox.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Suggestion request")
public class SuggestionRequest extends SuggestionAbstract{
}
