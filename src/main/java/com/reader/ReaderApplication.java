package com.reader;

import com.reader.model.Role;
import com.reader.model.User;
import com.reader.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReaderApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ReaderApplication.class, args);
	}

	//MOCK
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		var user = new User();
		user.setPassword("test");
		user.setEmail("test@test");
		user.setRole(Role.USER);
		return args -> userRepository.save(user);
	}

}
