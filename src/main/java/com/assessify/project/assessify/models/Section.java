package com.assessify.project.assessify.models;

import jakarta.persistence.*;

@Entity
@Table(name = "sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int sectionNo;

    @Column(length = 64)
    private String name;

    @Column(length = 64)
    private String description;

    @Column(nullable = false)
    private int length;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private QuestionType type;

    @ManyToOne
    @JoinColumn(name = "assessment_id", nullable = false)
    private Assessment assessment;

    public Section(int sectionNo, String name, String description, int length, QuestionType type, Assessment assessment) {
        this.sectionNo = sectionNo;
        this.name = name;
        this.description = description;
        this.length = length;
        this.type = type;
        this.assessment = assessment;
    }
// Getters and setters

    public Long getId() {
        return id;
    }

    public int getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(int sectionNo) {
        this.sectionNo = sectionNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }
}