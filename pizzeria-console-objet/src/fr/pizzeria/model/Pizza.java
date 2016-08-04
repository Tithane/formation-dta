package fr.pizzeria.model;

public class Pizza {
	
	private static int nbPizza;
	private static int idPiz;
	
	private int id;
	private String code;
	private String nom;
	private double prix;
	
	
	//Constructor
	public Pizza(String code, String nom, double prix) {
		super();
		setId(idPiz+1);
		this.code = code.toUpperCase();
		this.nom = nom.replace('_',' ');
		this.prix = prix;
		nbPizza++;
		idPiz++;
	}

	//getter & setter
	
	public int getId() {
		return id;
	}
	public static void setNbPizza(int nbPizza) {
		Pizza.nbPizza = nbPizza;
	}

	public static int getNbPizza() {
		return nbPizza;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
}
