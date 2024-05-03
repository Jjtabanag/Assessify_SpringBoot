package com.assessify.project.assessify.repositories;

import com.assessify.project.assessify.models.LearningOutcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningOutcomeRepository extends JpaRepository<LearningOutcome, Long> {
}
