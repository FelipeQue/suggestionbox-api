package br.com.fullstack.suggestionbox.dtos;

import br.com.fullstack.suggestionbox.entities.Suggestion;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
public class SuggestionDetailResponse extends SuggestionResponse{

    List<CommentResponse> comments;

    public SuggestionDetailResponse(Suggestion suggestion) {
        BeanUtils.copyProperties(suggestion, this);
    }

}
