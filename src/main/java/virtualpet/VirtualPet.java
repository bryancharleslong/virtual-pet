package virtualpet;

public class VirtualPet {

	private int hunger;

	public int getHunger() {
		return hunger;
	}
	
	public VirtualPet(int hunger) {
		this.hunger = hunger;
	}

	public void tick() {
		hunger++;
	}


}
