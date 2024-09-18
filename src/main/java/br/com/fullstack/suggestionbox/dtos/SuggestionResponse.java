package br.com.fullstack.suggestionbox.dtos;

import br.com.fullstack.suggestionbox.entities.Suggestion;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "Suggestion response")
public class SuggestionResponse extends SuggestionAbstract{

    @Schema(description = "Suggestion id", example = "1")
    private Long id;

    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Schema(description = "Date and time of creation", example = "10/10/2023 10:10")
    private LocalDateTime createdAt;

    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Schema(description = "Date and time the suggestion was updated or commented on", example = "10/10/2023 10:11")
    private LocalDateTime updatedAt;

    public SuggestionResponse(Suggestion suggestion) {
        BeanUtils.copyProperties(suggestion, this);
    }

}
