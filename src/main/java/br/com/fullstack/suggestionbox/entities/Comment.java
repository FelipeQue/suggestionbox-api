package br.com.fullstack.suggestionbox.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Suggestion suggestion;

    @Column(nullable = false)
    private String text;

    private LocalDateTime entryTime;



}
