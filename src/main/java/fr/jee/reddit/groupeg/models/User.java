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
public class User  {
    private String username;
    private String email;
    private String password;
    private Boolean active;
    @OneToOne
    private Role role;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    public User(String username, String email, String password, Boolean active,Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active=active;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email, password, active, role, id);
    }
}
