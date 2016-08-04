package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza pizza0 = new Pizza("PEP", "Pépéroni", 12.50);
		Pizza pizza1 = new Pizza("MAR", "Margherita", 14.00);
		Pizza pizza2 = new Pizza("REIN", "La reine", 11.50);
		Pizza pizza3 = new Pizza("FRO", "La 4 fromages", 12.00);
		Pizza pizza4 = new Pizza("CAN", "Cannibale", 12.50);
		Pizza pizza5 = new Pizza("SAV", "La savoyarde", 13.00);
		Pizza pizza6 = new Pizza("ORI", "L'orientale", 13.50);
		Pizza pizza7 = new Pizza("IND", "L'indienne", 14.00);

		Pizza[] pizzas = new Pizza[] { pizza0, pizza1, pizza2, pizza3, pizza4, pizza5, pizza6, pizza7 };
		Menu(pizzas);
	}

	public static void Menu(Pizza[] pizzas) {
		boolean etat = false;
		System.out.println("***** Pizzeria Administration *****\n");
		do {
			System.out.println("1.  Lister les pizzas");
			System.out.println("2.  Ajouter une nouvelle pizza");
			System.out.println("3.  Mettre à jour une pizza");
			System.out.println("4.  Supprimer une pizza");
			System.out.println("99. Sortir");
			int choise = sc.nextInt();
			switch (choise) {
			case 1:
				List(pizzas);
				break;
			case 2:
				Add(pizzas);
				break;
			case 3:
				Update(pizzas);
				break;
			case 4:
				Delete(pizzas);
				break;
			case 99:
				System.exit(0);
				break;
			default:
				break;
			}

		} while (!etat);
	}

	public static void Add(Pizza[] pizzas) {
		System.out.println("\n");
		System.out.println("Ajout d'une pizza \n");
		Pizza[] newPizzas = new Pizza[(pizzas.length) + 1];
		for (int i = 0; i < pizzas.length; i++) {
			newPizzas[i] = pizzas[i];
		}
		System.out.println("Veuillez saisir le code");
		String code = sc.next();

		System.out.println("Veuillez saisir le nom (Sans espace)");
		String nom = sc.next();

		System.out.println("Veuillez saisir le prix (XX.XX)");
		double prix = sc.nextDouble();
		Pizza npizza = new Pizza(code, nom, prix);
		newPizzas[pizzas.length] = npizza;
		pizzas = newPizzas;
		Menu(pizzas);
	}

	public static void Update(Pizza[] pizzas) {
		System.out.println("Mise à jour d'une pizza \n");
		System.out.println("Choisissez la pizza à modifier :\n");
		for (Pizza pizza : pizzas) {
			System.out.println(
					pizza.getId() + "  - " + pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + ")");
		}
		System.out.println("\n 0- Annuler");
		int selection = sc.nextInt();
		if (selection != 0) {
			Pizza temp;
			for (int i = 0; i < pizzas.length; i++) {
				if (pizzas[i].getId() == selection) {
					temp = pizzas[i];
					System.out.print("Code ? ");
					String ncode = sc.next();
					System.out.print("Nom (Sans espace) ? ");
					String nnom = sc.next();
					System.out.print("Prix (XX.XX) ? ");
					double nprix = sc.nextDouble();
					temp.setCode(ncode);
					temp.setNom(nnom);
					temp.setPrix(nprix);
				}
			}
		}
		Menu(pizzas);
	}

	public static void Delete(Pizza[] pizzas) {
		System.out.println("Suppression d'une pizza \n");
		System.out.println("Choisissez la pizza à Supprimer :\n");
		for (Pizza pizza : pizzas) {
			System.out.println(pizza.getId() + "  - " + pizza.getCode() + "  -> " + pizza.getNom() + " ("
					+ pizza.getPrix() + "€)");
		}
		System.out.println("\n0  - Annuler");
		int selectionDel = sc.nextInt();
		boolean exist = false;
		if (selectionDel != 0) {
			for (int i = 0; i < pizzas.length; i++) {
				if (pizzas[i].getId() == selectionDel) {
					exist = true;
					break;
				}
			}
			if(exist){
				Pizza[] pizzaTemp = new Pizza[pizzas.length - 1];
				int j=0;
				for(int i=0;i<pizzas.length;i++){
					if(pizzas[i].getId()!=selectionDel){
						pizzaTemp[j]=pizzas[i];
						j++;
					}
				}
				pizzas = pizzaTemp;
			}
			
			Pizza.setNbPizza(pizzas.length);
		}
		Menu(pizzas);
	}

	public static void List(Pizza[] pizzas) {
		System.out.println("\n");
		for (Pizza pizza : pizzas) {
			System.out.println(" " + pizza.getCode() + " -> " + pizza.getNom() + " (" + pizza.getPrix() + "€)");
		}
		System.out.println(Pizza.getNbPizza() + " pizza(s) Disponible(s).");
		Menu(pizzas);
	}

}
