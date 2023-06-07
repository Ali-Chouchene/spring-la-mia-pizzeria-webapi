package org.java.pizza.controller;

import java.util.List;

import org.java.pizza.OffertaSpeciale;
import org.java.pizza.Pizza;
import org.java.pizza.serv.OffertaSpecialeService;
import org.java.pizza.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offerte")
public class OffertaController {
	@Autowired
	private OffertaSpecialeService offService;
	@Autowired
	private PizzaService pizzaServ;

	@GetMapping
	public String offerteIndex(Model model) {

		List<OffertaSpeciale> offerte = offService.findAll();
		model.addAttribute("offerte", offerte);
		return "indexO";

	}

	@GetMapping("/create-offerta")
	public String create(Model model) {
		List<Pizza> pizzas = pizzaServ.findAll();

		model.addAttribute("pizzas", pizzas);
		model.addAttribute("off", new OffertaSpeciale());
		return "create-offerta";

	}

	@PostMapping("/create-offerta")
	public String store(Model model, OffertaSpeciale offertaspeciale, BindingResult bindingResult) {
		offService.save(offertaspeciale);
		return "redirect:/offerte";
	}
}
