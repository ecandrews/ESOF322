import org.junit.Test;

import static org.junit.Assert.*;

public class ClassicGameTest {
    @Test
    public void getTitle() throws Exception {
        ClassicGame test = new ClassicGame();
        assertEquals("Classic", test.getTitle());
    }

}