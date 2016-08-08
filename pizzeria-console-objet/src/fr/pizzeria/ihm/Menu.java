package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class Menu {
	private static final int CHOIX_SORTIR = 99;

	private Scanner sc;
	private Map<Integer, Action> actions = new HashMap<Integer, Action>();

	public Menu(Stockage stockage, Scanner scanner) {
		this.sc = scanner;
		this.actions.put(1, new ListerPizzaAction(sc, stockage));
		this.actions.put(2, new AjouterPizzaAction(sc, stockage));
		this.actions.put(3, new ModifierPizzaAction(sc, stockage));
		this.actions.put(4, new SupprimerPizzaAction(sc, stockage));

	}

	public void start() {
		boolean result = false;
		do {
			afficher();
			result = choisir(sc);
		} while (!result);
	}

	public void afficher() {

		for (Integer numero : actions.keySet()) {
			Action actionEnCours = actions.get(numero);
			System.out.println(numero + ". " + actionEnCours.getLibelle());
		}
		System.out.println(CHOIX_SORTIR + ". Quitter");
	}

	public boolean choisir(Scanner scanner) {
		System.out.println("Veuillez choisir une option");
		int choix = scanner.nextInt();
		if (!actions.containsKey(choix)) {
			if (choix != CHOIX_SORTIR) {
				System.out.println("Veuillez nettoyer vos lunettes !! Choisissez une option valide !");
			}
		} else {
			Action laBonneAction = actions.get(choix);
			laBonneAction.execute();
		}
		return choix == CHOIX_SORTIR;
	}

}
