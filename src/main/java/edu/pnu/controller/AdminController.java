package edu.pnu.controller;

import edu.pnu.domain.Senti_keyword;
import edu.pnu.domain.Senti_result_lg;
import edu.pnu.domain.Senti_training_type;
import edu.pnu.service.KeywordService;
import edu.pnu.service.SentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private SentiService sentiService;

    @Autowired
    private KeywordService keywordService;

    @GetMapping("/admin/main")
    public ResponseEntity<String> adminPage() {
        System.out.println("어드민 들어옴");
        return ResponseEntity.ok("어드민 들어옴");

    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("접근이 거부되었습니다.");
    }
    @GetMapping("/senti/ncscodes/sorting/{num}")
    public @ResponseBody List<Senti_result_lg> getAllLgSentiByNum(@PathVariable(required = false) Long num) {
        if (num != null) {
            return sentiService.findIdOrderByIdAsc(num);
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
}
