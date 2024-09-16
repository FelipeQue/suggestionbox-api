package br.com.fullstack.suggestionbox.dtos;

import br.com.fullstack.suggestionbox.entities.Suggestion;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SuggestionResponse extends SuggestionAbstract{

    private Long id;
    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdAt;
    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime updatedAt;

    public SuggestionResponse(Suggestion suggestion) {
        BeanUtils.copyProperties(suggestion, this);
    }

}
