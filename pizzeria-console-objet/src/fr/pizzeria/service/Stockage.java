package fr.pizzeria.service;

import fr.pizzeria.model.Pizza;

public interface Stockage {

	Pizza[] findAllPizzas();

	void savePizza(Pizza newPizza);

	void updatePizza(Pizza maPizza);

	void deletePizza(Pizza maPizza);

	boolean existPizza(Pizza maPizza);
}
