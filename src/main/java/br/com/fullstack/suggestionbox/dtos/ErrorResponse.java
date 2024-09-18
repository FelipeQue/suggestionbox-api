package br.com.fullstack.suggestionbox.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Schema(description = "Error response")
public class ErrorResponse {

    @Schema(description = "Exception class", example = "Exception")
    private String exceptionClass;

    @Schema(description = "Error code", example = "404")
    private String code;

    @Schema(description = "Error message", example = "Entity not found with id 1.")
    private String message;

    @Schema(description = "Fields where error happened",
            type = "array",
            example = "[\"title\", \"description\"]")
    private List<String> fields;


}
