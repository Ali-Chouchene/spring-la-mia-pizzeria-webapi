package org.java.pizza.controller;

import java.util.List;
import java.util.Optional;

import org.java.pizza.Ingrediente;
import org.java.pizza.serv.IngredienteServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IngredienteController {
	@Autowired
	private IngredienteServ ingredienteServ;

	@GetMapping("/ingredienti")
	public String pizzas(Model model) {

		List<Ingrediente> ingredienti = ingredienteServ.findAll();
		model.addAttribute("ingredienti", ingredienti);
		return "indexI";

	}

	@GetMapping("/updateI/{id}")
	public String update(Model model, @PathVariable("id") int id) {
		Optional<Ingrediente> ingId = ingredienteServ.findById(id);
		Ingrediente ing = ingId.get();

		model.addAttribute("ing", ing);
		return "updateI";

	}

	@PostMapping("/updateI/{id}")
	public String update(@ModelAttribute("ing") Ingrediente formPizza, Model model) {
		ingredienteServ.save(formPizza);
		return "redirect:/ingredienti";
	}

	@PostMapping("/deleteI/{id}")
	public String delete(@PathVariable("id") int id) {
		ingredienteServ.deleteById(id);
		return "redirect:/ingredienti";
	}

}
