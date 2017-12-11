import java.util.ArrayList;

public class MonopolyModel {

    private Player currentTurn;
    public ArrayList<Player> allPlayers;
    public final int numPlayers;
    public Property[] board = new Property[40];

    //instantiates every piece of the board with its corresponding rent list
    private int[] brn1 = {2, 10, 30, 90, 160, 250};
    private int[] brn2 = {4, 20, 60, 180, 320, 450};
    private int[] ltblu1 = {6, 30, 90, 270, 400, 550};
    private int[] ltblu2 = {6, 30, 90, 270, 400, 550};
    private int[] ltblu3 = {8, 40, 100, 300, 450, 600};
    private int[] pnk1 = {10, 50, 150, 450, 625, 750};
    private int[] pnk2 = {10, 50, 150, 450, 625, 750};
    private int[] pnk3 = {12, 60, 180, 500, 700, 900};
    private int[] ong1 = {14, 70, 200, 550, 750, 950};
    private int[] ong2 = {14, 70, 200, 550, 750, 950};
    private int[] ong3 = {16, 80, 220, 600, 800, 1000};
    private int[] red1 = {18, 90, 250, 700, 875, 1050};
    private int[] red2 = {18, 90, 250, 700, 875, 1050};
    private int[] red3 = {20, 100, 300, 750, 925, 1100};
    private int[] yel1 = {22, 110, 330, 800, 975, 1150};
    private int[] yel2 = {22, 110, 330, 800, 975, 1150};
    private int[] yel3 = {24, 120, 360, 850, 1025, 1200};
    private int[] grn1 = {26, 130, 390, 900, 1100, 1275};
    private int[] grn2 = {26, 130, 390, 900, 1100, 1275};
    private int[] grn3 = {28, 150, 450, 1000, 1200, 1400};
    private int[] dkblu1 = {35, 175, 500, 1100, 1300, 1500};
    private int[] dkblu2 = {50, 200, 600, 1400, 1700, 2000};
    private Dice dice;

    //contains the coordinate locations of every piece so that pieces are able to move around
    // the board and have a corresponding image represent the players location
    private int[] coord0 = {536,624};
    private int[] coord1 = {518,624};
    private int[] coord2 = {467,624};
    private int[] coord3 = {420,624};
    private int[] coord4 = {369,624};
    private int[] coord5 = {323,624};
    private int[] coord6 = {273,624};
    private int[] coord7 = {224,624};
    private int[] coord8 = {176,624};
    private int[] coord9 = {128,624};
    private int[] coord10 = {38,634};
    private int[] coord11 = {49,547};
    private int[] coord12 = {49,501};
    private int[] coord13 = {49,452};
    private int[] coord14 = {49,404};
    private int[] coord15 = {49,355};
    private int[] coord16 = {49,306};
    private int[] coord17 = {49,255};
    private int[] coord18 = {49,207};
    private int[] coord19 = {49,158};
    private int[] coord20 = {49,82};
    private int[] coord21 = {128,82};
    private int[] coord22 = {176,82};
    private int[] coord23 = {224,82};
    private int[] coord24 = {273,82};
    private int[] coord25 = {323,82};
    private int[] coord26 = {369,82};
    private int[] coord27 = {420,82};
    private int[] coord28 = {467,82};
    private int[] coord29 = {518,82};
    private int[] coord30 = {597,82};
    private int[] coord31 = {597,158};
    private int[] coord32 = {597,207};
    private int[] coord33 = {597,255};
    private int[] coord34 = {597,306};
    private int[] coord35 = {597,355};
    private int[] coord36 = {597,404};
    private int[] coord37 = {597,452};
    private int[] coord38 = {597,501};
    private int[] coord39 = {597,547};

    // constructor creates everything necessary for the game
    public MonopolyModel(int numPlayers)
    {
        this.numPlayers = numPlayers;
        allPlayers = new ArrayList<Player>();

        // create all players
        for(int i = 0; i < numPlayers; i++)
        {
            String name = String.valueOf(i + 1);
            Player p = new Player("Player" + name );
            allPlayers.add(p);
        }
        this.dice = new Dice();
        this.currentTurn = allPlayers.get(0);

        //attaches a property and its rent value to each space on the board
        board[0] = new SpecialSpace("empty", coord0); 						//GO
        board[1] = new BasicProp(brn1, "brown", 60,1, coord1);
        board[2] = new SpecialSpace("iChest", coord2);
        board[3] = new BasicProp(brn2, "brown", 60,3, coord3);
        board[4] = new SpecialSpace("oTax", coord4);
        board[5] = new Railroad(5, coord5);
        board[6] = new BasicProp(ltblu1, "ltblue", 100,6, coord6);
        board[7] = new SpecialSpace("mystery", coord7);                     //MEAT DUNGEON
        board[8] = new BasicProp(ltblu2, "ltblue", 100,8, coord8);
        board[9] = new BasicProp(ltblu3, "ltblue", 120,9, coord9);
        board[10] = new SpecialSpace("jail", coord10);                     //MEAT DUNGEON
        board[11] = new BasicProp(pnk1, "pink", 140,11, coord11);
        board[12] = new Utility(12, coord12);
        board[13] = new BasicProp(pnk2, "pink", 140,13, coord13);
        board[14] = new BasicProp(pnk3, "pink", 160,14, coord14);
        board[15] = new Railroad(15,coord15);
        board[16] = new BasicProp(ong1, "orange", 180,16, coord16);
        board[17] = new SpecialSpace("iChest", coord17);
        board[18] = new BasicProp(ong2, "orange", 180,18, coord18);
        board[19] = new BasicProp(ong3, "orange", 200,19, coord19);
        board[20] = new SpecialSpace("empty", coord20);						//FREE SAUSAGE
        board[21] = new BasicProp(red1, "red", 220,21, coord21);
        board[22] = new SpecialSpace("mystery", coord22);
        board[23] = new BasicProp(red2, "red", 220,23, coord23);
        board[24] = new BasicProp(red3, "red", 240,24, coord24);
        board[25] = new Railroad(25,coord25);
        board[26] = new BasicProp(yel1, "yellow", 260,26, coord26);
        board[27] = new BasicProp(yel2, "yellow", 260,27, coord27);
        board[28] = new Utility(28,coord28);
        board[29] = new BasicProp(yel3, "yellow", 280,29, coord29);
        board[30] = new SpecialSpace("go2Jail", coord30);					//HEALTH INSPECTOR
        board[31] = new BasicProp(grn1, "green", 300,31, coord31);
        board[32] = new BasicProp(grn2, "green", 300,32, coord32);
        board[33] = new SpecialSpace("iChest", coord33);
        board[34] = new BasicProp(grn3, "green", 320,34, coord34);
        board[35] = new Railroad(35,coord35);
        board[36] = new SpecialSpace("mystery", coord36);
        board[37] = new BasicProp(dkblu1, "dkblue", 350,37, coord37);
        board[38] = new SpecialSpace("mTax", coord38);
        board[39] = new BasicProp(dkblu2, "dkblue", 400,39, coord39);
    }
    //get method for the dice
    public Dice getDice()
    {
        return this.dice;
    }

    //get method for whose currently taking a turn
    public Player getCurrentTurn() {
        return this.currentTurn;
    }

    //iterates through each player and cycles turns.
    public void iterCurrentTurn()
    {
        this.currentTurn = this.allPlayers.get((this.allPlayers.indexOf(this.currentTurn) + 1) % 4);
    }

    //method to calculate the winner of the game when the time ends by seeing who has the highest
    //net worth
    public Player calculateWinner() {
        double totalWorth = 0;
        Player winner = new Player("");
        for (int i = 0; i < allPlayers.size(); i++) {
            if (allPlayers.get(i).getTotalWorth() >= totalWorth) {
                totalWorth = allPlayers.get(i).getTotalWorth();
                winner = allPlayers.get(i);
            }
        }
        return winner;
    }

}
