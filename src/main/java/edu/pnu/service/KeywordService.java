package edu.pnu.service;

import edu.pnu.domain.Senti_keyword;
import edu.pnu.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    public List<Senti_keyword> getAll() {
        return  keywordRepository.findAll();
    }
    public List<Senti_keyword> getById(Integer courseId) {
        return keywordRepository.findAllByCourseId(courseId);
    }
}
