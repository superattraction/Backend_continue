package edu.pnu.controller;

import java.util.List;

import edu.pnu.domain.*;
import edu.pnu.service.LinkService;
import edu.pnu.service.SentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pnu.repository.ListRepository;
import edu.pnu.repository.NcsRepository;
import edu.pnu.service.ListService;

@Controller
public class MainController {
	@Autowired
	private NcsRepository ncsRepository;
	
	@GetMapping(path="/ncsall")
	public @ResponseBody Iterable<Ncs> getAllNcs(){
		return ncsRepository.findAll();
	}
	
	@Autowired
	private ListRepository listRepo;
	@GetMapping(path="/eduall")
	public @ResponseBody Iterable<Edu_list> getAllEdu(){
		return listRepo.findAll();
	}

    @Autowired
    private ListService listService;

    @Autowired
    private LinkService linkService;


    @GetMapping("/ncscodes/six/{part}")
    public @ResponseBody List<Edu_list> getNcsCodeByFirstSix(@PathVariable String part) {
        return listService.getNcsCodeByFirstSix(part);
    }


    @GetMapping("/ncscodes/six/ratingsort/{part}")
    public @ResponseBody List<Edu_list> geNcsCodeByFirstSixSortByRating(@PathVariable String part) {
        return listService.getNcsCodeByFirstSixSortByRating(part);
    }
    
    @GetMapping("/ncscodes/six/pssort/{part}")
    public @ResponseBody List<Edu_list> geNcsCodeByFirstSixSortByPs(@PathVariable String part) {
        return listService.getNcsCodeByFirstSixSortByPs(part);
    }
    @GetMapping("/urls")
    public @ResponseBody List<Link> getLinks(@RequestParam("course_id") Long course_id) {
        return linkService.getLinksByCourseId(course_id);

    }
//    @GetMapping("/ncscodes/two/raitingsort")
//    public @ResponseBody List<Senti_result_lg> getAllLgSenti() {
//        return sentiService.getNcsC();
//    }

}
