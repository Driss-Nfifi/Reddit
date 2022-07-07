package fr.jee.reddit.groupeg.services;

import fr.jee.reddit.groupeg.models.*;
import fr.jee.reddit.groupeg.repositories.CommentRepository;
import fr.jee.reddit.groupeg.repositories.SubjectRepository;
import fr.jee.reddit.groupeg.repositories.UserRepository;
import fr.jee.reddit.groupeg.repositories.VoteCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    VoteCommentRepository voteCommentRepository;
    @Transactional
    public Comment getCommentById(Long id){
        Optional<Comment>optionalComment=commentRepository.findById(id);
        if(optionalComment.isPresent()){
            return optionalComment.get();
        }
        return null;
    }


    public Subject addComment(Long idSubject,String description,String username){
        Subject subject =  subjectRepository.findById(idSubject).get();

        User user=userRepository.findUserByUsername(username);
        Comment comment = new Comment(Long.valueOf(0),0 ,description,user,new ArrayList<>());


        subject.getComments().add(comment);

        //subjectRepository.save(subject);
        commentRepository.save(comment);
        return subject;
       }
    public void deleteById(Long idComment ,String username){
        User user=userRepository.findUserByUsername(username);
        Optional<Comment> commentOptional=commentRepository.findById(idComment);
        if(commentOptional.isPresent()){
            if(user.getUsername().equals(commentOptional.get().getUser().getUsername())){
                commentOptional.get().setDescription("ce commentaire est supprimer");
                commentOptional.get().setVote(0);
                commentRepository.save(commentOptional.get());
            }
        }
    }

    public void addCommentinComment(String username,Long idComment,Long idSubject, String description){
           //Subject subject =  subjectRepository.findById(idSubject).get();
           //Subject subjectTamp =  subjectRepository.findById(Long.valueOf(0)).get();
        System.out.println(username);
           User user=userRepository.findUserByUsername(username);
           System.out.println(user.toString());
           Comment comment = new Comment(Long.valueOf(0),0 ,description,user,new ArrayList<>());
           //subjectTamp.getComments().add(comment);

           Comment commentParent=commentRepository.findById(idComment).get();
           commentParent.getComments().add(comment);
           commentRepository.save(comment);
       }
    public void voteUp(Long id,String username){
        User user =userRepository.findUserByUsername(username);
        if(user!=null){
            Optional<Comment> optionalComment= commentRepository.findById(id);
            Comment comment = null;
            if(optionalComment.isPresent()){
                comment=optionalComment.get();
                Optional<CommentVote> optionalVote=voteCommentRepository.findById(username+id);
                CommentVote commentVote=null;
                if(optionalVote.isPresent()){
                    commentVote=optionalVote.get();
                    if(commentVote.getDown()){
                        commentVote.setDown(false);
                        commentVote.setUp(true);
                        int v=comment.getVote();
                        comment.setVote(v+2);
                    }
                }
                else {
                    commentVote =new CommentVote(comment,user,true,false);
                    int v=comment.getVote();
                    comment.setVote(v+1);
                }
                voteCommentRepository.save(commentVote);
                commentRepository.save(comment);
            }
        }
    }
    public void voteDown(Long id,String username){
        User user =userRepository.findUserByUsername(username);
        if(user!=null){
            Optional<Comment> optionalComment= commentRepository.findById(id);
            Comment comment = null;
            if(optionalComment.isPresent()){
                comment=optionalComment.get();
                Optional<CommentVote> optionalVote=voteCommentRepository.findById(username+id);
                CommentVote commentVote=null;
                if(optionalVote.isPresent()){
                    commentVote=optionalVote.get();
                    if(commentVote.getDown()){
                        commentVote.setDown(true);
                        commentVote.setUp(false);
                        int v=comment.getVote();
                        comment.setVote(v-2);
                    }
                }
                else {
                    commentVote =new CommentVote(comment,user,false,true);
                    int v=comment.getVote();
                    comment.setVote(v-1);
                }
                voteCommentRepository.save(commentVote);
                commentRepository.save(comment);
            }
        }
    }



}
