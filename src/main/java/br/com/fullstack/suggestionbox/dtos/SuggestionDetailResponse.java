package br.com.fullstack.suggestionbox.dtos;

import br.com.fullstack.suggestionbox.entities.Suggestion;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(description = "Suggestion response with comments")
public class SuggestionDetailResponse extends SuggestionResponse{

    @Schema(description = "List of comments",
            example = "[{\"text\": \"Ótimo comentário.\"," +
                    " \"suggestionId\": 1, \"createdAt\": \"16/09/2024 19:08\"}," +
                    "{\"text\": \"Concordo!\", \"suggestionId\": 1," +
                    "\"createdAt\": \"16/09/2024 19:04\"}]")
    List<CommentResponse> comments;

    public SuggestionDetailResponse(Suggestion suggestion) {
        BeanUtils.copyProperties(suggestion, this);
    }

}
