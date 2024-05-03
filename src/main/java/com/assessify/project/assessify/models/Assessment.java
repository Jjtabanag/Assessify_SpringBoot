package com.assessify.project.assessify.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "assessments")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 128)
    private String name;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private AssessmentType type;

    @Column(nullable = false)
    @Lob
    private String description;

    @Column(nullable = false)
    @Lob
    private String lesson;

    @Column(nullable = false)
    private int noOfQuestions;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateCreated;

    public Assessment(String name, AssessmentType type, String description, String lesson, int noOfQuestions, User user, Date dateCreated) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.lesson = lesson;
        this.noOfQuestions = noOfQuestions;
        this.user = user;
        this.dateCreated = dateCreated;
    }
// Getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AssessmentType getType() {
        return type;
    }

    public void setType(AssessmentType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
