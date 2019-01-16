package virtualpet;

public class VirtualPet {

	private int hunger;
	private int thirst;
	private int happiness;
	private String petName;

	public String getName() {
		return petName;
	}

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getHappiness() {
		return happiness;
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
			if (happiness <= 20) {
				happiness = 0;
			} else {
				happiness -= 20;
			}
			return petName + " was thirsty and drank from the toilet.";
		}
		if (hunger >= 30) {
			hunger -= 10;
			if (happiness <= 20) {
				happiness = 0;
			} else {
				happiness -= 20;
			}
			return petName + " was hungry and got into some extra food.";
		}
		hunger++;
		thirst++;
		if (happiness > 0) {
			happiness--;
		}
		return "Time passes.";
	}

	public String menuAction(String menuChoice, String playType) {
		if (menuChoice.equals("1")) {
			return feed();
		} else if (menuChoice.equals("2")) {
			return water();
		} else if (menuChoice.equals("3")) {
			return train(playType);
		} else if (menuChoice.equals("4")) {
			return playGame();
		}
		return "Choose 1, 2, 3 or 4";
	}
	
	private String playGame() {
		String petAction;
		if (happiness >= 20) {
			petAction = getName() + " waits quietly.";
		} else {
			petAction = getName() + " destroys furniture.";
		}
		String[] games = { "StarCraft", "Diablo", "Mario", "Zelda", "Halo" };
		return "You play " + games[(int) (Math.random() * games.length)] + ". " + petAction;
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

	private String train(String playType) {
		if (playType.equals("1")) {
			happiness += 3;
			return "You walk " + petName + ".";
		}
		if (playType.equals("2")) {
			happiness += 4;
			return "You throw the ball with " + petName + ".";
		}
		if (playType.equals("3")) {
			happiness += 6;
			return "You work on teaching tricks to " + petName + ".";
		}
		return "";
	}

}
