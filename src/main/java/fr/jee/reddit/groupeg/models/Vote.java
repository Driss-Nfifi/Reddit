package fr.jee.reddit.groupeg.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Vote {
    @Id
    private String id;
    @OneToOne(fetch = FetchType.LAZY)
    Subject subject;
    @OneToOne(fetch = FetchType.LAZY)
    User user;
    private Boolean up;
    private Boolean down;

    public Vote( Subject subject, User user, Boolean up, Boolean down) {
        this.subject = subject;
        this.user = user;
        this.up = up;
        this.down = down;
        this.id=GenerateId(user.getUsername(),subject.getId());
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
        return Objects.hash(  subject, user);
    }
    private String GenerateId(String username,Long idSub){
        try {
            return username + idSub;
        }catch (Exception e){
            return "";
        }
    }
    public Vote(){}

}
