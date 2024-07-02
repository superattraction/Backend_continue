package edu.pnu.service;

import edu.pnu.domain.Link;
import edu.pnu.repository.LinkRepository;
import edu.pnu.repository.NcsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public List<Link> getLinksByCourseId(Long course_id){
        return linkRepository.findByCourse_id(course_id);
    }
}
