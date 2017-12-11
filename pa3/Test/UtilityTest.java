import org.junit.Test;

import static org.junit.Assert.*;

public class UtilityTest {
    int[] testInt = {0};
    Utility testy = new Utility(4,testInt);
    Utility testy2 = new Utility(4,testInt);

    Player tester = new Player("LaQuita");

    @Test
    public void landedOn() throws Exception {
        tester.addProperty(testy);
        testy.setOwner(tester);
        int cash = tester.getCashOnHand();
        testy.landedOn(tester, 3);
        assertEquals(cash-12, tester.getCashOnHand());
        cash = tester.getCashOnHand();
        tester.addProperty(testy2);
        testy2.setOwner(tester);
        testy2.landedOn(tester, 3);
        assertEquals(cash-30, tester.getCashOnHand());
    }

}