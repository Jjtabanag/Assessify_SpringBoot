package com.assessify.project.assessify.models;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int questionNo;

    @Column(nullable = false, length = 1024)
    @Lob
    private String question;

    @Column(length = 1024)
    @Lob
    private String answer;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    public Question(int questionNo, String question, String answer, Section section) {
        this.questionNo = questionNo;
        this.question = question;
        this.answer = answer;
        this.section = section;
    }
// Getters and setters

    public Long getId() {
        return id;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
