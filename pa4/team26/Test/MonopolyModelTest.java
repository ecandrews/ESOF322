import org.junit.Test;

import java.net.URL;
import java.util.Random;

import static org.junit.Assert.*;

public class MonopolyModelTest {

    @Test
    public void calculateWinner() throws Exception {

        MonopolyModel test = new MonopolyModel(4);
        test.allPlayers.get(1).setCashOnHand(1000000);
        assertEquals("Player2",test.calculateWinner().getName());
    }

    @Test
    public void constructorTest() throws Exception {
        MonopolyModel testModel = new MonopolyModel(4);
        assertEquals(testModel.numPlayers, 4);
        assertEquals(testModel.board.getClass(), Property[].class );
        assertEquals(testModel.allPlayers.get(0).getClass() , Player.class);
        assertEquals(testModel.getDice().getClass() ,Dice.class );
    }

    @Test
    public void getCurrentTurnTest() throws Exception {
        MonopolyModel testModel = new MonopolyModel(4);
        assertEquals(testModel.getCurrentTurn(), testModel.allPlayers.get(0));
    }

    @Test
    public void iterCurrentTurnTest() throws Exception {
        MonopolyModel testModel = new MonopolyModel(4);
        testModel.iterCurrentTurn();
        assertEquals(testModel.getCurrentTurn(), testModel.allPlayers.get(1));
    }

    @Test
    public void BoardTest() throws Exception {
        MonopolyModel testModel = new MonopolyModel(4);
        assertEquals(testModel.board[0].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[1].getClass(), BasicProp.class);
        assertEquals(testModel.board[2].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[3].getClass(), BasicProp.class);
        assertEquals(testModel.board[4].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[5].getClass(), Railroad.class);
        assertEquals(testModel.board[6].getClass(), BasicProp.class);
        assertEquals(testModel.board[7].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[8].getClass(), BasicProp.class);
        assertEquals(testModel.board[9].getClass(), BasicProp.class);
        assertEquals(testModel.board[10].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[11].getClass(), BasicProp.class);
        assertEquals(testModel.board[12].getClass(), Utility.class);
        assertEquals(testModel.board[13].getClass(), BasicProp.class);
        assertEquals(testModel.board[14].getClass(), BasicProp.class);
        assertEquals(testModel.board[15].getClass(), Railroad.class);
        assertEquals(testModel.board[16].getClass(), BasicProp.class);
        assertEquals(testModel.board[17].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[18].getClass(), BasicProp.class);
        assertEquals(testModel.board[19].getClass(), BasicProp.class);
        assertEquals(testModel.board[20].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[21].getClass(), BasicProp.class);
        assertEquals(testModel.board[22].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[23].getClass(), BasicProp.class);
        assertEquals(testModel.board[24].getClass(), BasicProp.class);
        assertEquals(testModel.board[25].getClass(), Railroad.class);
        assertEquals(testModel.board[26].getClass(), BasicProp.class);
        assertEquals(testModel.board[27].getClass(), BasicProp.class);
        assertEquals(testModel.board[28].getClass(), Utility.class);
        assertEquals(testModel.board[29].getClass(), BasicProp.class);
        assertEquals(testModel.board[30].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[31].getClass(), BasicProp.class);
        assertEquals(testModel.board[32].getClass(), BasicProp.class);
        assertEquals(testModel.board[33].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[34].getClass(), BasicProp.class);
        assertEquals(testModel.board[35].getClass(), Railroad.class);
        assertEquals(testModel.board[36].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[37].getClass(), BasicProp.class);
        assertEquals(testModel.board[38].getClass(), SpecialSpace.class);
        assertEquals(testModel.board[39].getClass(), BasicProp.class);
    }
}