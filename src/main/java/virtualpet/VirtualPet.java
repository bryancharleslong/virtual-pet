package virtualpet;

public class VirtualPet {

	private int hunger;
	private int thirst;
	private int trained;
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

	public int getTrained() {
		return trained;
	}

	public VirtualPet(int hunger, int thirst, int trained, String petName) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.trained = trained;
		this.petName = petName;
	}

	public String tick() {
		if (thirst >= 40) {
			thirst -= 20;
			if (trained <= 20) {
				trained = 0;
			} else {
				trained -= 20;
			}
			return petName + " was thirsty and drank from the toilet.";
		}
		if (hunger >= 30) {
			hunger -= 10;
			if (trained <= 20) {
				trained = 0;
			} else {
				trained -= 20;
			}
			return petName + " was hungry and got into some extra food.";
		}
		hunger++;
		thirst++;
		if (trained > 0) {
			trained--;
		}
		return "Time passes.";
	}

	public void feed() {
		if (hunger > 5) {
			hunger -= 5;
		} else {
			hunger = 0;
		}
	}

	public void water() {
		if (thirst > 3) {
			thirst -= 3;
		} else {
			thirst = 0;
		}
	}

	public String train(String playType) {
		if (playType.equals("1")) {
			trained += 3;
			return "You walk " + petName;
		}
		if (playType.equals("2")) {
			trained += 4;
			return "You throw the ball with " + petName;
		}
		if (playType.equals("3")) {
			trained += 6;
			return "You work on teaching tricks to " + petName;
		}

		return "";
	}

	public String action(String menuChoice, String playType) {
		if (menuChoice.equals("1")) {
			feed();
			return "You feed pet";
		} else if (menuChoice.equals("2")) {
			water();
			return "You fill the water bowl";
		} else if (menuChoice.equals("3")) {
			return train(playType);
		} else if (menuChoice.equals("4")) {
			String petAction;
			if (trained >= 20) {
				petAction = getName() + " waits quietly.";
			} else {
				petAction = getName() + " destroys furniture.";
			}
			String[] games = { "StarCraft", "Diablo", "Mario", "Zelda" };
			return "You play " + games[(int) (Math.random() * games.length)] + ". " + petAction;
		}
		return "Choose 1, 2, 3 or 4";

	}

}
