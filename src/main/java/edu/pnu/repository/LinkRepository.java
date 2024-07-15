package edu.pnu.repository;

import edu.pnu.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {
    @Query(value = "SELECT * FROM maindata l WHERE l.course_id = ?", nativeQuery = true)
    List<Link> findByCourse_id(Long course_id);
}
