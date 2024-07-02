package edu.pnu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Senti_result;

public interface SentiRepository extends JpaRepository<Senti_result, Long>{
	// 1~6번째 위치한 숫자와 입력받은 숫자가 같은 데이터 선택 & 긍정점수기준으로 내림차순 정렬
    @Query(value="SELECT * FROM final_data n WHERE SUBSTRING(n.ncs_num, 1, 6) = :codePart", nativeQuery=true)
    List<Senti_result> findByNcsCodeFirstSixSortByPs(@Param("codePart") String codePart);
}
