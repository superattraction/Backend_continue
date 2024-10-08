package edu.pnu.repository;

import edu.pnu.domain.Senti_result_lg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentiLgRepository  extends JpaRepository<Senti_result_lg, Integer> {
    List<Senti_result_lg> findAllByNidOrderByNidAsc(Integer id);

}

