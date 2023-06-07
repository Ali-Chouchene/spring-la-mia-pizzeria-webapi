package org.java.pizza;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "offerta-speciale")
public class OffertaSpeciale {
	String formatter = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.of(2018, 3, 9));
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String sDate;
	private String eDate;
	private String name;
	private int percentual;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(nullable = false)
	private Pizza pizza;

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public OffertaSpeciale() {
	}

	public OffertaSpeciale(String sDate, String eDate, String name, int percentual, Pizza pizza) {
		setSDate(sDate);
		setEDate(eDate);
		setName(name);
		setPercentual(percentual);
		setPizza(pizza);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSDate() {
		return sDate;
	}

	public void setSDate(String sDate) {
		this.sDate = sDate;
	}

	public String getEDate() {
		return eDate;
	}

	public void setEDate(String eDate) {
		this.eDate = eDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercentual() {
		return percentual;
	}

	public void setPercentual(int percentual) {
		this.percentual = percentual;
	}

	@Override
	public String toString() {

		return "[" + getId() + "] " + getName() + " -  DA:  " + getSDate() + "\n " + "A:  " + getEDate() + "\n ";
	}
}
