package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class AjouterPizzaAction extends Action {

	public AjouterPizzaAction(Scanner sc, Stockage stock) {
		super("Ajouter une pizza", sc, stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		System.out.println("Ajout d'une pizza\n");
		System.out.println("Veuillez saisir le code");
		String code = sc.next();
		System.out.println("Veuillez saisir le nom (Sans espace)");
		String nom = sc.next();
		System.out.println("Veuillez saisir le prix (XX.XX)");
		double prix = sc.nextDouble();

		Pizza newPizza = new Pizza(code, nom, prix);

		stockage.savePizza(newPizza);
	}

}
