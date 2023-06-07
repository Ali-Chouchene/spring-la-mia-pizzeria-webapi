package org.java.pizza.users;

import org.java.pizza.users.serv.RoleServ;
import org.java.pizza.users.serv.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthApplication implements CommandLineRunner {

	@Autowired
	private RoleServ roleService;

	@Autowired
	private UserServ userService;

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Role user = new Role("USER");
		Role admin = new Role("ADMIN");

		roleService.save(user);
		roleService.save(admin);

		final String pws = new BCryptPasswordEncoder().encode("12345");

		User userUser = new User("user", pws, user);
		User userAdmin = new User("admin", pws, admin);

		userService.save(userUser);
		userService.save(userAdmin);
	}
}