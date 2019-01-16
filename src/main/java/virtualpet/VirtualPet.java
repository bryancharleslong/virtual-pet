package virtualpet;

public class VirtualPet {

	private int hunger;
	private int thirst;
	private int happiness;
	private String petName;

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getHappiness() {
		return happiness;
	}

	public String getName() {
		return petName;
	}

	public VirtualPet(int hunger, int thirst, int happiness, String petName) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.happiness = happiness;
		this.petName = petName;
	}

	public String tick() {
		if (thirst >= 40) {
			thirst -= 20;
			if (happiness <= 40) {
				happiness = 0;
			} else {
				happiness -= 40;
			}
			return petName + " was thirsty and drank from the toilet.";
		}
		if (hunger >= 30) {
			hunger -= 10;
			if (happiness <= 40) {
				happiness = 0;
			} else {
				happiness -= 40;
			}
			return petName + " was hungry and got into some extra food.";
		}
		hunger++;
		thirst++;
		if (happiness > 0) {
			happiness--;
		}
		if (thirst >= 35) {
			return getName() + " looks thirsty.";
		} else if (hunger >= 25) {
			return getName() + " looks hungry.";
		} else if (happiness >= 20) {
			return getName() + " looks content.";
		} else {
			return getName() + " looks restless.";
		}
	}

	public String menuAction(String menuActionChoice, String menuPlayTypeChoice) {
		if (menuActionChoice.equals("1")) {
			return feed();
		} else if (menuActionChoice.equals("2")) {
			return water();
		} else if (menuActionChoice.equals("3")) {
			return playWithPet(menuPlayTypeChoice);
		} else if (menuActionChoice.equals("4")) {
			return playGame();
		}
		return "Choose 1, 2, 3 or 4";
	}

	private String feed() {
		if (hunger > 5) {
			hunger -= 5;
		} else {
			hunger = 0;
		}
		return "You feed " + petName + ".";
	}

	private String water() {
		if (thirst > 3) {
			thirst -= 3;
		} else {
			thirst = 0;
		}
		return "You fill " + petName + "'s water bowl.";
	}

	private String playWithPet(String menuPlayTypeChoice) {
		if (menuPlayTypeChoice.equals("1")) {
			happiness += 3;
			return "You walk " + petName + ".";
		}
		if (menuPlayTypeChoice.equals("2")) {
			happiness += 4;
			return "You throw the ball with " + petName + ".";
		}
		if (menuPlayTypeChoice.equals("3")) {
			happiness += 6;
			return "You work on teaching tricks to " + petName + ".";
		}
		return "";
	}

	private String playGame() {
		String petResponseToVideoGame;
		if (happiness >= 20) {
			petResponseToVideoGame = getName() + " waits quietly.";
		} else {
			petResponseToVideoGame = getName() + " destroys furniture.";
		}
		String[] videoGames = { "StarCraft", "Diablo", "Mario", "Zelda", "Halo" };
		return "You play " + videoGames[(int) (Math.random() * videoGames.length)] + ". " + petResponseToVideoGame;
	}

}
