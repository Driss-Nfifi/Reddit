package fr.jee.reddit.groupeg.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Subject implements Comparable<Subject>{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String description_subject;
    private String title_subject;
    private int vote;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @OneToMany(fetch = FetchType.LAZY)
    List<Comment> comments;

    public Subject(long id, String title_subject, String description_subject, int vote) {
        this.id = id;
        this.title_subject = title_subject;
        this.description_subject = description_subject;
        this.vote = vote;
    }

    public String getSub(){
        return description_subject+ " "+ title_subject;
    }

    @Override
    public int compareTo(Subject o) {
        try {
            return o.vote;
        }
        catch (Exception e){
            return 0;
        }
    }

    public static void sort(List<Subject> subjects) {
        //filter(subjects);
        Collections.sort(subjects);
        Collections.reverse(subjects);
    }

    public  static List<Subject> iterToList(Iterable<Subject> subjects){
        List<Subject> subjectList=new ArrayList<>();
        for (Subject subject: subjects) {
            subjectList.add(subject);
        }
        return  subjectList;
    }
    public static void filter(List<Subject> subjects){
        //System.out.println(subjects.size());
        for (int i=0;i<subjects.size();i++){
            if(subjects.get(i).getId()==0){
                subjects.remove(i);
                return;
            }
        }
    }
    }
