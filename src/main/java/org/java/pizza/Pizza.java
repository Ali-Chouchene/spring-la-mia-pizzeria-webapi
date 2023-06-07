package org.java.pizza;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")

public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String descrizione;
	private String foto;
	private Double prezzo;

	@OneToMany(mappedBy = "pizza")
	@JsonIgnore
	private List<OffertaSpeciale> offertaspeciale;

	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Ingrediente> ingredienti;

	public Pizza() {
	}

	public Pizza(String nome, String descrizione, String foto, Double prezzo, List<Ingrediente> ingredienti) {
		setNome(nome);
		setDescrizione(descrizione);
		setFoto(foto);
		setPrezzo(prezzo);

		setIngrediente(ingredienti);
	}

	public int getId() {
		return id;
	}

	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public List<Ingrediente> getIngrediente() {
		return ingredienti;
	}

	public void setIngrediente(List<Ingrediente> ingredienti) {

		this.ingredienti = ingredienti;
	}

	public void addIngrediente(Ingrediente ingrediente) {

		getIngrediente().add(ingrediente);
	}

	public void removeCategory(Ingrediente ingrediente) {

		getIngrediente().remove(ingrediente);
	}

	@Override
	public String toString() {

		return "[" + getId() + "] " + getNome() + " - " + getDescrizione() + "\n " + getPrezzo() + "\n " + getFoto();
	}
}
