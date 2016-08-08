package fr.pizzeria.service;

import java.util.List;

import fr.pizzeria.exception.NotExistException;
import fr.pizzeria.model.Pizza;

public interface Stockage {

	List<Pizza> findAllPizzas();

	void savePizza(Pizza newPizza);

	void updatePizza(Pizza maPizza) throws NotExistException;

	void deletePizza(Pizza maPizza) throws NotExistException;

	boolean existPizza(Pizza maPizza);

	Pizza getPizza(Pizza maPizza);
}
