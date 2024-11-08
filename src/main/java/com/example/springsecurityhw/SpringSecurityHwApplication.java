package com.example.springsecurityhw;

import com.example.springsecurityhw.model.User;
import com.example.springsecurityhw.model.enums.Role;
import com.example.springsecurityhw.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityHwApplication {

	public static void main(String[] args) {
		UserRepository repository =  SpringApplication.run(SpringSecurityHwApplication.class, args).getBean(UserRepository.class);
		repository.save(new User("user", "user", Role.ROLE_USER));
		repository.save(new User("admin", "admin", Role.ROLE_ADMIN));
	}

}