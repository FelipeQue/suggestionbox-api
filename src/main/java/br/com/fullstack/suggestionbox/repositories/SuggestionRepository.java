package br.com.fullstack.suggestionbox.repositories;

import br.com.fullstack.suggestionbox.entities.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {



}
