package br.com.teradynebrasil.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.teradynebrasil.course.entities.Order;
import br.com.teradynebrasil.course.entities.User;
import br.com.teradynebrasil.course.repositories.OrderRepository;
import br.com.teradynebrasil.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	



	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown","maria@gmail.com", "991729239", "125756");
		User u2 = new User(null, "Robert Blue","robert@gmail.com", "991584539", "123936");
		User u3 = new User(null, "Beth Bop","beth@gmail.com", "991589252", "123446");
		User u4 = new User(null, "Rudolf Red","rudolf@gmail.com", "993789239", "123736");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T17:00:07Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-05-27T13:12:06Z"), u4);
		Order o4 = new Order(null, Instant.parse("2019-03-23T11:07:05Z"), u3);
		Order o5 = new Order(null, Instant.parse("2019-08-18T21:43:00Z"), u1);
		Order o6 = new Order(null, Instant.parse("2019-11-05T22:32:08Z"), u2);
		Order o7 = new Order(null, Instant.parse("2019-10-12T09:27:02Z"), u3);
		Order o8 = new Order(null, Instant.parse("2019-03-29T07:15:06Z"), u4);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8));
		
	}}
