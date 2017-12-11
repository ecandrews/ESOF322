import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.junit.Assert.*;

public class ChestPopupTest {
    @Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
    @Test
    public void display() throws Exception {
        ChestPopup test = new ChestPopup();
        int[] check={};
        assertEquals(check.getClass(), test.display().getClass());
    }

}