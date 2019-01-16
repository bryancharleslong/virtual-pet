package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualPet myPet = new VirtualPet(10, 10, 0, "PuppyCat");
		System.out.println("Welcome to Virtual " + myPet.getName());
		String menuChoice = "";
		String playChoice = "";
		Scanner input = new Scanner(System.in);
		for (;;) {
			System.out.println("\n" + myPet.getName() + ":\nHunger: " + myPet.getHunger() + "\nThirst: "
					+ myPet.getThirst() + "\nHappiness: " + myPet.getHappiness());
			System.out.println("\nWhat do you want to do?\n1. feed\n2. water\n3. play with " + myPet.getName()
					+ "\n4. play video games");
			menuChoice = input.nextLine();
			if (menuChoice.equalsIgnoreCase("quit")) {
				break;
			}
			if (menuChoice.equals("3")) {
				for (;;) {
					System.out.println("\nHow would you like to play?\n1. walk\n2. throw ball\n3. teach tricks");
					playChoice = input.nextLine();
					if (playChoice.equals("1") || playChoice.equals("2") || playChoice.equals("3")
							|| playChoice.equalsIgnoreCase("quit")) {
						break;
					}
				}
				if (playChoice.equalsIgnoreCase("quit")) {
					break;
				}
			}
			System.out.println("\n\n\n\n\n\n\n\n\n" + myPet.menuAction(menuChoice, playChoice));
			if (menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3") || menuChoice.equals("4")) {
				System.out.println(myPet.tick());
			}
		}
		System.out.println("Goodbye");
		input.close();
	}
}
