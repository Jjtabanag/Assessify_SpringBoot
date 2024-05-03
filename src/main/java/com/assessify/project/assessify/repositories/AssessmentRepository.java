package com.assessify.project.assessify.repositories;

import com.assessify.project.assessify.models.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
