package edu.pnu.repository;

import edu.pnu.domain.Senti_keyword;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Senti_keyword, Integer> {
    List<Senti_keyword> findAllByCourseId(Integer courseId);
}
