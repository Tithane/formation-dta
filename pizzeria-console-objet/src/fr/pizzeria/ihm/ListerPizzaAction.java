package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.PizzaComparatorByPrice;
import fr.pizzeria.service.Stockage;

public class ListerPizzaAction extends Action {

	public ListerPizzaAction(Scanner sc, Stockage stock) {
		super("Lister les pizzas", sc, stock);
	}

	@Override
	public void execute() {
		System.out.println(" ***Liste des Pizzas***\n");
		stockage.findAllPizzas().sort(new PizzaComparatorByPrice());
		for (Pizza pizza : stockage.findAllPizzas()) {
			System.out.println(
					pizza.getId() + ". " + pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + "€)");
		}

		System.out.println("\n Il y a " + Pizza.getNbPizza() + " pizza(s) diponible(s)\n");
	}

}
