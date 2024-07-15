package edu.pnu.repository;

import edu.pnu.domain.Owner_ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerAdRepository extends JpaRepository<Owner_ad,Long> {
    Optional<Owner_ad> findById(Long id);
}
