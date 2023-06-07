package org.java.pizza.serv;

import java.util.List;
import java.util.Optional;

import org.java.pizza.Ingrediente;
import org.java.pizza.repo.IngredienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteServ {
	@Autowired
	private IngredienteRepo repo;

	public List<Ingrediente> findAll() {
		return (List<Ingrediente>) repo.findAll();
	}

	public Ingrediente save(Ingrediente ingrediente) {
		return repo.save(ingrediente);
	}

	public Optional<Ingrediente> findById(int id) {
		return repo.findById(id);
	}

	public List<Ingrediente> findByNome(String nome) {
		return repo.findByNomeContaining(nome);
	}

	public void deleteById(Integer id) {

		repo.deleteById(id);

	}
}
