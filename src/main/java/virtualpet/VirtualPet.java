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
		String tickMessage;
		if (thirst >= 40) {
			thirst -= 20;
			hunger++;
			happiness -= 40;
			if (happiness < 0) {
				happiness = 0;
			}
			tickMessage = petName + " was thirsty and drank from the toilet!";
		} else if (hunger >= 30) {
			hunger -= 10;
			thirst++;
			happiness -= 40;
			if (happiness < 0) {
				happiness = 0;
			}
			tickMessage = petName + " was hungry and got into some extra food!";
		} else {
			hunger++;
			thirst++;
			if (happiness > 0) {
				happiness--;
			}
			if (thirst >= 35) {
				tickMessage = getName() + " looks thirsty.";
			} else if (hunger >= 25) {
				tickMessage = getName() + " looks hungry.";
			} else if (happiness >= 20) {
				tickMessage = getName() + " looks content.";
			} else {
				tickMessage = getName() + " looks restless.";
			}
		}
		return tickMessage;
	}

	public boolean checkValidInput(String actionChoice, String playTypeChoice) {
		if ((actionChoice.equals("1") || actionChoice.equals("2") || actionChoice.equals("3")
				|| actionChoice.equals("4"))
				&& (playTypeChoice.equals("1") || playTypeChoice.equals("2") || playTypeChoice.equals("3"))) {
			return true;
		} else {
			return false;
		}
	}

	public String petAction(String actionChoice, String playTypeChoice) {
		String actionMessage = "no action";
		if (actionChoice.equals("1")) {
			actionMessage = feed();
		} else if (actionChoice.equals("2")) {
			actionMessage = water();
		} else if (actionChoice.equals("3")) {
			actionMessage = playWithPet(playTypeChoice);
		} else if (actionChoice.equals("4")) {
			actionMessage = playGame();
		}
		return actionMessage;
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

	private String playWithPet(String playTypeChoice) {
		String playMessage = "no play";
		if (playTypeChoice.equals("1")) {
			happiness += 3;
			playMessage = "You walk " + petName + ".";
		} else if (playTypeChoice.equals("2")) {
			happiness += 4;
			playMessage = "You throw the ball with " + petName + ".";
		} else if (playTypeChoice.equals("3")) {
			happiness += 6;
			playMessage = "You work on teaching tricks to " + petName + ".";
		}
		return playMessage;
	}

	private String playGame() {
		String petResponseToVideoGame;
		if (happiness >= 20) {
			petResponseToVideoGame = getName() + " waits quietly.";
		} else {
			petResponseToVideoGame = getName() + " destroys furniture!";
		}
		String[] videoGames = { "StarCraft", "Diablo", "Mario", "Zelda", "Halo" };
		return "You play " + videoGames[(int) (Math.random() * videoGames.length)] + ". " + petResponseToVideoGame;
	}
}
