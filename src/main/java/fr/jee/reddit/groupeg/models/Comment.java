package fr.jee.reddit.groupeg.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private int vote;
    private String description;
    @ManyToOne()
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @ManyToMany()
    List<Comment> comments;

    public Comment(long id, int vote, String description) {
        this.id = id;
        this.vote = vote;
        this.description = description;
    }


}
