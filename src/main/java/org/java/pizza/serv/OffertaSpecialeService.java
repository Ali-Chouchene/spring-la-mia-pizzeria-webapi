package org.java.pizza.serv;

import java.util.List;
import java.util.Optional;

import org.java.pizza.OffertaSpeciale;
import org.java.pizza.repo.OffertaSpecialeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffertaSpecialeService {

	@Autowired
	private OffertaSpecialeRepo repo;

	public List<OffertaSpeciale> findAll() {

		return repo.findAll();
	}

	public Optional<OffertaSpeciale> findById(int id) {

		return repo.findById(id);
	}

	public OffertaSpeciale save(OffertaSpeciale offertaspeciale) {
		return repo.save(offertaspeciale);
	}
}
