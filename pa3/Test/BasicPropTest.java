import static org.junit.Assert.*;

import org.junit.Test;

public class BasicPropTest {

	  @Test
	  public void addBuildingTest() {
		  int[] rentList = {1,1,1,1,1};
		  BasicProp testProp = new BasicProp (rentList, "brown", 100,4,rentList);

		  testProp.addBuilding();
		  assertFalse(testProp.isMortgageable());
		  assertEquals(testProp.getBuildings(), 1);
	  }
	  
	  @Test
	  public void removeBuildingTest() {
		  int[] rentList = {1,1,1,1,1};
		  BasicProp testProp = new BasicProp (rentList, "brown", 100,4,rentList);
		  testProp.addBuilding();
		  testProp.addBuilding();
		  testProp.removeBuilding();
		  assertFalse(testProp.isMortgageable());
		  assertEquals(testProp.getBuildings(), 1);
		  testProp.removeBuilding();
		  assertFalse(!testProp.isMortgageable());
		  assertEquals(testProp.getBuildings() ,0);
	  }

	  @Test
	  public void buildingValTest() {
		  int[] rentList = {1,1,1,1,1};

		  BasicProp testPropBrown = new BasicProp (rentList, "brown", 100,4,rentList);
		  BasicProp testPropLtblue = new BasicProp (rentList, "ltblue", 100,4,rentList);
		  BasicProp testPropPink = new BasicProp (rentList, "pink", 100,4,rentList);
		  BasicProp testPropOrange = new BasicProp (rentList, "orange", 100,4,rentList);
		  BasicProp testPropRed = new BasicProp (rentList, "red", 100,4,rentList);
		  BasicProp testPropYellow = new BasicProp (rentList, "yellow", 100,4,rentList);
		  BasicProp testPropGreen = new BasicProp (rentList, "green", 100,4,rentList);
		  BasicProp testPropDkblue = new BasicProp (rentList, "dkblue", 100,4,rentList);


		  assertTrue(testPropBrown.getBuildingCost() == 50 && testPropLtblue.getBuildingCost() == 50);
		  assertTrue(testPropPink.getBuildingCost() == 100 && testPropOrange.getBuildingCost() == 100);
		  assertTrue(testPropRed.getBuildingCost() == 150 && testPropYellow.getBuildingCost() == 150);
		  assertTrue(testPropGreen.getBuildingCost() == 200 && testPropDkblue.getBuildingCost() == 200);
	  }
	  
}
