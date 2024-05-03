package com.assessify.project.assessify.repositories;

import com.assessify.project.assessify.models.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {
}
