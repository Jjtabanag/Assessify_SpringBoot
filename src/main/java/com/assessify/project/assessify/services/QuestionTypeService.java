package com.assessify.project.assessify.services;

import com.assessify.project.assessify.models.QuestionType;
import com.assessify.project.assessify.repositories.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeService {

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    public QuestionType addQuestionType(String type) {
        return questionTypeRepository.save(new QuestionType(type));
    }
}
