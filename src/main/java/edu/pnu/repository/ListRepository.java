package edu.pnu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Edu_list;


public interface ListRepository extends JpaRepository<Edu_list, Long>{
    // 1~6번째 위치한 숫자와 입력받은 숫자가 같은 데이터 선택
    @Query(value="SELECT * FROM final_data n WHERE SUBSTRING(n.ncs_num, 1, 6) = :codePart", nativeQuery=true)
    List<Edu_list> findByNcsCodeFirstSix(@Param("codePart") String codePart);
 
    // 1~6번째 위치한 숫자와 입력받은 숫자가 같은 데이터 선택 & starrating기준으로 내림차순 정렬
    @Query(value="SELECT * FROM final_data n WHERE n.starrating <> '0' and SUBSTRING(n.ncs_num, 1, 6) = :codePart ORDER BY n.starrating DESC", nativeQuery=true)
    List<Edu_list> findByNcsCodeFirstSixSortByRating(@Param("codePart") String codePart);

    @Query(value="SELECT * FROM (SELECT * FROM final_data WHERE SUBSTRING(ncs_num, 1, 6) = :codePart) f JOIN sentiment_avg s ON f.id=s.sid WHERE ps > 0 ORDER BY ps DESC", nativeQuery=true)
    List<Edu_list> findByNcsCodeFirstSixSortByPs(@Param("codePart") String codePart);
    
   
}
