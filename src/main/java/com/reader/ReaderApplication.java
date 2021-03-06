package com.reader;

import com.reader.models.User;
import com.reader.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReaderApplication.class, args);
	}

	//MOCK
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> userRepository.save(new User("test@test","test",true));
	}

}
