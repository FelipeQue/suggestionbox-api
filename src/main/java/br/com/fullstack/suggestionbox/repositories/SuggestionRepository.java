package br.com.fullstack.suggestionbox.repositories;

import br.com.fullstack.suggestionbox.entities.Suggestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {

    Page<Suggestion>findAllByOrderByUpdatedAtDesc(Pageable pageable);

    Page<Suggestion>findAllByTitleContainingIgnoreCaseOrderByUpdatedAtDesc(String title, Pageable pageable);

}
