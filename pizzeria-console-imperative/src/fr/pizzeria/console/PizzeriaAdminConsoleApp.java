package fr.pizzeria.console;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] pizzas= new String[][] {{"PEP","Pépéroni","12.50"},{"MAR","Margarita","14.00"}};
		Menu(pizzas);
	}

	public static void  Menu(String[][]pizzas){
		boolean etat = false;
		System.out.println("***** Pizzeria Administration *****\n");
		do{
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
			
		}while(!etat);
	}
	public static void Add(String[][] pizzas){

		System.out.println("\n");
		System.out.println("Ajout d'une pizza \n");
		String[][]newPizzas = new String [(pizzas.length)+1][3];
		for(int i = 0; i < pizzas.length ; i++ ){
			for (int j = 0 ; j < 3 ;j++){
				newPizzas[i][j] = pizzas[i][j];
			}
		}
		System.out.println("Veuillez saisir le code (3 caractères)");
		String code = sc.next();
		
		System.out.println("Veuillez saisir le nom (Sans espace)");
		String nom = sc.next();
		
		System.out.println("Veuillez saisir le prix (XX.XX)");
		String prix = sc.next();
		
		if(code.length()>3)code = "err";
		newPizzas[pizzas.length][0]= code.toUpperCase();
		newPizzas[pizzas.length][1]= nom;
		newPizzas[pizzas.length][2]= prix;
		
		pizzas = newPizzas ;
		Menu(pizzas);
	}
	public static void Update(String[][] pizzas){
		System.out.println("Mise à jour d'une pizza \n");
		System.out.println("Choisissez la pizza à modifier :\n");
		int index = 0;
		for (String[] pizza : pizzas) {
			System.out.println(index+"  - "+pizza[0]+" -> "+pizza[1]+" ("+pizza[2]+")");
			index++;
		}
		System.out.println("\n 99- Annuler");
		int selection = sc.nextInt();
		if(selection != 99){
			if(selection < pizzas.length){
				System.out.print("Code (3 caractères) ?");
				String ncode = sc.next();
				System.out.print("Nom (Sans espace) ?");
				String nnom = sc.next();
				System.out.print("Prix (XX.XX) ?");
				String nprix = sc.next();
				if(ncode.length()>3)ncode = "err";
				pizzas[selection][0]= ncode.toUpperCase();
				pizzas[selection][1]= nnom;
				pizzas[selection][2]= nprix;
				}
			}else{}
		Menu(pizzas);
	}
	public static void Delete(String[][]pizzas){
		System.out.println("Suppression d'une pizza \n");
		System.out.println("Choisissez la pizza à Supprimer :\n");
		String [][] pizzaTemp = new String[pizzas.length-1][3];
		int indexDel = 0;
		for (String[] pizza : pizzas) {
			System.out.println(indexDel+"  - "+pizza[0]+" -> "+pizza[1]+" ("+pizza[2]+")");
			indexDel++;
		}
		System.out.println("\n 99- Annuler");
		int selectionDel = sc.nextInt();
		if(selectionDel != 99){
			if(selectionDel < pizzas.length){
				for(int i = 0; i < pizzaTemp.length ; i++ ){
					for (int j = 0 ; j < 3 ;j++){
						if(pizzas[i][j] != pizzas[selectionDel][j])
						pizzaTemp[i][j] = pizzas[i][j];
					}
				}
				pizzas = pizzaTemp;
			}
		}else{}
		Menu(pizzas);
	}
	public static void List(String[][]pizzas){
		System.out.println("\n");
		for (String[] pizza : pizzas) {
			System.out.println(pizza[0]+" -> "+pizza[1]+" ("+pizza[2]+")");
		}
		Menu(pizzas);
	}
}

