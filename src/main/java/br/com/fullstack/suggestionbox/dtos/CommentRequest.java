package br.com.fullstack.suggestionbox.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Comment request")
public class CommentRequest extends CommentAbstract{

}
