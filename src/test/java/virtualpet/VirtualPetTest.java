package virtualpet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class VirtualPetTest {
	@Test
	public void getNameShouldReturnNameString() {
		VirtualPet underTest = new VirtualPet(10, 10, 10, "name string");
		String testName = underTest.getName();
		assertEquals("name string", testName);
	}

	@Test
	public void tickShouldIncreaseHunger1() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, null);
		underTest.tick();
		assertEquals(1, underTest.getHunger());

	}

	@Test
	public void tickShouldIncreaseThirst1() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, null);
		underTest.tick();
		assertEquals(1, underTest.getThirst());
	}

	@Test
	public void tickShouldDecreaseTrained1() {
		VirtualPet underTest = new VirtualPet(0, 0, 2, null);
		underTest.tick();
		assertEquals(1, underTest.getTrained());
	}

	@Test
	public void tickTrainedMinimumIs0() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, null);
		underTest.tick();
		assertEquals(0, underTest.getTrained());
	}

	@Test
	public void feedShouldDecreaseHunger5() {
		VirtualPet underTest = new VirtualPet(10, 0, 0, null);
		underTest.feed();
		assertEquals(5, underTest.getHunger());
	}

	@Test
	public void waterShouldDecreaseThirst3() {
		VirtualPet underTest = new VirtualPet(0, 10, 0, null);
		underTest.water();
		assertEquals(7, underTest.getThirst());
	}

	@Test
	public void playWalkShouldIncreaseTrained3() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, null);
		underTest.train("1");
		assertEquals(3, underTest.getTrained());
	}
	
	@Test
	public void playTricksShouldIncreaseTrained6() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, null);
		underTest.train("3");
		assertEquals(6,underTest.getTrained());
	}

	@Test
	public void action1shouldFeed() {
		VirtualPet underTest = new VirtualPet(10, 10, 10, null);
		String message = underTest.action("1", "");
		assertEquals(5, underTest.getHunger());
		assertEquals("You feed pet", message);

	}

	@Test
	public void action2shouldWater() {
		VirtualPet underTest = new VirtualPet(10, 10, 10, null);
		String message = underTest.action("2", "");
		assertEquals(7, underTest.getThirst());
		assertEquals("You fill the water bowl", message);

	}

	@Test
	public void trainedPetShouldWaitWhileGaming() {
		VirtualPet underTest = new VirtualPet(10, 10, 50, null);
		String message = underTest.action("4", "");
		assertTrue(message.contains("waits quietly"));
	}

	@Test
	public void untrainedPetDestroysWhileGaming() {
		VirtualPet underTest = new VirtualPet(10, 10, 10, null);
		String message = underTest.action("4", "");
		assertTrue(message.contains("destroys furniture"));
	}
	
	@Test
	public void hungryPetEats10DecreasesTrained20() {
		VirtualPet underTest = new VirtualPet(50,10,50,null);
		underTest.tick();
		assertEquals(40,underTest.getHunger());
		assertEquals(30,underTest.getTrained());
	}
	
	@Test
	public void thirstyPetDrinks20DecreasesTrained20() {
		VirtualPet underTest = new VirtualPet(10,50,50,null);
		underTest.tick();
		assertEquals(30,underTest.getThirst());
		assertEquals(30,underTest.getTrained());
	}
	
	@Test
	public void hungryPetGoesTo0TrainingMinimum() {
		VirtualPet underTest = new VirtualPet(50,10,10,null);
		underTest.tick();
		assertEquals(0,underTest.getTrained());
	}
	@Test
	public void thirstyPetGoesTo0TrainingMinimum() {
		VirtualPet underTest = new VirtualPet(10,50,10,null);
		underTest.tick();
		assertEquals(0,underTest.getTrained());
	}

}
