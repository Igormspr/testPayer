package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.Client;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		List <Client> list = new ArrayList <>();
		
		int opcao = 0;
		
		
		do {
			
			System.out.println("MENU");
			System.out.println("1 - Add client");
			if (!list.isEmpty()) {
			System.out.println("2 - Deposit");
			System.out.println("3 -  Withdraw");
			}
			System.out.println("0 - EXIT");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			
		switch (opcao) {
		
		
		case 1 :
		System.out.print("How many clients will you add? ");
		
		
		
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Enter client number " + i + " data: ");
			try {
				System.out.print("Id:");
				int id = sc.nextInt();
				sc.nextLine(); //Consumir quebra de linha pendente
		    
				String name =null;
				String email = null;
				
		    
				//Solicitar validação do nome
				while (name == null || name.isEmpty() || !isAlpha(name)) {
				System.out.print("Name: ");
				name = sc.nextLine();
				if (name.isEmpty()) {
					throw new IllegalArgumentException("Name cannot be empty!");
				}
				else if (!isAlpha(name)) {
					System.out.println("Name should contain only letters!");	
				}
			}
				
			// Solicitar e validar email
			while (true) {	
			System.out.print("Email: ");
			email = sc.nextLine();
				if (email.isEmpty() || !email.contains("@")) {
					System.out.println("Ivalid email format!");
					
				}
				else {
					break;
				}
			}
				
		
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			Account account = new Account (id, name, email, initialBalance);
			
			list.add(account);
			}catch (InputMismatchException e) {
				System.out.println("Ivalid input. Please enter with a valid input");
				sc.nextLine();
				i--;
				break;
			}
			
		}
		
		System.out.println();
		System.out.println("Client data: ");
		
		for (Client lists: list) {
		System.out.println("----------------------------------------------");
		System.out.println(lists);
		
		}
		
		case 2:
			if (list.isEmpty()) {
				System.out.println("There is no client for a deposit");
			}else
		System.out.println();
		System.out.print("Id for a deposit: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		boolean clientFound = false;
		for (Client client: list) {
			if (client.getId() == id && client instanceof Account) {
				clientFound = true;
				System.out.print("Deposit amount: "); 
				double amount = sc.nextDouble();
				Account account = (Account) client;
				account.deposit(amount);
				System.out.println();
				System.out.println("New balance: \n" + account);
				break;
			}
		}
		
		case 3:
		System.out.println();
		System.out.print("Enter id for withdraw: ");
		id = sc.nextInt();
		System.out.println();
			for (Client client: list) {
				if (client.getId() == id && client instanceof Account) {
					clientFound = true;
					System.out.print("Withdraw amount: "); 
					double amount = sc.nextDouble();
					Account account = (Account) client;
					account.withdraw(amount);
					System.out.println();
					System.out.println("New balance: \n" + account);
					break;
				}
			}
		break;
		
		case 0:
			System.out.println("Saindo do programa...");
			break;
			
		default:
			System.out.println("Opção invalida!");
			}
		
		} while (opcao != 0);
		 
		sc.close();
		
	}
		public static boolean isAlpha(String str) {
			return str.chars().allMatch(Character::isLetter);
		}
		
	}


