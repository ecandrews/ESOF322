import org.junit.Test;

import static org.junit.Assert.*;

public class MeatGameTest {
    @Test
    public void getTitle() throws Exception {
        MeatGame test = new MeatGame();
        assertEquals("Meatopoly", test.getTitle());
    }

}