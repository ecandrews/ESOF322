import org.junit.Test;

import static org.junit.Assert.*;

public class MonopolyModelTest {
    @Test
    public void calculateWinner() throws Exception {

        MonopolyModel test = new MonopolyModel(4);

        test.allPlayers.get(1).setCashOnHand(1000000);

        assertEquals("Player2",test.calculateWinner().getName());
    }

}