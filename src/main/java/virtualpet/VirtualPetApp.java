package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualPet myPet = new VirtualPet(10, 10, 0, "PuppyCat");
		System.out.println("Welcome to Virtual " + myPet.getName() + "!");
		String menuActionChoice = "";
		String menuPlayTypeChoice = "";
		Scanner input = new Scanner(System.in);
		for (;;) {
			System.out.println("\n" + myPet.getName() + ":\nHunger: " + myPet.getHunger() + "\nThirst: "
					+ myPet.getThirst() + "\nHappiness: " + myPet.getHappiness());
			System.out.println("\nWhat do you want to do?\n1. feed\n2. water\n3. play with " + myPet.getName()
					+ "\n4. play video games");
			menuActionChoice = input.nextLine();
			if (menuActionChoice.equalsIgnoreCase("quit")) {
				break;
			}
			if (menuActionChoice.equals("3")) {
				for (;;) {
					System.out.println("\nHow would you like to play with " + myPet.getName()
							+ "?\n1. walk\n2. throw ball\n3. teach tricks");
					menuPlayTypeChoice = input.nextLine();
					if (menuPlayTypeChoice.equals("1") || menuPlayTypeChoice.equals("2")
							|| menuPlayTypeChoice.equals("3") || menuPlayTypeChoice.equalsIgnoreCase("quit")) {
						break;
					}
				}
				if (menuPlayTypeChoice.equalsIgnoreCase("quit")) {
					break;
				}
			}
			System.out.println("\n\n\n\n\n\n\n\n\n" + myPet.menuAction(menuActionChoice, menuPlayTypeChoice));
			if (menuActionChoice.equals("1") || menuActionChoice.equals("2") || menuActionChoice.equals("3")
					|| menuActionChoice.equals("4")) {
				System.out.println("Time Passes.\n" + myPet.tick());
			}
		}
		System.out.println("Goodbye");
		input.close();
	}
}
