package br.com.fullstack.suggestionbox.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "suggestions")
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 2048)
    private String description;

    private LocalDateTime entryTime;

    private LocalDateTime updateTime;



}
