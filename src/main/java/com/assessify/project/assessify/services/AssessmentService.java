package com.assessify.project.assessify.services;

import com.assessify.project.assessify.models.Assessment;
import com.assessify.project.assessify.models.AssessmentType;
import com.assessify.project.assessify.models.User;
import com.assessify.project.assessify.repositories.AssessmentRepository;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    public Assessment addAssessment(String name, AssessmentType type, String description, String lesson, int noOfQuestions, User user, Date dateCreated) {
        return assessmentRepository.save(new Assessment(name, type, description, lesson, noOfQuestions, user, dateCreated));
    }

    public Assessment editAssessment(int id, String name, AssessmentType type, String description, String lesson, int noOfQuestions, User user) {
        Assessment a = assessmentRepository.findById(Long.valueOf(id)).orElse(null);
        if (a != null) {
            a.setName(name);
            a.setType(type);
            a.setDescription(description);
            a.setLesson(lesson);
            a.setNoOfQuestions(noOfQuestions);
            assessmentRepository.save(a);
        }
        return a;
    }

    public boolean deleteAssessment(int id) {
        Assessment a = assessmentRepository.findById(Long.valueOf(id)).orElse(null);
        if (a != null) {
            assessmentRepository.delete(a);
            return true;
        }
        return false;
    }
}
