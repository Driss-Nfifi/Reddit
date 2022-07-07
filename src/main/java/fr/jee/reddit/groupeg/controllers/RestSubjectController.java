package fr.jee.reddit.groupeg.controllers;

import fr.jee.reddit.groupeg.models.Subject;
import fr.jee.reddit.groupeg.services.SubjectService;
import fr.jee.reddit.groupeg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("")
@RestController
public class RestSubjectController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    UserService userService;
  @RequestMapping("/getAllSubject")
    public Iterable<Subject> getAllSubject(){
       return subjectService.getAllSubjects();
   }

   @RequestMapping("/saveDefaultUsers")
    public boolean add(){
        return userService.saveUser();
   }
}
