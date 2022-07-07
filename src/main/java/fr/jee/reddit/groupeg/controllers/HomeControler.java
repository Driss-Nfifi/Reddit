package fr.jee.reddit.groupeg.controllers;

import fr.jee.reddit.groupeg.models.Subject;
import fr.jee.reddit.groupeg.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeControler {
    @Autowired
    SubjectService subjectService;
    @GetMapping("/")
    public String index(Model model){

        return listByPage(model,1);
    }

    @GetMapping("/page/{pageNumber}")
    public String listByPage(Model model, @PathVariable int pageNumber){

        Page<Subject> page = subjectService.getAllSubjects(pageNumber);
        System.out.println("******************listByPage*********************");
        //List<Subject> subjectList=Subject.iterToList(subjectService.getAllSubjects(currentPage));
        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

         List<Subject> subjectList=page.getContent();
    //  Subject.sort(subjectList);
        System.out.println("*****************************" + subjectList.toString());
        //System.out.println(subjectList.get(1).getComments().get(2).getComments().size());
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("currentPage",pageNumber);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("subjects",subjectList);


        return "home";
    }
}
