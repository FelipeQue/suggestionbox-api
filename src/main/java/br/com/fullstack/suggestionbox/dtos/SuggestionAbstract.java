package br.com.fullstack.suggestionbox.dtos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Schema(description = "Base class for suggestions, intended for inheritance")
public abstract class SuggestionAbstract {

    @Schema(
            description = "Suggestion title",
            example = "Mentoria"
    )
    @NotEmpty(message = "Title cannot be empty.")
    private String title;

    @Schema(
            description = "Suggestion description",
            example = "Gostaria de sugerir que a empresa considere implementar um programa de mentoria."
    )
    @NotEmpty(message = "Description cannot be empty.")
    private String description;
}
