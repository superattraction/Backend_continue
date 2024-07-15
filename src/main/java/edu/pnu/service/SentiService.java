package edu.pnu.service;

import edu.pnu.domain.Senti_ad;
import edu.pnu.domain.Senti_ed;
import edu.pnu.domain.Senti_result_lg;
import edu.pnu.domain.Senti_training_type;

import edu.pnu.repository.SentiAdRepository;
import edu.pnu.repository.SentiEdRepository;
import edu.pnu.repository.SentiLgRepository;
import edu.pnu.repository.SentiTtRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

@Service
public class SentiService {

    @Autowired
    private SentiLgRepository sentiLgRepository;

    @Autowired
    private SentiTtRepository sentiTtRepository;

    @Autowired
    private SentiEdRepository sentiEdRepository;
    @Autowired
    private SentiAdRepository SentiAdRepository;
    @Autowired
    private SentiAdRepository sentiAdRepository;


    public List<Senti_result_lg> findIdOrderByIdAsc(Integer id) {
        return sentiLgRepository.findAllByNidOrderByNidAsc(id);
    }
    public List<Senti_result_lg> getNcsCodeAllSenti() {
        return  sentiLgRepository.findAll();
    }

    public List<Senti_training_type> getTrainNameSortSenti(String name) {
        return  sentiTtRepository.findByTrainingType(name);
    }

    public List<Senti_training_type> getAllTrainingTypes() {
        return sentiTtRepository.findAll();
    }
    public  List<Senti_ed> getInstituteSenti(String name) {
        return sentiEdRepository.findAllByName(name);
    }
    public List<Senti_ad> getAddressSenti(String address) {
        return sentiAdRepository.findAllByAddress(address);
    }

}
