package com.assessify.project.assessify.services;

import com.assessify.project.assessify.models.Option;
import com.assessify.project.assessify.models.Question;
import com.assessify.project.assessify.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

    @Autowired
    OptionRepository optionRepository;

    public Option addOption(Question question, int optionNo, String option) {
        return optionRepository.save(new Option(question, optionNo, option));
    }

    public Option editOption(int id, int optionNo, String option) {
        Option o = optionRepository.findById(Long.valueOf(id)).orElse(null);
        if (o != null) {
            o.setOptionNo(optionNo);
            o.setOption(option);
            optionRepository.save(o);
        }
        return o;
    }
}
