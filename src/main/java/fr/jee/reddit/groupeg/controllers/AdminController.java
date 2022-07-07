package fr.jee.reddit.groupeg.controllers;

import fr.jee.reddit.groupeg.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    SubjectService subjectService;

    @RequestMapping("/delete{id}")
    public String delateSubject(@PathVariable Long id, Model model){
        model.addAttribute("subjects", subjectService.deleteById(id));
        return "redirect:/";
    }
}
