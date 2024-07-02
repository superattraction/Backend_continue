package edu.pnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Ncs;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Ncs, Long>{

}
