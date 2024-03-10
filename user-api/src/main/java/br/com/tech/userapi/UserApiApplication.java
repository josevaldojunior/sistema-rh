package br.com.tech.userapi;

import br.com.tech.userapi.domain.model.User;
import br.com.tech.userapi.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new User(null, "Junior Medeiros", "junior@mail.com", "123", 30.0)
		));
	}
}
