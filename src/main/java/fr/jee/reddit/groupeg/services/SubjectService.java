package fr.jee.reddit.groupeg.services;

import fr.jee.reddit.groupeg.models.Subject;
import fr.jee.reddit.groupeg.models.User;
import fr.jee.reddit.groupeg.models.Vote;
import fr.jee.reddit.groupeg.repositories.SubjectRepository;
import fr.jee.reddit.groupeg.repositories.UserRepository;
import fr.jee.reddit.groupeg.repositories.VoteRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    VoteRepository voteRepository;
   public Subject getSubjectByID(Long id){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        Subject subject = null;
        if(optionalSubject.isPresent()){
            subject = optionalSubject.get();
        }else{
            throw new RuntimeException(";iugui;g"+ id);
        }
        return subject;
    }
   /*public Subject getSubjectByID(Long id){
       System.out.println("*********************Begin********************");
       Optional<Subject> optionalSubject = subjectRepository.findById(id);
       Subject subject = new Subject();
       if(optionalSubject.isPresent()){
           subject.setId(optionalSubject.get().getId());
           System.out.println("****************if*******************");
           subject.setTitle_subject(optionalSubject.get().getTitle_subject());
           System.out.println("****************getTitle_subject*******************");
           subject.setVote(optionalSubject.get().getVote());
           System.out.println("****************getVote*******************");
           subject.setDescription_subject(optionalSubject.get().getDescription_subject());
           System.out.println("****************getDescription_subject*******************");
           subject.setUser(optionalSubject.get().getUser());
           System.out.println("****************getUser*******************");
           subject.setComments(optionalSubject.get().getComments().subList(0, 1));
       }else{
           throw new RuntimeException(";iugui;g"+ id);
       }
       return subject;
   }
*/
 public Page<Subject> getAllSubjects(){
        Pageable pageable = PageRequest.of(0,1);
        return subjectRepository.findAll(pageable);
    }
    public Page<Subject> getAllSubjects(int pageNumber){

        Pageable pageable = PageRequest.of(pageNumber - 1,3);
        return subjectRepository.findAll(pageable);
    }

    public void addSubject(String username,String title_subject, String description_subject){
        User user=userRepository.findUserByUsername(username);
        Subject subject = new Subject(Long.valueOf(0), description_subject,title_subject, 0,user,new ArrayList<>());
        subjectRepository.save(subject);
    }

    public void ajouterSubjectSession(Subject subject){

        subject.setDescription_subject("ouegfiwluef");
        subject.setTitle_subject("iuwge");

        subjectRepository.save(subject);
    }


    public void voteUp(Long id,String username){
        User user =userRepository.findUserByUsername(username);
        if(user!=null){
            Optional<Subject> optionalSubject= subjectRepository.findById(id);
            Subject subject = null;
            if(optionalSubject.isPresent()){
                subject=optionalSubject.get();
                Optional<Vote> optionalVote=voteRepository.findById(username+id);
                Vote vote=null;
                if(optionalVote.isPresent()){
                    vote=optionalVote.get();
                    if(vote.getDown()){
                        vote.setDown(false);
                        vote.setUp(true);
                        int v=subject.getVote();
                        subject.setVote(v+2);
                    }
                }
                else {
                    vote =new Vote(subject,user,true,false);
                    int v=subject.getVote();
                    subject.setVote(v+1);
                }
                voteRepository.save(vote);
                subjectRepository.save(subject);
            }
        }
    }
    public void voteDown(Long id,String username){
        User user =userRepository.findUserByUsername(username);
        if(user!=null){
            Optional<Subject> optionalSubject= subjectRepository.findById(id);
            Subject subject = null;
            if(optionalSubject.isPresent()){
                subject=optionalSubject.get();
                Optional<Vote> optionalVote=voteRepository.findById(username+id);
                Vote vote=null;
                if(optionalVote.isPresent()){
                    vote=optionalVote.get();
                    if(vote.getUp()){
                        vote.setDown(true);
                        vote.setUp(false);
                        int v=subject.getVote();
                        subject.setVote(v-2);
                    }
                }
                else {
                    vote =new Vote(subject,user,false,true);
                    int v=subject.getVote();
                    subject.setVote(v-1);
                }
                voteRepository.save(vote);
                subjectRepository.save(subject);
            }
        }
    }

    public List<Subject> getSubjectsByKeyworld(String keyword){
        Iterable<Subject>subjects=subjectRepository.findAll();
        List<Subject>subjectList=new ArrayList<>();
        for (Subject s: subjects) {
            if(s.getSub().toLowerCase().contains(keyword.toLowerCase())){
                subjectList.add(s);
            }
        }
        return subjectList;
    }

    public List<Subject> getSubjectsByUser(String user){
        User us = userRepository.findUserByUsername(user);
        List<Subject>subjects=subjectRepository.findSubjectByUser(us);
        return subjects;
    }

    public List<Subject>deleteById(Long id){
        subjectRepository.deleteById(id);
        List<Subject>subjectList= Subject.iterToList(subjectRepository.findAll());
        Subject.sort(subjectList);
        return  subjectList;
    }
}
