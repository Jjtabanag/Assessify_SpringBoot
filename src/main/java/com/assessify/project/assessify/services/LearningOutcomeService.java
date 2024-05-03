package com.assessify.project.assessify.services;

import com.assessify.project.assessify.models.LearningOutcome;
import com.assessify.project.assessify.models.Section;
import com.assessify.project.assessify.repositories.LearningOutcomeRepository;

public class LearningOutcomeService {

    LearningOutcomeRepository learningOutcomeRepository;

    public LearningOutcome addLearningOutcome(String learningOutcome, Section section) {
        return learningOutcomeRepository.save(new LearningOutcome(learningOutcome, section));
    }

    public LearningOutcome editLearningOutcome(int id, String learningOutcome) {
        LearningOutcome lo = learningOutcomeRepository.findById(Long.valueOf(id)).orElse(null);
        if (lo != null) {
            lo.setLearningOutcome(learningOutcome);
            learningOutcomeRepository.save(lo);
        }
        return lo;
    }

    public boolean deleteLearningOutcome(int id) {
        LearningOutcome lo = learningOutcomeRepository.findById(Long.valueOf(id)).orElse(null);
        if (lo != null) {
            learningOutcomeRepository.delete(lo);
            return true;
        }
        return false;
    }
}
