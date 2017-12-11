import java.util.Random;
import javafx.scene.control.Button;
public class Dice {

    private Random randNum;
    public Button rollDiceButton;
    public Dice() {
        this.randNum = new Random();
    }

    //rolls 2 times and returns the sum
    public int[] rollDice(int numDubs) {
    	int[] dice = new int[2];
        int d1 = (this.randNum.nextInt(6) + 1);
        int d2 = (this.randNum.nextInt(6) + 1);
        //jail check
        if(numDubs == 2 && d1 == d2) { //third double roll, go to jail

            dice[0] = -1;
            dice[1] = 0;
        }
        String sum = d1+" + "+d2;
        //rollDiceButton.setText(sum);
        dice[0] = d1;
        dice[1] = d2;
        return dice;

    }

    //rolls 2 dice and returns false if they are doubles,
    //player.setInJail(Dice.rollJailDice()) -- use to roll in jail
    public boolean rollJailDice() {
        return (this.randNum.nextInt(6) + 1) != (this.randNum.nextInt(6) + 1);
    }
}
