package fr.jee.reddit.groupeg.config_security;


import fr.jee.reddit.groupeg.models.User;
import fr.jee.reddit.groupeg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
@Service
public class AppliacationUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        List< GrantedAuthority> authoritie=null;
        try {
            authoritie =Arrays.asList( new SimpleGrantedAuthority(user.getRole().getRole()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return buildUserForAuthentication(user, authoritie);
    }
    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getActive(), true, true, true, authorities);
    }

}
