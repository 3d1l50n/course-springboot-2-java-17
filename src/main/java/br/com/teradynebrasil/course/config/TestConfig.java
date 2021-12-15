package br.com.teradynebrasil.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.teradynebrasil.course.entities.User;
import br.com.teradynebrasil.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	
	



	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown","maria@gmail.com", "991729239", "125756");
		User u2 = new User(null, "Robert Blue","robert@gmail.com", "991584539", "123936");
		User u3 = new User(null, "Beth Bop","beth@gmail.com", "991589252", "123446");
		User u4 = new User(null, "Rudolf Red","rudolf@gmail.com", "993789239", "123736");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		
	}}
