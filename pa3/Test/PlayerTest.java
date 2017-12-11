import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayerTest {


	@Test
	public void cashTest() {
		Player testPlayer = new Player("testPlayer");
		assertEquals(1500, (int)testPlayer.getCashOnHand());
		testPlayer.setCashOnHand(0);
		assertEquals(1500, (int)testPlayer.getCashOnHand());
		testPlayer.setCashOnHand(-1500);
		assertEquals(0, (int)testPlayer.getCashOnHand());
		testPlayer.setCashOnHand(100);
		assertEquals(100, (int)testPlayer.getCashOnHand());
		testPlayer.setCashOnHand(1000000);
		assertEquals(1000100, (int)testPlayer.getCashOnHand());
	}

	@Test
	public void luxTaxTest() {
		Player testPlayer = new Player("testPlayer");
		testPlayer.MeatyTax();
		assertEquals((1500 -75), (int)testPlayer.getCashOnHand());
	}

	@Test
	public void propTaxTest() {
		Player testPlayer = new Player("testPlayer");
		testPlayer.oMeatTax();
		assertEquals((1500 -200), (int)testPlayer.getCashOnHand());
	}

	@Test
	public void propsOwnedTest() {
		Player testPlayer = new Player("testPlayer");
		int[] rentList = {1};
		BasicProp prop1 = new BasicProp(rentList, "color", 100,4, rentList);
		BasicProp prop2 = new BasicProp(rentList, "color", 100,4, rentList);
		BasicProp prop3 = new BasicProp(rentList, "color", 100,4, rentList);

		ArrayList<BasicProp> propList = new ArrayList<>();
		assertEquals(propList, testPlayer.getBPropsOwned());
		testPlayer.addProperty(prop1);
		testPlayer.addProperty(prop2);
		testPlayer.addProperty(prop3);
		propList.add(prop1);
		propList.add(prop2);
		propList.add(prop3);
		assertEquals(propList, testPlayer.getBPropsOwned());
		testPlayer.removeProperty(prop1);
		testPlayer.removeProperty(prop2);
		testPlayer.removeProperty(prop3);
		propList.remove(prop1);
		propList.remove(prop2);
		propList.remove(prop3);
		assertEquals(propList, testPlayer.getBPropsOwned());
	}

	@Test
	public void railroadsOwnedTest() {
		Player testPlayer = new Player("testPlayer");
		int[] testInt={0};
		Railroad prop1 = new Railroad(4,testInt);
		Railroad prop2 = new Railroad(4,testInt);
		Railroad prop3 = new Railroad(4,testInt);

		assertEquals(0, testPlayer.getNumRailroadsOwned());
		testPlayer.addProperty(prop1);
		testPlayer.addProperty(prop2);
		testPlayer.addProperty(prop3);
		assertEquals(3, testPlayer.getNumRailroadsOwned());
		testPlayer.removeProperty(prop1);
		testPlayer.removeProperty(prop2);
		testPlayer.removeProperty(prop3);
		assertEquals(0, testPlayer.getNumRailroadsOwned());
	}

	@Test
	public void setJailTest() {
		Player testPlayer = new Player("testPlayer");
		testPlayer.setInJail(true);
		assertTrue(testPlayer.getInJail());
		assertEquals(10, testPlayer.getLocationOnBoard());
	}


}
