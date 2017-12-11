import org.junit.Test;

import static org.junit.Assert.*;

public class UtilityTest {
    int[] testCoord = {0};
    Utility testUtility1 = new Utility(4,testCoord);
    Utility testUtility2 = new Utility(4,testCoord);
    Player testPlayer = new Player("LaQuita");

    @Test
    public void landedOn() throws Exception {
        testPlayer.addProperty(testUtility1);
        testUtility1.setOwner(testPlayer);
        int cash = testPlayer.getCashOnHand();
        int rent = testUtility1.landedOn(testPlayer, 3);
        testPlayer.setCashOnHand(rent*-1);
        assertEquals(cash-12, testPlayer.getCashOnHand());
        cash = testPlayer.getCashOnHand();
        testPlayer.addProperty(testUtility2);
        testUtility2.setOwner(testPlayer);
        rent= testUtility2.landedOn(testPlayer, 3);
        testPlayer.setCashOnHand(rent*-1);
        assertEquals(cash-30, testPlayer.getCashOnHand());
    }

    @Test
    public void constructorTest() throws Exception {
        assertEquals(testUtility1.getRent(1), 0);
        assertEquals(testUtility1.getBuildings(), 0);
        assertEquals(testUtility1.getValue(), 150);
        assertEquals(testUtility1.getCoord(), testCoord);
        assertEquals(testUtility1.isMortgageable(), true);
        assertEquals(testUtility1.isOwned() , false);
        assertEquals(testUtility1.getLocation(), 4);
    }

}