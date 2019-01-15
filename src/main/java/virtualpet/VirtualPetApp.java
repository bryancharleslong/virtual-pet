package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		System.out.println("Welcome");
		VirtualPet myPet = new VirtualPet(10, 10, 0);
		String menuChoice = "";
		Scanner input = new Scanner(System.in);
		for(;;) {
			System.out.println();
			System.out.println("Virtual Pet:\nHunger: " + myPet.getHunger() + "\nThirst: " + myPet.getThirst()
					+ "\nTrained: " + myPet.getTrained());
			System.out.println("1. feed\n2. water\n3. play with pet\n4. play video games");
			menuChoice = input.nextLine();
			if (menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3") || menuChoice.equals("4")) {
				myPet.tick();
			}
			if(menuChoice.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.println(myPet.action(menuChoice));
		}
		System.out.println("Goodbye");
		input.close();
	}

}
