package edu.pnu.repository;

import edu.pnu.domain.Senti_training_type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentiTtRepository extends JpaRepository<Senti_training_type, String> {
    List<Senti_training_type> findByTrainingType(String trainingType);
}
