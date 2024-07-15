package edu.pnu.repository;

import edu.pnu.domain.Labor_ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborAdRepository extends JpaRepository<Labor_ad,Long> {
}
