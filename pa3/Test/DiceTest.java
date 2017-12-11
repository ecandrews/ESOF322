import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {
	//due to the random nature of Dice tests must be run many times to
	//ensure, with a high probability that the test cases will actually happen
	
	Dice testDice = new Dice();
	
	//makes sure random values are being returned 
	//that are within the range of 1 and 6
	@Test
	public void properValuesTest() {
		
		int[] result = new int[2];
		
		for(int testIter = 0; testIter < 100; testIter++) {
			result = this.testDice.rollDice(0);
			assertTrue(result[0] <= 6 && result[1] <= 6);
			assertTrue(result[0] >= 1 && result[1] >= 1);
		}
	}
	
	//makes sure jail flag is being returned 
	//when doubles happen for the third time
	@Test
	public void goToJailTest() {
		
		int[] result = new int[2];
		boolean jailFlagFound = false;
		for(int testIter = 0; testIter < 100; testIter++) {
			result = this.testDice.rollDice(2);
			if(result[0] == -1) {
				jailFlagFound = true;
				break;
			}
		}
		if(!jailFlagFound) {
			fail("after 100 runs a rollDice did not return the proper jail flag");
		}
	}

}
