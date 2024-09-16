package br.com.fullstack.suggestionbox.entities;

import br.com.fullstack.suggestionbox.dtos.SuggestionRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "suggestions")
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 2048)
    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Suggestion(SuggestionRequest request) {
        BeanUtils.copyProperties(request, this);
    }


}
