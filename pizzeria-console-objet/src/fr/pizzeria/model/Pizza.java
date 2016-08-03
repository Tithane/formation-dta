package fr.pizzeria.model;

public class Pizza {
	
	private static int nbPizza;
	
	private int id;
	private String code;
	private String nom;
	private double prix;
	
	
	//Constructor
	public Pizza(){
		setId(getId()+1);
		setNbPizza(getNbPizza()+1);
	}
	public Pizza(String code, String nom, double prix) {
		super();
		setId(getId()+1);
		this.code = code.toUpperCase();
		this.nom = nom.replace('_',' ');
		this.prix = prix;
		setNbPizza(getNbPizza()+1);
	}

	//getter & setter
	public static int getNbPizza() {
		return nbPizza;
	}
	public static void setNbPizza(int nbPizza) {
		Pizza.nbPizza = nbPizza;
	}
	public int getId() {
		return id;
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
