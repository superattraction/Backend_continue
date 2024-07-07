package edu.pnu.service;

import java.util.List;

import edu.pnu.repository.SentiLgRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.pnu.domain.Edu_list;
import edu.pnu.domain.Senti_result_lg;
import edu.pnu.repository.ListRepository;

@NoArgsConstructor
@Service
public class ListService {
	 @Autowired
	 private ListRepository listRepository;

	 @Autowired
	 private SentiLgRepository LgRepository;

	    public List<Edu_list> getNcsCodeByFirstSix(String part) {
	        return listRepository.findByNcsCodeFirstSix(part);
	    }
	    
	    public List<Edu_list> getNcsCodeByFirstSixSortByRating(String part) {
	        return listRepository.findByNcsCodeFirstSixSortByRating(part);
	    }
	    
	    public List<Edu_list> getNcsCodeByFirstSixSortByPs(String part) {
	        return listRepository.findByNcsCodeFirstSixSortByPs(part);
	    }

		public List<Senti_result_lg> getNcsCodeLgAllSenti() {
			return LgRepository.findAllByOrderByLargeAsc();
		}

		public List<Senti_result_lg> getNcsCodeLgSortSenti(int num) {
			return LgRepository.findByLargeStartingWithOrderByLargeAsc(num);
		}

}
