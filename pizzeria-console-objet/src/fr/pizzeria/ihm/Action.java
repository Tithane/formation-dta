package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class Action {

	private String libelle;
	protected Scanner sc;
	protected Stockage stockage;

	public Action(String libelle, Scanner sc, Stockage stock) {
		super();
		this.libelle = libelle;
		this.sc = sc;
		this.stockage = stock;
	}

	public void execute() {
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
