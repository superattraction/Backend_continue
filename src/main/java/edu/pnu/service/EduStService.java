package edu.pnu.service;

//import edu.pnu.domain.Edu_st;
import edu.pnu.domain.Labor_ad;
import edu.pnu.domain.Owner_ad;
import edu.pnu.domain.Unemployed_ad;;
import edu.pnu.repository.LaborAdRepository;
import edu.pnu.repository.OwnerAdRepository;
import edu.pnu.repository.UnemployedAdRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class EduStService {

    @Autowired
    private final LaborAdRepository laborAdRepository;
    @Autowired
    private final OwnerAdRepository ownerAdRepository;
    @Autowired
    private final UnemployedAdRepository unemployedAdRepository;

    @Transactional(readOnly = true)
    public Optional<Labor_ad> findById_L(Long id) {
        return laborAdRepository.findById(id);
    }
    @Transactional
    public List<Labor_ad> findAll_L() {
        return laborAdRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Owner_ad> findById_O(Long id) {
        return ownerAdRepository.findById(id);
    }
    @Transactional
    public List<Owner_ad> findAll_O() {
        return ownerAdRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Unemployed_ad> findById_U(Long id) {
        return unemployedAdRepository.findById(id);
    }
    @Transactional
    public List<Unemployed_ad> findAll_U() {
        return unemployedAdRepository.findAll();
    }

}
