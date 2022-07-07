package fr.jee.reddit.groupeg.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class CommentVote  {
    @Id
    private String id;
    @OneToOne(fetch = FetchType.LAZY)
    Comment comment;
    @OneToOne(fetch = FetchType.LAZY)
    User user;
    private Boolean up;
    private Boolean down;

    public CommentVote(Comment comment, User user, Boolean up, Boolean down) {
        this.comment = comment;
        this.user = user;
        this.up = up;
        this.down = down;
        this.id=GenerateId(user.getUsername(),comment.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote1 = (Vote) o;
        return this.getUser().getUsername().equals(vote1.user.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(  comment, user);
    }
    private String GenerateId(String username,Long idCom){
        try {
            return username + idCom;
        }catch (Exception e){
            return "";
        }
    }
}
