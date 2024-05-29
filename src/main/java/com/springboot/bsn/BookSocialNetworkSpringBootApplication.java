package com.springboot.bsn;

import com.springboot.bsn.config.ApplicationAuditAware;
import com.springboot.bsn.role.Role;
import com.springboot.bsn.role.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAware")
@EnableAsync
public class BookSocialNetworkSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSocialNetworkSpringBootApplication.class, args);
	}



	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").createdDate(LocalDateTime.now()).build());
			}
		};
	}

}
