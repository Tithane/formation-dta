package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ModifierPizzaAction extends Action {

	public ModifierPizzaAction(Scanner sc, Stockage stock) {
		super("Modifier une pizza", sc, stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		System.out.println(" Choissir la pizza � modifier\n");
		for (Pizza pizza : stockage.findAllPizzas()) {
			System.out.println(
					pizza.getId() + ". " + pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + "�)");
		}
		Pizza maPizza = new Pizza(sc.nextInt());

		if (stockage.existPizza(maPizza)) {
			System.out.println("Modification d'une pizza\n");
			System.out.println("Veuillez saisir le code");
			String code = sc.next();
			System.out.println("Veuillez saisir le nom (Sans espace)");
			String nom = sc.next();
			System.out.println("Veuillez saisir le prix (XX.XX)");
			double prix = sc.nextDouble();

			maPizza.setCode(code);
			maPizza.setNom(nom);
			maPizza.setPrix(prix);

			stockage.updatePizza(maPizza);
		} else {
			System.out.println("La pizza s�lectionn� n'existe pas.\n");
		}

	}

}
