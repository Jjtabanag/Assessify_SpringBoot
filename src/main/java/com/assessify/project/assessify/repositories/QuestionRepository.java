package com.assessify.project.assessify.repositories;

import com.assessify.project.assessify.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
