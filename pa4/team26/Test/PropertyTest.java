import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyTest {

    Property tester = new Property();
    Player player1 = new Player("Roger");
    @Test
    public void getOwner() throws Exception {
        assertEquals(null,tester.getOwner());
    }

    @Test
    public void setOwner() throws Exception {
        tester.setOwner(player1);
        assertEquals(player1,tester.getOwner());
    }

    @Test
    public void getValue() throws Exception {
        int[] testInt = {0};
        Railroad testy = new Railroad(4,testInt);

        assertEquals(200,testy.getValue());
    }

    @Test
    public void setValue() throws Exception {
        tester.setValue(10000);
        assertEquals(10000, tester.getValue());
    }

    @Test
    public void isMortgaged() throws Exception {
        assertFalse(tester.isMortgaged());
    }

    @Test
    public void setMortgaged() throws Exception {
        tester.setMortgaged(true);
        assertTrue(tester.isMortgaged());
    }

    @Test
    public void getColor() throws Exception {
        int[] var = {1};
        BasicProp testy = new BasicProp(var,"Puce", 2,4, var);

        assertEquals("Puce", testy.getColor());
    }

    @Test
    public void isMortgageable() throws Exception {
        assertTrue(tester.isMortgageable());
    }

    @Test
    public void setMortgageable() throws Exception {
        tester.setMortgageable(false);
        assertFalse(tester.isMortgageable());
    }

}