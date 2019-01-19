package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualPet myPet = new VirtualPet(10, 10, 0, "PuppyCat");
		System.out.println("Welcome to Virtual " + myPet.getName() + "!");
		Scanner input = new Scanner(System.in);
		for (;;) {
			System.out.println("\n" + myPet.getName() + ":\nHunger: " + myPet.getHunger() + "\nThirst: "
					+ myPet.getThirst() + "\nHappiness: " + myPet.getHappiness());
			System.out.println("\nWhat do you want to do?\n1. feed\n2. water\n3. play with " + myPet.getName()
					+ "\n4. play video games");
			String actionChoice = input.nextLine();
			if (actionChoice.equalsIgnoreCase("quit")) {
				break;
			}
			String playTypeChoice = "";
			if (actionChoice.equals("3")) {
				for (;;) {
					System.out.println("\nHow would you like to play with " + myPet.getName()
							+ "?\n1. walk\n2. throw ball\n3. teach tricks");
					playTypeChoice = input.nextLine();
					if (playTypeChoice.equals("1") || playTypeChoice.equals("2") || playTypeChoice.equals("3")
							|| playTypeChoice.equalsIgnoreCase("quit")) {
						break;
					} else {
						System.out.println("Choose 1, 2 or 3");
					}
				}
				if (playTypeChoice.equalsIgnoreCase("quit")) {
					break;
				}
			}
			if (actionChoice.equals("1") || actionChoice.equals("2") || actionChoice.equals("3")
					|| actionChoice.equals("4")) {
				System.out.println("\n\n\n\n\n\n\n\n\n" + myPet.petAction(actionChoice, playTypeChoice));
				System.out.println("Time Passes.\n" + myPet.tick());
			} else {
				System.out.println("Choose 1, 2, 3 or 4");
			}
		}
		System.out.println("Goodbye");
		input.close();
	}
}
