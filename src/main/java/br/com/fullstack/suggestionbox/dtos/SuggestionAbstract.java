package br.com.fullstack.suggestionbox.dtos;
import jakarta.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public abstract class SuggestionAbstract {

    @NotEmpty(message = "Title cannot be empty.")
    private String title;

    @NotEmpty(message = "Description cannot be empty.")
    private String description;
}
