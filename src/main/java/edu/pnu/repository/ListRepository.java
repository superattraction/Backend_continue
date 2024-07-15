package edu.pnu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Edu_list;


public interface ListRepository extends JpaRepository<Edu_list, Long>{
    // 1~6번째 위치한 숫자와 입력받은 숫자가 같은 데이터 선택
    @Query(value="SELECT f.* FROM job2.maindata f WHERE SUBSTRING(f.ncs_num, 1, 6) = :codePart", nativeQuery=true)
    List<Edu_list> findByNcsCodeFirstSix(@Param("codePart") String codePart);

    @Query(value="SELECT * FROM job2.maindata n WHERE n.starrating <> '0' and SUBSTRING(n.ncs_num, 1, 6) = :codePart ORDER BY n.starrating DESC", nativeQuery=true)
    List<Edu_list> findByNcsCodeFirstSixSortByRating(@Param("codePart") String codePart);

    @Query(value = "SELECT f.* " +
            "FROM job2.maindata f " +
            "JOIN job2.summary_review s ON f.course_id = s.course_id " +
            "WHERE SUBSTRING(f.ncs_num, 1, 6) = :codePart " +
            "ORDER BY s.ps IS NULL, s.ps DESC",
            nativeQuery = true)
    List<Edu_list> findByNcsCodeFirstSixSortByPs(@Param("codePart") String codePart);

}
