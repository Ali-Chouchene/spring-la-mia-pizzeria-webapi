package org.java.pizza.repo;

import java.util.List;

import org.java.pizza.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepo extends JpaRepository<Ingrediente, Integer> {
	public List<Ingrediente> findByNomeContaining(String Nome);
}
