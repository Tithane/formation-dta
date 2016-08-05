package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.service.Stockage;

public class Menu {
	private static final int CHOIX_SORTIR = 99;

	private Scanner sc;
	private Action[] actions;

	public Menu(Stockage stockage, Scanner scanner) {
		this.sc = scanner;
		this.actions = new Action[] { new ListerPizzaAction(sc, stockage), new AjouterPizzaAction(sc, stockage),
				new ModifierPizzaAction(sc, stockage), new SupprimerPizzaAction(sc, stockage) };
	}

	public void start() {
		boolean result = false;
		do {
			afficher();
			result = choisir(sc);
		} while (!result);
	}

	public void afficher() {
		for (int i = 0; i < actions.length; i++) {
			String libelleAction = actions[i].getLibelle();
			int indexMenu = i + 1;
			System.out.println(indexMenu + ". " + libelleAction);
		}
		System.out.println(CHOIX_SORTIR + ". Quitter");
	}

	public boolean choisir(Scanner scanner) {
		System.out.println("Veuillez choisir une option");
		int choix = scanner.nextInt();

		if (choix <= 0 || choix > actions.length) {
			if (choix != CHOIX_SORTIR) {
				System.out.println("Veuillez nettoyer vos lunettes !! Choisissez une option valide !");
			}
		} else {
			Action laBonneAction = actions[choix - 1];
			laBonneAction.execute();
		}
		return choix == CHOIX_SORTIR;
	}

}
