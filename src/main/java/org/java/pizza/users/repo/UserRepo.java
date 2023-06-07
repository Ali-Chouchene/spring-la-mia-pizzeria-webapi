package org.java.pizza.users.repo;

import java.util.Optional;

import org.java.pizza.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

	public Optional<User> findByUsername(String username);
}