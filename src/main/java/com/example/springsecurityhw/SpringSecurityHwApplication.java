package com.example.springsecurityhw;

import com.example.springsecurityhw.model.User;
import com.example.springsecurityhw.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityHwApplication {

	public static void main(String[] args) {
		UserRepository repository =  SpringApplication.run(SpringSecurityHwApplication.class, args).getBean(UserRepository.class);
		repository.save(new User("user", "user"));
		repository.save(new User("admin", "admin"));
	}

}