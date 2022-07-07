package fr.jee.reddit.groupeg.config_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AppliacationUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.headers().frameOptions().sameOrigin();
        http
                .csrf().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/h2-console/*").permitAll()
                .antMatchers("/saveDefaultUsers").permitAll()

                .antMatchers("/Subject/*").permitAll()
                .antMatchers("/forgotpassword").permitAll()
                .antMatchers("/resetpassword").permitAll()
                .antMatchers("/getFormForget").permitAll()
                .antMatchers("/resources/static/Comment.js").permitAll()
                .antMatchers("/Subject/getSubject/*").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/pass").permitAll()
                .antMatchers("/page/*").permitAll()
                .antMatchers("/add").permitAll()
                .antMatchers("/admin/*").hasAuthority("ADMIN")
                //.antMatchers("/api/*").access("hasAuthority('ADMIN') or hasAuthority('USER')")
                .anyRequest()
                .authenticated()
                .and().formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .rememberMe()
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                .key("somethingverysecured")
                .rememberMeParameter("remember-me")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/")
                ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/static/js/Comment.js","/resources/**", "/static/**", "/css/**", "/fonts/**","/js/**", "/images/**");
    }
}
