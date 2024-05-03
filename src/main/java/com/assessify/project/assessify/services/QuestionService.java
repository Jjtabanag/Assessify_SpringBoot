package com.assessify.project.assessify.services;

import com.assessify.project.assessify.models.Question;
import com.assessify.project.assessify.models.Section;
import com.assessify.project.assessify.repositories.QuestionRepository;

public class QuestionService {

    QuestionRepository questionRepository;

    public Question addQuestion(int questionNo, String question, String answer, Section section) {
        return questionRepository.save(new Question(questionNo, question, answer, section));
    }

    public Question editQuestion(int id, int questionNo, String question, String answer) {
        Question q = questionRepository.findById(Long.valueOf(id)).orElse(null);
        if(q != null) {
            q.setQuestionNo(questionNo);
            q.setQuestion(question);
            q.setAnswer(answer);
            questionRepository.save(q);
        }
        return q;
    }

    public boolean deleteQuestion(int id) {
        Question q = questionRepository.findById(Long.valueOf(id)).orElse(null);
        if(q != null) {
            questionRepository.delete(q);
            return true;
        }
        return false;
    }
}
