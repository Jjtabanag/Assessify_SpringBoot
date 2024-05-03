package com.assessify.project.assessify.services;

import com.assessify.project.assessify.models.Assessment;
import com.assessify.project.assessify.models.QuestionType;
import com.assessify.project.assessify.models.Section;
import com.assessify.project.assessify.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    @Autowired
    SectionRepository sectionRepository;

    public Section addSection(int sectionNo, String name, String description, int length, QuestionType type, Assessment assessment) {
        return sectionRepository.save(new Section(sectionNo, name, description, length, type, assessment));
    }

    public Section editSection(int id, String name, String description, int length, QuestionType type) {
        Section s = sectionRepository.findById(Long.valueOf(id)).orElse(null);
        if (s != null) {
            s.setName(name);
            s.setDescription(description);
            s.setLength(length);
            s.setType(type);
            sectionRepository.save(s);
        }
        return s;
    }

    public boolean deleteSection(int id) {
        Section s = sectionRepository.findById(Long.valueOf(id)).orElse(null);
        if (s != null) {
            sectionRepository.delete(s);
            return true;
        }
        return false;
    }
}
