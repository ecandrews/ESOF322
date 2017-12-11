import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialSpaceTest {
    @Test
    public void landedOn() throws Exception {
        int[] testInt = {0};
        SpecialSpace testy = new SpecialSpace("go2Jail", testInt);
        Player tester = new Player("Jimmy");
        testy.landedOn(tester,2);
        assertTrue(tester.getInJail());
        assertEquals(10,tester.getLocationOnBoard());
    }

}