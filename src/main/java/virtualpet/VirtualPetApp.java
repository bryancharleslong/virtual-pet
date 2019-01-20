package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		VirtualPet myPet = new VirtualPet(10, 10, 0, "PuppyCat");
		System.out.println("Welcome to Virtual " + myPet.getName() + "!\nType \"Quit\" at any time.");
		Scanner input = new Scanner(System.in);
		String actionChoice = "1";
		String playTypeChoice = "1";
		do {
			if (myPet.checkValidInput(actionChoice, playTypeChoice)) {
				System.out.println("\n" + myPet.getName() + ":\nHunger: " + myPet.getHunger() + "\nThirst: "
						+ myPet.getThirst() + "\nHappiness: " + myPet.getHappiness());
				System.out.println("\nWhat do you want to do?\n1. feed\n2. water\n3. play with " + myPet.getName()
						+ "\n4. play video games");
			} else {
				System.out.println("Enter 1, 2, 3 or 4");
			}
			actionChoice = input.nextLine();
			if (actionChoice.equals("3")) {
				do {
					if (myPet.checkValidInput(actionChoice, playTypeChoice)) {
						System.out.println("\nHow would you like to play with " + myPet.getName()
								+ "?\n1. walk\n2. throw ball\n3. teach tricks");
					} else {
						System.out.println("Enter 1, 2 or 3");
					}
					playTypeChoice = input.nextLine();
				} while (!myPet.checkValidInput(actionChoice, playTypeChoice) && !playTypeChoice.equalsIgnoreCase("quit"));
			}
			if (myPet.checkValidInput(actionChoice, playTypeChoice)) {
				System.out.println("\n\n\n\n\n\n\n\n\n" + myPet.petAction(actionChoice, playTypeChoice));
				System.out.println("Time Passes.\n" + myPet.tick());
			}
		} while (!actionChoice.equalsIgnoreCase("quit") && !playTypeChoice.equalsIgnoreCase("quit"));
		System.out.println("Goodbye");
		input.close();
	}
}
