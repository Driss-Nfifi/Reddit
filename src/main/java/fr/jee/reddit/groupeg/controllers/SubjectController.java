package fr.jee.reddit.groupeg.controllers;

import fr.jee.reddit.groupeg.models.Subject;
import fr.jee.reddit.groupeg.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("Subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/addSubjectPage")
    public String addSubjectPage(){
        return "addSubject";
    }

    @PostMapping("/addSubjectFunction/{username}")
    public String addSubjects( @PathVariable String username,String title_subject, String description_subject){
        subjectService.addSubject(username,title_subject, description_subject);
        return "redirect:/";
    }

    @GetMapping("/getSubject/{id}")
    public String showSubjectInfos(@PathVariable  Long id, Model model ){
        Subject subject = subjectService.getSubjectByID(id);
        model.addAttribute("subject", subject);
        return "subject";
    }


    @GetMapping("/mySubjects/{user}")
    public String showMySubjects(@PathVariable String user, Model model){
        List<Subject> subjectList=Subject.iterToList(subjectService.getSubjectsByUser(user));
        Collections.reverse(subjectList);
        model.addAttribute("mySubjects",subjectList);
        return "showmysubjects";
    }

    @GetMapping("/getAllSubjects")
    public String getSubjectsAll(Model model) {
        model.addAttribute("listSubjects", subjectService.getAllSubjects());
        return "showallsubjects";

    }


    /*
         @PostMapping("/addSubject")
        public Boolean addSubject(@RequestBody Subject subject){
                return subjectService.addSubject(subject);
        }

        @GetMapping("/getSubject")
        public Subject getSubject() {
            return subjectService.getSubjectByID(Long.valueOf(3));

        }

        @PostMapping("/deleteSubject")
        public void deleteSubject(@RequestBody Subject subject) {
            subjectService.deleteSubject(subject);
        }*/
    @RequestMapping("/vote/voteUp{id}/{username}")
    public String voteUp(@PathVariable  Long id, @PathVariable  String username,Model model){
        subjectService.voteUp(id,username);
        return "redirect:/Subject/getSubject/"+id;
    }
    @RequestMapping("/vote/voteDown{id}/{username}")
    public String voteDown(@PathVariable  Long id,@PathVariable  String username, Model model){
        subjectService.voteDown(id,username);
        return "redirect:/Subject/getSubject/"+id;
    }
    @PostMapping("/getSubjectsByKeyworld")
    public String getSubjectsByKeyworld(String key, Model model){
        List<Subject> subjects=subjectService.getSubjectsByKeyworld(key);
        Subject.sort(subjects);
        model.addAttribute("subjects",subjects);
        return "home";
    }

}
