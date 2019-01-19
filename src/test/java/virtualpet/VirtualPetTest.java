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
	public void tickShouldDecreaseHappiness1() {
		VirtualPet underTest = new VirtualPet(0, 0, 2, null);
		underTest.tick();
		assertEquals(1, underTest.getHappiness());
	}

	@Test
	public void tickHappinessMinimumIs0() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, null);
		underTest.tick();
		assertEquals(0, underTest.getHappiness());
	}

	@Test
	public void feedShouldDecreaseHunger5() {
		VirtualPet underTest = new VirtualPet(10, 0, 0, null);
		underTest.petAction("1","");
		assertEquals(5, underTest.getHunger());
	}

	@Test
	public void waterShouldDecreaseThirst3() {
		VirtualPet underTest = new VirtualPet(0, 10, 0, null);
		underTest.petAction("2","");
		assertEquals(7, underTest.getThirst());
	}

	@Test
	public void playWalkShouldIncreaseHappiness3() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, null);
		underTest.petAction("3","1");
		assertEquals(3, underTest.getHappiness());
	}
	
	@Test
	public void playTricksShouldIncreaseHappiness6() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, null);
		underTest.petAction("3","3");
		assertEquals(6,underTest.getHappiness());
	}

	@Test
	public void action1shouldFeed() {
		VirtualPet underTest = new VirtualPet(10, 10, 10, null);
		String message = underTest.petAction("1", "");
		assertEquals(5, underTest.getHunger());
		assertTrue(message.contains("You feed"));

	}

	@Test
	public void action2shouldWater() {
		VirtualPet underTest = new VirtualPet(10, 10, 10, null);
		String message = underTest.petAction("2", "");
		assertEquals(7, underTest.getThirst());
		assertTrue(message.contains("water bowl"));

	}

	@Test
	public void happyPetShouldWaitWhileGaming() {
		VirtualPet underTest = new VirtualPet(10, 10, 50, null);
		String message = underTest.petAction("4", "");
		assertTrue(message.contains("waits quietly"));
	}

	@Test
	public void unhappyPetDestroysWhileGaming() {
		VirtualPet underTest = new VirtualPet(10, 10, 10, null);
		String message = underTest.petAction("4", "");
		assertTrue(message.contains("destroys furniture"));
	}
	
	@Test
	public void hungryPetEats10DecreasesHappiness40() {
		VirtualPet underTest = new VirtualPet(50,10,50,null);
		underTest.tick();
		assertEquals(40,underTest.getHunger());
		assertEquals(10,underTest.getHappiness());
	}
	
	@Test
	public void thirstyPetDrinks20DecreasesHappiness40() {
		VirtualPet underTest = new VirtualPet(10,50,50,null);
		underTest.tick();
		assertEquals(30,underTest.getThirst());
		assertEquals(10,underTest.getHappiness());
	}
	
	@Test
	public void hungryPetGoesToHappinessMinimumOf0() {
		VirtualPet underTest = new VirtualPet(50,10,10,null);
		underTest.tick();
		assertEquals(0,underTest.getHappiness());
	}
	@Test
	public void thirstyPetGoesToHappinessMinimumOf0() {
		VirtualPet underTest = new VirtualPet(10,50,10,null);
		underTest.tick();
		assertEquals(0,underTest.getHappiness());
	}

}
