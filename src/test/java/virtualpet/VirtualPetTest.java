package virtualpet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VirtualPetTest {
	@Test
	public void tickShouldIncreaseHunger1() {
		VirtualPet underTest = new VirtualPet(0);
		underTest.tick();
		assertEquals(1,underTest.getHunger());
		
	}
	
}
