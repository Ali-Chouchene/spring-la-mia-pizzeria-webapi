package org.java.pizza;

import java.util.Arrays;
import java.util.List;

import org.java.pizza.serv.IngredienteServ;
import org.java.pizza.serv.OffertaSpecialeService;
import org.java.pizza.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaApplication implements CommandLineRunner {
	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private IngredienteServ ingreServ;

	@Autowired
	private OffertaSpecialeService offertaspecialeservice;

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ingrediente mozz = new Ingrediente("mozzarella");
		Ingrediente pom = new Ingrediente("pomodoro");
		Ingrediente prosc = new Ingrediente("prosciutto");
		ingreServ.save(mozz);
		ingreServ.save(pom);
		ingreServ.save(prosc);

		List<Ingrediente> ingredienti = Arrays.asList(mozz, pom);
		Pizza p1 = new Pizza("Americana", "Pomodoro, Mozzarella, Wurstel",
				"https://external-preview.redd.it/bnDRcRxxhrKkypxeiM8zlAn7J1nfeo-YnIIE2uPAAOY.jpg?width=640&crop=smart&auto=webp&s=cb80465e46dac28e4b2adb8ba652371376b600b2",
				5.5, ingredienti);
		Pizza p2 = new Pizza("Margherita", "Pomodoro, Mozzarella, Patatine",
				"https://www.lemilleeunabontadifranci.it/wp-content/uploads/2021/04/Pizza-margherita-fatta-in-casa-orizzontale.jpg",
				5.50, ingredienti);

		pizzaService.save(p1);
		pizzaService.save(p2);

		OffertaSpeciale o1 = new OffertaSpeciale("10-10-2023", "10-11-2023", "Promo1", 20, p1);
		OffertaSpeciale o2 = new OffertaSpeciale("10-10-2023", "15-10-2023", "Promo2", 35, p1);
		OffertaSpeciale o3 = new OffertaSpeciale("15-10-2023", "10-11-2024", "Promo3", 50, p2);

		offertaspecialeservice.save(o1);
		offertaspecialeservice.save(o2);
		offertaspecialeservice.save(o3);
	}

}
