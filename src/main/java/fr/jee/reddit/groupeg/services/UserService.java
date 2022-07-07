package fr.jee.reddit.groupeg.services;

import fr.jee.reddit.groupeg.models.Role;
import fr.jee.reddit.groupeg.models.User;
import fr.jee.reddit.groupeg.repositories.RoleRepository;
import fr.jee.reddit.groupeg.repositories.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.Properties;

@Service
public class UserService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean login() {
        return true;
    }

    public User findUserByUsername(String username) {
        System.out.println(username);
        System.out.println(checkIfUser(username));
        return userRepository.findUserByUsername(username);
    }

    public Boolean saveUser() {
        User admin = new User("admin", "admin@gmail.com", passwordEncoder.encode("admin"), true, new Role(Long.valueOf(1), "ADMIN"));
        User user = new User("prof", "user@gmail.com", passwordEncoder.encode("prof"), true, new Role(Long.valueOf(2), "USER"));
        User imad = new User("imad", "imad@gmail.com", passwordEncoder.encode("123"), true, new Role(Long.valueOf(2), "USER"));
        userRepository.save(user);
        userRepository.save(admin);
        userRepository.save(imad);
        return true;
    }

    public void register(String userName, String email, String password) {
        User user = new User( userName, email, passwordEncoder.encode(password), true, roleRepository.findRoleByRole("USER"));
        System.out.println(user);
        userRepository.save(user);
    }

    public boolean checkIfUser(String email) {
        List<User> users = (List<User>) userRepository.findAll();
        for (User myUser : users) {
            System.out.println(myUser.getEmail());
            if (myUser.getUsername().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public boolean resetPassword(String email, String pass, int code) {
        try {

            Optional<User> user = getUserByEmail(email);
            if(code == CODE1){
                if (user.get() != null) {
                    user.get().setPassword(passwordEncoder.encode(pass));
                    userRepository.save(user.get());
                    return true;
                }
            }else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return false;
    }
    public static int CODE1;


   
    public boolean sendEmail( String email) {

        try {
            CODE1=(int)(Math.random() * ((9999 - 1000) + 1)) + 1000;
            String emailM = "Hello " + "\n" +
                    "You're receiving this e-mail because you or someone else has requested a password reset for your user account at " +" \n" +
                    "Click the link below to reset your password" + " \n" +
                    "Code de sécurité :"+ CODE1
                    + " \n" +
                    "If you did not request a password reset you can safely ignore this email.\n"
                   ;

            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(587);
            mailSender.setUsername("noreplycarshopapp@gmail.com");
            mailSender.setPassword("xqsfkatkqxqgpyfs");
            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreplycarshopapp@gmail.com");
            message.setTo(email);
            message.setSubject("Réinitialiser le mot de passe");
            message.setText(emailM);
            mailSender.send(message);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public void test(){

    }
}



