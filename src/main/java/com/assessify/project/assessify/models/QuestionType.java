package com.assessify.project.assessify.models;

import jakarta.persistence.*;

@Entity
@Table(name = "question_types")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String type;

    public QuestionType(String type) {
        this.type = type;
    }
// Getters and setters

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
