package fr.jee.reddit.groupeg;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.ConfigurationException;
import javax.security.auth.Subject;
import javax.security.auth.login.Configuration;

@SpringBootApplication
public class GroupeGApplication {

	public static void main(String[] args) {



		SpringApplication.run(GroupeGApplication.class, args);
	}


}
