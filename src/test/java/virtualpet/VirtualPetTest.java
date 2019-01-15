package virtualpet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VirtualPetTest {
	@Test
	public void tickShouldIncreaseHunger1() {
		VirtualPet underTest = new VirtualPet(0, 0, 0);
		underTest.tick();
		assertEquals(1, underTest.getHunger());

	}

	@Test
	public void tickShouldIncreaseThirst1() {
		VirtualPet underTest = new VirtualPet(0, 0, 0);
		underTest.tick();
		assertEquals(1, underTest.getThirst());
	}

	@Test
	public void tickShouldDecreaseTrained1() {
		VirtualPet underTest = new VirtualPet(0, 0, 2);
		underTest.tick();
		assertEquals(1, underTest.getTrained());
	}

	@Test
	public void tickTrainedMinimumIs0() {
		VirtualPet underTest = new VirtualPet(0, 0, 0);
		underTest.tick();
		assertEquals(0, underTest.getTrained());
	}

	@Test
	public void feedShouldDecreaseHunger5() {
		VirtualPet underTest = new VirtualPet(10, 0, 0);
		underTest.feed();
		assertEquals(5, underTest.getHunger());
	}

	@Test
	public void waterShouldDecreaseThirst3() {
		VirtualPet underTest = new VirtualPet(0, 10, 0);
		underTest.water();
		assertEquals(7, underTest.getThirst());
	}
	
	@Test
	public void trainShouldIncreaseTrained3() {
		VirtualPet underTest = new VirtualPet(0, 0, 0);
		underTest.train();
		assertEquals(3, underTest.getTrained());
	}
	@Test
	public void action1shouldFeed() {
		VirtualPet underTest = new VirtualPet(10,10,10);
		String message = underTest.action("1");
		assertEquals(5,underTest.getHunger());
		assertEquals("You feed pet",message);
		
	}
	@Test
	public void action2shouldWater() {
		VirtualPet underTest = new VirtualPet(10,10,10);
		String message = underTest.action("2");
		assertEquals(7,underTest.getThirst());
		assertEquals("You fill the water bowl",message);
		
	}
	

}
