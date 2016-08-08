package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.NotExistException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class SupprimerPizzaAction extends Action {

	public SupprimerPizzaAction(Scanner sc, Stockage stock) {
		super("Supprimer une pizza", sc, stock);

	}

	@Override
	public void execute() {
		System.out.println(" Choissir la pizza à supprimer\n");
		for (Pizza pizza : stockage.findAllPizzas()) {
			System.out.println(
					pizza.getId() + ". " + pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + "€)");
		}
		Pizza test = new Pizza(sc.nextInt());
		Pizza maPizza = stockage.getPizza(test);
		if (stockage.findAllPizzas().indexOf(maPizza) != -1) {
			try {
				stockage.deletePizza(maPizza);
			} catch (NotExistException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("La pizza sélectionné n'existe pas.\n");
		}
	}

}
