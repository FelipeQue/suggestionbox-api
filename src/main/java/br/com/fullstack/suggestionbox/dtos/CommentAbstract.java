package br.com.fullstack.suggestionbox.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(description = "Base class for comments, intended for inheritance")
public abstract class CommentAbstract {

    @Schema(
            description = "Comment content",
            example = "Ótima sugestão, camarada!"
    )
    @NotEmpty(message = "Comment cannot be empty.")
    private String text;

}
