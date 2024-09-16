package br.com.fullstack.suggestionbox.repositories;

import br.com.fullstack.suggestionbox.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
