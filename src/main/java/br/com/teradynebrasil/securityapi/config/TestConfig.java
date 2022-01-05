package br.com.teradynebrasil.securityapi.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.teradynebrasil.securityapi.entities.Category;
import br.com.teradynebrasil.securityapi.entities.Order;
import br.com.teradynebrasil.securityapi.entities.OrderItem;
import br.com.teradynebrasil.securityapi.entities.Payment;
import br.com.teradynebrasil.securityapi.entities.Product;
import br.com.teradynebrasil.securityapi.entities.User;
import br.com.teradynebrasil.securityapi.entities.enums.OrderStatus;
import br.com.teradynebrasil.securityapi.repositories.CategoryRepository;
import br.com.teradynebrasil.securityapi.repositories.OrderItemRepository;
import br.com.teradynebrasil.securityapi.repositories.OrderRepository;
import br.com.teradynebrasil.securityapi.repositories.ProductRepository;
import br.com.teradynebrasil.securityapi.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	



	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Eletronics", "Tvs, VCR, Radios");
		Category cat2 = new Category(null, "Books", "Biographies, Mistery, Policy");
		Category cat3 = new Category(null, "Computers", "Apple, Dell, IBM");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "NUlla eu impeerdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nas eleinfed maximus toror, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donnec alied ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringille convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
	
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		User u1 = new User(null, "Maria Brown","maria@gmail.com", "991729239", "125756");
		User u2 = new User(null, "Robert Blue","robert@gmail.com", "991584539", "123936");
		User u3 = new User(null, "Beth Bop","beth@gmail.com", "991589252", "123446");
		User u4 = new User(null, "Rudolf Red","rudolf@gmail.com", "993789239", "123736");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T17:00:07Z"), OrderStatus.DELIVERED, u2);
		Order o3 = new Order(null, Instant.parse("2019-05-27T13:12:06Z"), OrderStatus.SHIPPED, u4);
		Order o4 = new Order(null, Instant.parse("2019-03-23T11:07:05Z"), OrderStatus.WAYTING_PAYMENT, u3);
		Order o5 = new Order(null, Instant.parse("2019-08-18T21:43:00Z"), OrderStatus.CANCELED, u1);
		Order o6 = new Order(null, Instant.parse("2019-11-05T22:32:08Z"), OrderStatus.SHIPPED, u2);
		Order o7 = new Order(null, Instant.parse("2019-10-12T09:27:02Z"), OrderStatus.DELIVERED, u3);
		Order o8 = new Order(null, Instant.parse("2019-03-29T07:15:06Z"), OrderStatus.PAID, u4);
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8));
		
		
		OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p3,1,p4.getPrice());
		OrderItem oi3 = new OrderItem(o2,p3,2,p1.getPrice());
		OrderItem oi4 = new OrderItem(o3,p3,2,p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null,Instant.parse("2019-06-20T21:53:07Z"),o1);
		
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
	
		
		
		
		
	}}
