package edu.pnu.repository;

import edu.pnu.domain.Unemployed_ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnemployedAdRepository extends JpaRepository<Unemployed_ad,Long> {
}
