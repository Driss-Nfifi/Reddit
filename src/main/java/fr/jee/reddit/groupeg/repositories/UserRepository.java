package fr.jee.reddit.groupeg.repositories;

import fr.jee.reddit.groupeg.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User findUserByUsername(String username);
    public User findUserByEmail(String email_email);
    public Optional<User> getUserByEmail(String email);

 //   public User updatePassword(String userEmail, String password, String newPassword);
   // public User findUserByEmail(Long id, String userEmail);
}
