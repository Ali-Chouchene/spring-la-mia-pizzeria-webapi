package org.java.pizza.api;

import org.java.pizza.Pizza;
import org.springframework.validation.BindingResult;

public class PizzaRes {
	Pizza pizza;
	BindingResult bindingResult;

	public PizzaRes(Pizza pizza) {

		setPizza(pizza);
	}

	public PizzaRes(BindingResult bindingResult) {

		setBindingResult(bindingResult);
	}

	public PizzaRes(Pizza pizza, BindingResult bindingResult) {

		setPizza(pizza);
		setBindingResult(bindingResult);
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
}
