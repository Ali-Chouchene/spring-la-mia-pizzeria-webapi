package org.java.pizza.api;

import java.util.List;
import java.util.Optional;

import org.java.pizza.Pizza;
import org.java.pizza.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RestControllerApi {

	@Autowired
	private PizzaService pizzaServ;

	@GetMapping("/pizzas")
	public ResponseEntity<List<Pizza>> getPizzas() {

		List<Pizza> pizzas = pizzaServ.findAll();

		return new ResponseEntity<>(pizzas, HttpStatus.OK);

	}

	@GetMapping("/pizzas/{id}")
	public ResponseEntity<Optional<Pizza>> getSinglePizza(@RequestBody Pizza pizza, @PathVariable int id) {
		Optional<Pizza> singlePizza = pizzaServ.findById(id);

		return new ResponseEntity<>(singlePizza, HttpStatus.OK);

	}

	@PostMapping("/pizzas")
	public ResponseEntity<PizzaRes> storePizza(@RequestBody Pizza pizza) {

		pizza = pizzaServ.save(pizza);

		return new ResponseEntity<>(new PizzaRes(pizza), HttpStatus.OK);
	}

	@PutMapping("/pizzas/{id}")
	public Optional<Pizza> updatePizza(@RequestBody Pizza pizza, @PathVariable int id) {

		return Optional.of(pizzaServ.findById(id).map(pizza1 -> {
			pizza1.setNome(pizza.getNome());
			pizza1.setDescrizione(pizza.getDescrizione());
			pizza1.setFoto(pizza.getFoto());
			pizza1.setPrezzo(pizza.getPrezzo());
			return pizzaServ.save(pizza1);
		}).orElseGet(() -> {
			return pizzaServ.save(pizza);
		}));
	}

	@DeleteMapping("/pizzas/{id}")
	public ResponseEntity<PizzaRes> deletePizza(@PathVariable int id) {

		Optional<Pizza> optPizza = pizzaServ.findById(id);

		if (optPizza.isEmpty()) {

			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

		Pizza pizza = optPizza.get();
		pizzaServ.deleteById(pizza.getId());

		return new ResponseEntity<>(new PizzaRes(pizza), HttpStatus.OK);
	}
}
