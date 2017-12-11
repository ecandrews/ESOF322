import org.junit.Test;

import static org.junit.Assert.*;

public class RailroadTest {
    Player testy = new Player("Bilbo");
    int[] testInt = {0};
    Railroad tester = new Railroad(4,testInt);

    @Test
    public void getRent() throws Exception {
        tester.setOwner(testy);
        testy.addProperty(tester);
        assertEquals(25,tester.getRent());
        testy.addProperty(tester);
        assertEquals(50,tester.getRent());
        testy.addProperty(tester);
        assertEquals(100,tester.getRent());
        testy.addProperty(tester);
        assertEquals(200,tester.getRent());
    }

}