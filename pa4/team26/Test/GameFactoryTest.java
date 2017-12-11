import org.junit.Test;

import static org.junit.Assert.*;

public class GameFactoryTest {

	@Test
	public void classicGameTest(){
		ClassicGame testGame = new ClassicGame();
		assertEquals(testGame.getTitle(), "Classic");
	}

	@Test
	public void meatGameTest(){

		MeatGame testGame = new MeatGame();
		assertEquals(testGame.getTitle(), "Meatopoly");
	}

}
