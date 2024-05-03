package com.assessify.project.assessify.services;

import com.assessify.project.assessify.models.QuestionType;
import com.assessify.project.assessify.repositories.QuestionTypeRepository;

public class QuestionTypeService {

    QuestionTypeRepository questionTypeRepository;

    public QuestionType addQuestionType(String type) {
        return questionTypeRepository.save(new QuestionType(type));
    }
}
