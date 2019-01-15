package virtualpet;

public class VirtualPet {

	private int hunger;
	private int thirst;
	private int trained;

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getTrained() {
		return trained;
	}

	public VirtualPet(int hunger, int thirst, int trained) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.trained = trained;
	}

	public void tick() {
		hunger++;
		thirst++;
		if (trained > 0) {
			trained--;
		}

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

	public void train() {
		trained += 3;
	}

	public String action(String menuChoice) {
		 if (menuChoice.equals("1")) {
			feed();
			return "You feed pet";
		} else if (menuChoice.equals("2")) {
			water();
			return "You fill the water bowl";
		}else if (menuChoice.equals("3")) {
			train();
			return "You play with pet";
		}else if (menuChoice.equals("4")) {
			return "You play StarCraft";
		}
		return "Choose 1, 2, 3 or 4";

	}

}
