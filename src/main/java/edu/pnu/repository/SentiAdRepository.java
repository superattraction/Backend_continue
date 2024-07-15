package edu.pnu.repository;

import edu.pnu.domain.Senti_ad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentiAdRepository extends JpaRepository<Senti_ad,String> {
    List<Senti_ad> findAllByAddress(String Address);
}
