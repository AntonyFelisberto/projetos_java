package com.projeto.microservices;

import com.projeto.microservices.domain.User;
import com.projeto.microservices.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableEurekaClient
public class MicroservicesApplication implements CommandLineRunner {

	private final UserRepository useRepository;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		useRepository.saveAll(List.of(
				new User(null,"Artorias","artorias@gmail.com","123",20.0)
		));
	}
}
