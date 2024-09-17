package br.com.fullstack.suggestionbox.repositories;

import br.com.fullstack.suggestionbox.entities.Comment;
import br.com.fullstack.suggestionbox.entities.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findBySuggestionOrderByCreatedAtDesc(Suggestion suggestion);

}
