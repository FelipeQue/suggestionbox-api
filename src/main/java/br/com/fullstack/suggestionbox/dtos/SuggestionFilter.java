package br.com.fullstack.suggestionbox.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Filter parameters (search criteria)")
public class SuggestionFilter {

    @Schema(
            description = "Suggestion title (optional search criteria), case insensitive.",
            example = "Aplicar ideias"
    )
    private String title;

}
