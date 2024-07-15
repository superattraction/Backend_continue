package edu.pnu.controller;

import edu.pnu.domain.*;
import edu.pnu.service.EduStService;
import edu.pnu.service.KeywordService;
import edu.pnu.service.SentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private SentiService sentiService;

    @Autowired
    private KeywordService keywordService;

    @Autowired
    private EduStService eduStService;



    @GetMapping("/main")
    public ResponseEntity<String> adminPage() {
        System.out.println("어드민 들어옴");
        return ResponseEntity.ok("어드민 들어옴");

    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("접근이 거부되었습니다.");
    }
    @GetMapping("/senti/ncscodes/sorting/{id}")
    public @ResponseBody List<Senti_result_lg> getAllLgSentiByNum(@PathVariable(required = false) Integer id) {
        if (id != null) {
            return sentiService.findIdOrderByIdAsc(id);
        } else {
            return null;
        }
    }
    @GetMapping("/senti/ncscodes/sorting")
    public @ResponseBody List<Senti_result_lg> getAllLgSentiByNum() {
        return sentiService.getNcsCodeAllSenti();
    }

    @GetMapping("/senti/trainingtype/{name}")
    public @ResponseBody List<Senti_training_type> getAllSentiByName(@PathVariable(required = false) String name) {
        if (name != null) {
            return sentiService.getTrainNameSortSenti(name);
        } else {
            return null;}
    }
    @GetMapping("/senti/trainingtype")
    public @ResponseBody List<Senti_training_type> getAllTtSentiByNum() {
        return sentiService.getAllTrainingTypes();
    }

    @GetMapping("/senti/keyword")
    public @ResponseBody List<Senti_keyword> getAllKeywordByNum() {
        return keywordService.getAll();
    }

    @GetMapping("/senti/keyword/courseId/{courseId}")
    public @ResponseBody List<Senti_keyword> getAllKeywordByCourseId(@PathVariable(required = false) Integer courseId) {
        return keywordService.getById(courseId);
    }
//    @GetMapping("/edu_st/{id}")
//    public @ResponseBody Optional<Edu_st> getById_st(@PathVariable Long id) {
//        return eduStService.findById(id);
//    }
//    @GetMapping("/edu_st")
//    public @ResponseBody List<Edu_st> getAll_st() {
//        return eduStService.findAll();
//    }
    @GetMapping("/edu/stl/{id}")
    public @ResponseBody Optional<Labor_ad> getById_L(@PathVariable Long id) {
        return eduStService.findById_L(id);
    }
    @GetMapping("/edu/stl")
    public @ResponseBody List<Labor_ad> getAll_L() {
        return eduStService.findAll_L();
    }
    @GetMapping("/edu/sto/{id}")
    public @ResponseBody Optional<Owner_ad> getById_O(@PathVariable Long id) {
        return eduStService.findById_O(id);
    }
    @GetMapping("/edu/sto")
    public @ResponseBody List<Owner_ad> getAll_O() {
        return eduStService.findAll_O();
    }
    @GetMapping("/edu/stu/{id}")
    public @ResponseBody Optional<Unemployed_ad> getById_U(@PathVariable Long id) {
        return eduStService.findById_U(id);
    }
    @GetMapping("/edu/stu")
    public @ResponseBody List<Unemployed_ad> getAll_st_U() {
        return eduStService.findAll_U();
    }
}
