package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {
	public Pizza[] listePizza = { new Pizza("PEP", "Pépéroni", 12.50), new Pizza("MAR", "Margherita", 14.00),
			new Pizza("REI", "La Reine", 11.50), new Pizza("FRO", "La 4 fromages", 12.00),
			new Pizza("CAN", "La cannibale", 12.50), new Pizza("SAV", "La savoyarde", 13.00),
			new Pizza("ORI", "L'orientale", 13.50), new Pizza("IND", "L'indienne", 14.00) };

	@Override
	public Pizza[] findAllPizzas() {
		return listePizza;
	}

	@Override
	public void savePizza(Pizza newPizza) {
		Pizza[] pizzaList = new Pizza[listePizza.length + 1];

		for (int i = 0; i < listePizza.length; i++) {
			pizzaList[i] = listePizza[i];
		}
		pizzaList[listePizza.length] = newPizza;

		listePizza = pizzaList;
		System.out.println("Pizza n°= " + newPizza.getId() + " ajoutée avec succes.\n");
	}

	@Override
	public void updatePizza(Pizza maPizza) {
		Pizza[] pizzaList = new Pizza[listePizza.length];
		int i = 0;
		for (Pizza pizza : listePizza) {
			if (pizza.getId() == maPizza.getId()) {
				pizzaList[i] = maPizza;
			} else {
				pizzaList[i] = pizza;
			}
			i++;
		}
		listePizza = pizzaList;
		System.out.println("Pizza n°= " + maPizza.getId() + " modifiée avec succes.\n");
	}

	@Override
	public void deletePizza(Pizza maPizza) {
		Pizza[] pizzaList = new Pizza[listePizza.length - 1];
		int j = 0;
		for (int i = 0; i < listePizza.length; i++) {
			if (listePizza[i].getId() != maPizza.getId()) {
				pizzaList[j] = listePizza[i];
				j++;
			}
		}
		listePizza = pizzaList;
		Pizza.setNbPizza(listePizza.length);
		System.out.println("Pizza n°= " + maPizza.getId() + " supprimée avec succes.\n");

	}

	@Override
	public boolean existPizza(Pizza maPizza) {
		boolean exist = false;
		for (Pizza pizza : listePizza) {
			if (pizza.getId() == maPizza.getId()) {
				exist = true;
				break;
			}
		}
		return exist;
	}

}
