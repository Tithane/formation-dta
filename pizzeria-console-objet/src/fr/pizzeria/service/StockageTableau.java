package fr.pizzeria.service;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.NotExistException;
import fr.pizzeria.model.Pizza;

public class StockageTableau implements Stockage {

	public List<Pizza> listePizza = new ArrayList<Pizza>();

	public StockageTableau() {
		super();
		listePizza.add(new Pizza("PEP", "Pépéroni", 12.50));
		listePizza.add(new Pizza("CAN", "La cannibale", 12.50));
		listePizza.add(new Pizza("REI", "La Reine", 11.50));
		listePizza.add(new Pizza("ORI", "L'orientale", 13.50));
		listePizza.add(new Pizza("MAR", "Margherita", 14.00));
		listePizza.add(new Pizza("SAV", "La savoyarde", 13.00));
		listePizza.add(new Pizza("FRO", "La 4 fromages", 12.00));
		listePizza.add(new Pizza("IND", "L'indienne", 14.00));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listePizza;
	}

	@Override
	public void savePizza(Pizza newPizza) {
		listePizza.add(newPizza);
		System.out.println("Pizza n°= " + newPizza.getId() + " ajoutée avec succes.\n");
	}

	@Override
	public void updatePizza(Pizza maPizza) throws NotExistException {
		int index = listePizza.indexOf(this.getPizza(maPizza));
		listePizza.set(index, maPizza);
		System.out.println("Pizza n°= " + maPizza.getId() + " modifiée avec succes.\n");
	}

	@Override
	public void deletePizza(Pizza maPizza) throws NotExistException {
		int index = listePizza.indexOf(this.getPizza(maPizza));
		listePizza.remove(index);
		Pizza.setNbPizza(listePizza.size());
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

	@Override
	public Pizza getPizza(Pizza maPizza) {
		Pizza test = null;
		for (Pizza pizza : listePizza) {
			if (pizza.getId() == maPizza.getId()) {
				test = pizza;
				break;
			}

		}
		return test;
	}

}
