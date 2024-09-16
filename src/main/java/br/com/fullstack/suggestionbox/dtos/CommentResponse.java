package br.com.fullstack.suggestionbox.dtos;

import br.com.fullstack.suggestionbox.entities.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CommentResponse extends CommentAbstract{

    private Long suggestionId;

    @JsonSerialize
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdAt;

    public CommentResponse(Comment comment) {
        BeanUtils.copyProperties(comment, this);
    }

}
