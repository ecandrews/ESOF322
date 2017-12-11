import org.junit.Test;
import org.junit.Rule;

import static org.junit.Assert.*;

public class LabelUpdaterTest {
    //@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    @Test
    public void update() throws Exception {
        Player p1 = new Player("Frank");
        Player p2 = new Player("Norman");
        Player p3 = new Player("Butch");
        Player p4 = new Player("Henry");
        LabelUpdater test = new LabelUpdater(p1,p2,p3,p4);
        test.update();
        assertEquals("1500",test.p1money.getValue());
    }

}