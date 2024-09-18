package br.com.fullstack.suggestionbox.dtos;

import br.com.fullstack.suggestionbox.entities.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Schema(description = "Comment response")
public class CommentResponse extends CommentAbstract{

    @Schema(description = "Comment id", example = "1")
    private Long suggestionId;

    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Schema(description = "Date and time of creation", example = "10/10/2023 10:10")
    private LocalDateTime createdAt;

    public CommentResponse(Comment comment) {
        BeanUtils.copyProperties(comment, this);
    }

}
