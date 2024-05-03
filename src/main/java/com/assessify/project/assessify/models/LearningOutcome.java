package com.assessify.project.assessify.models;

import jakarta.persistence.*;

@Entity
@Table(name = "learning_outcomes")
public class LearningOutcome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 256)
    private String learningOutcome;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    public LearningOutcome(String learningOutcome, Section section) {
        this.learningOutcome = learningOutcome;
        this.section = section;
    }
// Getters and setters

    public Long getId() {
        return id;
    }

    public String getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(String learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
