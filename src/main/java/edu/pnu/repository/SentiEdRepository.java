package edu.pnu.repository;

import edu.pnu.domain.Senti_ed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentiEdRepository extends JpaRepository<Senti_ed, String> {
    List<Senti_ed> findAllByName(String name);
}
