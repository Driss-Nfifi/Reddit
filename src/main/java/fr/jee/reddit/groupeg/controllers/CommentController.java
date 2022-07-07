package fr.jee.reddit.groupeg.controllers;

import fr.jee.reddit.groupeg.models.Comment;
import fr.jee.reddit.groupeg.models.Subject;
import fr.jee.reddit.groupeg.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("Comment")
public class CommentController {
    @Autowired
    CommentService commentService;
/*
    @GetMapping("admin/getById/{id}")
    public Optional<Comment> getCommentById(@PathVariable Long id){
        return commentService.getCommentById(id);
    }
*/


    @PostMapping("/addComment/{idSubject}/{username}")
    public String addComment(@PathVariable Long idSubject,@PathVariable String username, String description){
        System.out.println(username);
        commentService.addComment(idSubject,description,username);
        //model.addAttribute("subject",commentService.addComment(idSubject,description));
        return "redirect:/Subject/getSubject/"+idSubject;
    }

    @PostMapping("/addCommentinComment/{username}/{idSubject}/{idComment}")
    public String addCommentinComment(@PathVariable String username,@PathVariable Long idComment,@PathVariable Long idSubject, String description){
        //model.addAttribute("subject",commentService.addCommentinComment(username,idComment,idSubject,description));
        commentService.addCommentinComment(username,idComment,idSubject,description);
        return "redirect:/Subject/getSubject/"+idSubject;
    }
    @GetMapping("/deleteComment/{username}/{idComment}/{idSubject}")
    public String deleteComment(@PathVariable Long idComment,@PathVariable String username, @PathVariable Long idSubject ){
        commentService.deleteById(idComment,username);
        return "redirect:/Subject/getSubject/"+idSubject;
    }


    @RequestMapping("/voteUp/{idSubject}/{id}/{username}")
    public String voteUp(@PathVariable Long idSubject,@PathVariable  Long id,@PathVariable  String username){
        commentService.voteUp(id,username);
        return "redirect:/Subject/getSubject/"+idSubject;
    }
    @RequestMapping("/voteDown/{idSubject}/{id}/{username}")
    public String voteDown(@PathVariable Long idSubject,@PathVariable  Long id,@PathVariable  String username){
        commentService.voteDown(id,username);
        return "redirect:/Subject/getSubject/"+idSubject;
    }
}
