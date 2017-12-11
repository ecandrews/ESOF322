
import java.net.URL;
import java.util.*;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.concurrent.Service;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class MonopolyController implements Initializable{

    @FXML
    // All Javafx labels that display money, properties, the current positsion and whether the player is in jail on the left
    // side of the gui.
    private Label player1_money;
    public Label player2_money;
    public Label player3_money ;
    public Label player4_money;

    public Label player1_properties;
    public Label player2_properties;
    public Label player3_properties;
    public Label player4_properties ;

    public Label player1_currentPos ;
    public Label player2_currentPos ;
    public Label player3_currentPos ;
    public Label player4_currentPos ;

    public Label player1_inJail ;
    public Label player2_inJail ;
    public Label player3_inJail ;
    public Label player4_inJail ;

    public Button rollbtn;
    public Button buyPropbtn;
    public Button payBailbtn;
    public Button manPropsbtn;
    public Button iceChestbtn;

    public ImageView p1token;
    public ImageView p2token;
    public ImageView p3token;
    public ImageView p4token;
    //imageviews for javafx to show picture for houses and hotels
    @FXML
    public ImageView house1=new ImageView();
    public ImageView house3=new ImageView();
    public ImageView house6=new ImageView();
    public ImageView house8=new ImageView();
    public ImageView house9=new ImageView();
    public ImageView house11=new ImageView();
    public ImageView house13=new ImageView();
    public ImageView house14=new ImageView();
    public ImageView house16=new ImageView();
    public ImageView house18=new ImageView();
    public ImageView house19=new ImageView();
    public ImageView house21=new ImageView();
    public ImageView house23=new ImageView();
    public ImageView house24=new ImageView();
    public ImageView house26=new ImageView();
    public ImageView house27=new ImageView();
    public ImageView house29=new ImageView();
    public ImageView house31=new ImageView();
    public ImageView house32=new ImageView();
    public ImageView house34=new ImageView();
    public ImageView house37=new ImageView();
    public ImageView house39=new ImageView();
    //images for houses and hotels
    public Image housePic1 = new Image("/images/house1.jpg");
    public Image housePic2 = new Image("/images/house2.jpg");
    public Image housePic3 = new Image("/images/house3.jpg");
    public Image housePic4 = new Image("/images/house4.jpg");
    public Image hotel = new Image("/images/hotel.jpg");

    //array to store all the imageview statuses to display them or not
    @FXML
    public ImageView[] houseList = {null,house1,null,house3,null,null,house6,null,house8,house9,null,house11,null,house13,house14,null,house16,null,house18,
            house19,null,house21,null, house23,house24,null,house26,house27,null,house29,null,house31,house32,null,house34,null,null,null,house37,null,house39};

    //Variable to track how many turns have been taken
    public int turn=0;
    //Variable to track how many snakeeyes have been rolled
    public int numDubs;
    // Local instance of Monopolymodel class which contains the actual pieces of the board etc.
    private MonopolyModel model;

    //booleans to track whether a player's turn is over, and whetber they have rolled the dice and may end their turn
    public volatile Boolean turnOver;
    public volatile Boolean turnEndable;
    //tracks whose turn it currently is
    private Player nowPlayer;
    //tracks whether the player has rolled or not
    private volatile boolean hasRolled;
    // variable of a seperate thread that actually runs the game in the background in a seperate thread and communicates
    // changes to the gui which is in the main thread
    private Service<Void> controlThread;
    LabelUpdater updateLabel;

    // Constructor which instantiates a board with 4 players
    public MonopolyController(){

        this.model = new MonopolyModel(4);

    }

    //This method is called and the starts the controller class in a seperate thread. all game processes happen here
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        controlThread = new Service<Void>(){

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {

                        startGame();


                        return null;
                    }
                };
            }
        };
        //accesses a method that fetches updated player data and feeds it back to this thread so that it can update the GUI
        this.updateLabel = new LabelUpdater(model.allPlayers.get(0), model.allPlayers.get(1), model.allPlayers.get(2), model.allPlayers.get(3));

        //javafx bindings that update the labels on the left pane of the gui showing updated values on every turn
        player1_money.textProperty().bind(updateLabel.p1money);
        player1_properties.textProperty().bind(updateLabel.p1properties);
        player1_currentPos.textProperty().bind(updateLabel.p1position);
        player1_inJail.textProperty().bind(updateLabel.p1inJail);

        player2_money.textProperty().bind(updateLabel.p2money);
        player2_properties.textProperty().bind(updateLabel.p2properties);
        player2_currentPos.textProperty().bind(updateLabel.p2position);
        player2_inJail.textProperty().bind(updateLabel.p2inJail);

        player3_money.textProperty().bind(updateLabel.p3money);
        player3_properties.textProperty().bind(updateLabel.p3properties);
        player3_currentPos.textProperty().bind(updateLabel.p3position);
        player3_inJail.textProperty().bind(updateLabel.p3inJail);

        player4_money.textProperty().bind(updateLabel.p4money);
        player4_properties.textProperty().bind(updateLabel.p4properties);
        player4_currentPos.textProperty().bind(updateLabel.p4position);
        player4_inJail.textProperty().bind(updateLabel.p4inJail);
        //starts controller thread
        controlThread.restart();

    }
    // Method  to start a game, sets the timer which determines when a game ends
    // (at expiration of the timer) also cycles through each player in the arraylist
    // containing them and controls when turns are taken
    public void startGame(){
        Date timer = new Date();
        long startTime = timer.getTime();
        this.numDubs = 0;

        while (startTime >= (timer.getTime() - 2000000)){

            for(Player player : model.allPlayers){
                this.nowPlayer = player;
                takeTurn(player);
                turn = (turn+1)%model.allPlayers.size();

            }

        }
    }


    // method to handle a turn being taken, sets all checking conditions to false initially na dbased on the actions of the
    // player these are set to true at the end of the method
    public void takeTurn(Player player)
    {
        iceChestbtn.setDisable(true);
        this.turnOver = false;
        this.turnEndable = false;
        this.hasRolled = false;
        while(!this.turnOver){
            this.turnEndable = true;

        }

        this.turnEndable = false;
        model.iterCurrentTurn();

    }

    //method to handle the end a player's turn, calls the update label method from above from the
    // LabeUpdater class and displays all information changed during the turn
    @FXML
    public void endTurn(){
        //TODO
        this.numDubs = 0;
        if (this.turnEndable && this.hasRolled){
            System.out.println("END " + this.model.getCurrentTurn().getName() + " TURN");
            if(!this.model.board[this.nowPlayer.getLocationOnBoard()].isOwned() && !this.model.board[this.nowPlayer.getLocationOnBoard()].getClass().equals(SpecialSpace.class)){
                //given the player ended his turn, if his space is ownable and unowned start the auction for that space
            }

            this.updateLabel.update();
            this.turnOver = true;
        }
        else if(!hasRolled){
            System.out.println("You must roll before you end your turn");
        }
        rollbtn.setDisable(false);
        rollbtn.setText("Roll");
    }



    //method to actually move a player to a location, also handles conditions if they are in jail
    @FXML
    public void movePlayer() {
        // set the player's new location
        // if player lands on a property, call the appropriate method

        this.hasRolled = true;

        if(nowPlayer.getInJail() == true && nowPlayer.getHasGetOutOfJailFree())
        {
            this.nowPlayer.setInJail(false);
            this.updateLabel.update();
        }
        if(nowPlayer.getInJail()){
            this.payBailbtn.setDisable(true);
            //TODO
            //ask if player wants to pay bail
            payBailbtn.setDisable(false);
            manPropsbtn.setDisable(true);
            buyPropbtn.setDisable(true);

            //if they hit end turn then:
            System.out.println(nowPlayer.getName() + " is in JAIL");
            nowPlayer.setInJail((model.getDice()).rollJailDice());
            if (nowPlayer.getInJail() == false){
                payBailbtn.setDisable(true);
                manPropsbtn.setDisable(false);
                buyPropbtn.setDisable(false);
                this.rollbtn.setDisable(true);
                System.out.println("doubles -- OUT OF JAIL");
            }
            this.rollbtn.setDisable(true);
        }
        else{
            if(this.numDubs == 3){
                nowPlayer.setInJail(true);
                this.rollbtn.setDisable(true);
            }
            else{
                int[] move = model.getDice().rollDice(numDubs);
                int roll = move[0] + move[1];
                System.out.println(nowPlayer.getName() + " moved " + roll + " spaces");
                //int newLoc = (roll + nowPlayer.getLocationOnBoard()) % 40;
                int newLoc = 33;


                if(nowPlayer.getLocationOnBoard() > newLoc){
                    playerPassedGo(nowPlayer);
                }

                nowPlayer.setLocationOnBoard(newLoc);
                if(this.nowPlayer.isCommunityChest()){
                    iceChestbtn.setDisable(false);
                }
                moveToken(turn, newLoc);
                int rent = model.board[newLoc].landedOn(nowPlayer, roll);

                if(rent>0){
                    payRentFromPlayerToPlayer(nowPlayer,model.board[newLoc].getOwner(),rent);
                }
                if (move[1] != move[0]){
                    this.rollbtn.setDisable(true);
                }
                else{
                    System.out.println("_-_-_-_-_-_DOUBLES_-_-_-_-_-_");
                    numDubs++;
                    this.hasRolled = false;
                }
            }
        }
        this.updateLabel.update();
    }

    public void mortgageProperty(Property prop)
    {
        //must check that there are no buidings on property before mortgage
        if (prop.isMortgageable() && !prop.isMortgaged()){
            nowPlayer.setCashOnHand(prop.getValue() * .5);
            prop.setMortgaged(true);
            updateLabel.update();
        }
        else{
            System.out.println("Already mortgaged or there are houses on the property");
        }
    }


    //method to sell a house or hotel
    public void sellDevelopment(BasicProp prop)
    {
        int numPropsGoodDevNumb = 0;
        ArrayList<Integer> numBuildings = new ArrayList<>();

        if (prop.getColor().equals("dkblue") || prop.getColor().equals("brown")){
            numPropsGoodDevNumb++;
        }

        //checks if all properties in the monopoly have equal to or greater than the number of buildings that prop has
        if (checkMonopoly(nowPlayer, prop)){
            for (BasicProp playerProp : nowPlayer.getBPropsOwned()){
                if (playerProp.getColor() == prop.getColor()){

                    if (!playerProp.isMortgaged()){
                        numPropsGoodDevNumb++;

                        numBuildings.add(playerProp.getBuildings());
                    }
                }
            }
        }

        //difference between the maximum number of buildings in the group must be no greater than one
        //The new number of buildings on prop will always be the max or equal to the max
        Boolean rangeCheck = (((prop.getBuildings() - 1) - Collections.min(numBuildings)) <= 1);

        if (numPropsGoodDevNumb == 3 && rangeCheck){
            prop.removeBuilding();
            nowPlayer.setCashOnHand((prop.getBuildingCost() / 2));
        }

        updateLabel.update();
    }

    //method that allows player ot buya  house or hotel if they have a monopoly
    public void buyDevelopment(BasicProp prop)
    {
        int numPropsGoodDevNumb = 0;
        ArrayList<Integer> numBuildings = new ArrayList<>();

        if (prop.getColor().equals("dkblue") || prop.getColor().equals("brown")){
            numPropsGoodDevNumb++;

        }

        //checks if all properties in the monopoly have equal to or greater than the number of buildings that prop has
        if (checkMonopoly(nowPlayer, prop)){
            for (BasicProp playerProp : nowPlayer.getBPropsOwned()){
                if (playerProp.getColor() == prop.getColor()){

                    if (!playerProp.isMortgaged()){
                        numPropsGoodDevNumb++;
                        numBuildings.add(playerProp.getBuildings());
                    }
                }
            }

        }

        //difference between the maximum number of buildings in the group must be no greater than one
        //The new number of buildings on prop will always be the max or equal to the max
        Boolean rangeCheck = (((prop.getBuildings() + 1) - Collections.min(numBuildings)) <= 1);

        if (numPropsGoodDevNumb == 3 && rangeCheck){
            prop.addBuilding();
            nowPlayer.setCashOnHand(-prop.getBuildingCost());
        }

        updateLabel.update();
    }

    public void unmortgageProperty(Property prop)
    {
        int price = (int)((-1)*prop.getValue()/2*1.1);
        nowPlayer.setCashOnHand(price);
        prop.setMortgageable(true);
        updateLabel.update();
    }

    // method that handles when a player lands on another player's owned property and needs ot pay them rent
    public void payRentFromPlayerToPlayer(Player a, Player b, int rentAmt)
    {
        a.setCashOnHand(-1 * rentAmt);
        b.setCashOnHand(rentAmt);
    }

    //method that grants 500 dollars to a player for passing go
    public void playerPassedGo(Player p)
    {
        p.setCashOnHand(200);
    }

    //get method for player within this model of the game
    public Player getPlayer(String name)
    {
        for (int i = 0; i < model.allPlayers.size(); i++)
        {
            if((model.allPlayers.get(i).getName().equals(name)))
            {
                return model.allPlayers.get(i);
            }
        }
        return null;
    }


    //method to check whether a player has a monopoly and meets the validity conditions to start developing their property
    public boolean checkMonopoly(Player p, BasicProp prop){
        boolean hasMonop = false;
        int numProps = 0;
        if (prop.getColor().equals("dkblue") || prop.getColor().equals("brown")){
            numProps ++;
        }
            for (Property playerProp : p.getPropertiesOwned()){
                if (playerProp.getColor() == prop.getColor()){
                    numProps++;
                }
            }
        if (numProps == 3){
            hasMonop = true;
        }
        return hasMonop;
    }

    //handles moving the images of each players icon across the board in the GUI
    public void moveToken(int currentTurn, int pos){
        if(currentTurn==0){
            p1token.setLayoutX(model.board[pos].getCoord()[0]);
            p1token.setLayoutY(model.board[pos].getCoord()[1]);
        }
        if(currentTurn==1){
            p2token.setLayoutX(model.board[pos].getCoord()[0]);
            p2token.setLayoutY(model.board[pos].getCoord()[1]);
        }
        if(currentTurn==2){
            p3token.setLayoutX(model.board[pos].getCoord()[0]);
            p3token.setLayoutY(model.board[pos].getCoord()[1]);
        }
        if(currentTurn==3){
            p4token.setLayoutX(model.board[pos].getCoord()[0]);
            p4token.setLayoutY(model.board[pos].getCoord()[1]);
        }
    }


    //allows a player to purchase a property if they ahve enough money and it isnt already owned
    @FXML
    public void buyProperty() {
        Property prop = this.model.board[nowPlayer.getLocationOnBoard()];

        if(!prop.getClass().equals(SpecialSpace.class) && (!prop.isOwned() && !nowPlayer.ownsProp(prop))){
            this.nowPlayer.addProperty(this.model.board[nowPlayer.getLocationOnBoard()]);
            int cost = -this.model.board[nowPlayer.getLocationOnBoard()].getValue();
            this.nowPlayer.setCashOnHand( cost);
            System.out.println(this.nowPlayer.getName() + " bought space " + nowPlayer.getLocationOnBoard() + " for $" + this.model.board[nowPlayer.getLocationOnBoard()].getValue());
            prop.setOwner(this.nowPlayer);
            prop.setOwned(true);
        }
        else if(prop.getClass().equals(SpecialSpace.class)){
            System.out.println("You cannot buy this space");
        }
        else{
            System.out.println("This property is owned");
        }
        this.updateLabel.update();
    }

    @FXML
    //method to handle when a player is in jail and decides to pay their way out rather then try and roll
    public void payBail() {
        if(nowPlayer.getInJail()){

            this.rollbtn.setDisable(true);
            this.nowPlayer.setCashOnHand(-50);
            System.out.println(this.nowPlayer.getName() + " paid Bail" );
            this.nowPlayer.setInJail(false);
            this.updateLabel.update();
        }

        else{
            System.out.println(nowPlayer.getName() + " is not in jail");
        }
    }

    @FXML
    public void manageProps() {
        //open popup with properties
        //3 buttons per property
        //+ ~ adds a development
        //- ~ sells a development
        //M ~ mortgages the property
        manPropsbtn.setOnAction(e -> {
            int[] result = ownedPropBox.display("Select a Property", nowPlayer);
            // 1 = develop
            if (result[0] == 1){
                System.out.println("buyDev");
                buyDevelopment((BasicProp)model.board[result[1]]);
                updateHousePic(model.board[result[1]]);
                //

            }
            // 2 = sell
            else if (result[0] == 2){
                System.out.println("sellDev");
                sellDevelopment((BasicProp)model.board[result[1]]);
                updateHousePic(model.board[result[1]]);

            }
            //3 = mortgage
            else if (result[0] == 3){
                mortgageProperty( model.board[result[1]]);

            }
            //4 do nothing
            else if (result[0] == 4){

            }
            //3 = mortgage
            else if (result[0] == 5){
                unmortgageProperty( model.board[result[1]]);

            }
        });


    }
    Random randNumUtil;
    public void iceChest()
    {
//
        iceChestbtn.setOnAction(e -> {
            int[] result = ChestPopup.display();
            // 1 = Card 1 Advance to Go
            if (result[0] == 1){
                this.nowPlayer.setLocationOnBoard(0);
                iceChestbtn.setDisable(true);
            }
            // 2 = Card 2 Advance to Porkbelly Plaza - If you pass Go, collect $200
            else if (result[0] == 2){
                int newLoc = 11;
                int[] move = model.getDice().rollDice(numDubs);
                int roll = move[0] + move[1];
                if(nowPlayer.getLocationOnBoard() > newLoc){
                    playerPassedGo(nowPlayer);
                }

                nowPlayer.setLocationOnBoard(newLoc);
                if(this.nowPlayer.isCommunityChest()){
                    iceChestbtn.setDisable(false);
                }
                moveToken(turn, newLoc);
                int rent = model.board[newLoc].landedOn(nowPlayer, roll);
                if(rent>0){
                    payRentFromPlayerToPlayer(nowPlayer,model.board[newLoc].getOwner(),rent);
                }
                iceChestbtn.setDisable(true);
            }
            //3 = Card 3 Advance to Salami Sidewalk – If you pass Go, collect $200
            else if (result[0] == 3){
                int newLoc = 18;
                int[] move = model.getDice().rollDice(numDubs);
                int roll = move[0] + move[1];
                if(nowPlayer.getLocationOnBoard() > newLoc){
                    playerPassedGo(nowPlayer);
                }

                nowPlayer.setLocationOnBoard(newLoc);
                if(this.nowPlayer.isCommunityChest()){
                    iceChestbtn.setDisable(false);
                }
                moveToken(turn, newLoc);
                int rent = model.board[newLoc].landedOn(nowPlayer, roll);
                if(rent>0){
                    payRentFromPlayerToPlayer(nowPlayer,model.board[newLoc].getOwner(),rent);
                }
                iceChestbtn.setDisable(true);
            }
            //4 Card 4 Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice
            // and pay owner a total ten times the amount thrown.
            else if (result[0] == 4){
                int ClosestUtil = 0;

                if(nowPlayer.getLocationOnBoard()== 2 || nowPlayer.getLocationOnBoard() == 33 )
                {
                    ClosestUtil = 12;
                }
                else if(nowPlayer.getLocationOnBoard()== 17)
                {
                    ClosestUtil = 28;
                }
                int newLoc = ClosestUtil;
                int[] move = model.getDice().rollDice(numDubs);
                int roll = move[0] + move[1];
                if(nowPlayer.getLocationOnBoard() > newLoc){
                    playerPassedGo(nowPlayer);
                }

                nowPlayer.setLocationOnBoard(newLoc);
                if(this.nowPlayer.isCommunityChest()){
                    iceChestbtn.setDisable(false);
                }
                moveToken(turn, newLoc);
                int rent = model.board[newLoc].landedOn(nowPlayer, roll);

                if(rent>0){

                    int d1 = (this.randNumUtil.nextInt(6) + 1);
                    int d2 = (this.randNumUtil.nextInt(6) + 1);
                    int sum = d1+d2;
                    nowPlayer.utilityPayment(sum);
                    model.board[newLoc].getOwner().utilityReward(sum);
                }


                iceChestbtn.setDisable(true);
            }
            //5 = Card 5 Advance token to the nearest Railroad and pay owner twice the rental to which they are
            // otherwise entitled. If Railroad is unowned, you may buy it from the Bank.
            else if (result[0] == 5){
                int ClosestRail = 0;

                if(nowPlayer.getLocationOnBoard()== 2)
                {
                    ClosestRail = 5;
                }
                else if(nowPlayer.getLocationOnBoard()== 17)
                {
                    ClosestRail = 25;
                }
                else if(nowPlayer.getLocationOnBoard() == 33)
                {
                    ClosestRail = 35;
                }
                int newLoc = ClosestRail;
                int[] move = model.getDice().rollDice(numDubs);
                int roll = move[0] + move[1];
                if(nowPlayer.getLocationOnBoard() > newLoc){
                    playerPassedGo(nowPlayer);
                }

                nowPlayer.setLocationOnBoard(newLoc);
                if(this.nowPlayer.isCommunityChest()){
                    iceChestbtn.setDisable(false);
                }
                moveToken(turn, newLoc);
                int rent = model.board[newLoc].landedOn(nowPlayer, roll);
                if(rent>0){
                    payRentFromPlayerToPlayer(nowPlayer,model.board[newLoc].getOwner(),rent);
                    payRentFromPlayerToPlayer(nowPlayer,model.board[newLoc].getOwner(),rent);
                }
                iceChestbtn.setDisable(true);
            }
            //6 = Card 6 Bank pays you dividend of $50
            else if (result[0] == 6){
                nowPlayer.bankDividend();
                iceChestbtn.setDisable(true);

            }
            //7 = Card 7 Get out of Jail Free – This card may be kept until needed, or traded/sold
            else if (result[0] == 7){
                nowPlayer.setGetOutOfJailFree(true);
                iceChestbtn.setDisable(true);

            }
            //8 = Card 8 Go Back 3 Spaces
            else if (result[0] == 8){
                nowPlayer.setLocationOnBoard(nowPlayer.getLocationOnBoard()-3);
                iceChestbtn.setDisable(true);

            }
            //9 = Card 9 Go to Jail – Go directly to Jail – Do not pass Go, do not collect $200
            else if (result[0] == 9){
                nowPlayer.setInJail(true);
                this.updateLabel.update();
                iceChestbtn.setDisable(true);

            }
            //10 = Card 10 Make general repairs on all your property – For each house pay $25 – For each hotel $100
            else if (result[0] == 10){

            }
            //11 = Card 11 Pay poor tax of $15
            else if (result[0] == 11){
                nowPlayer.poorTax();
                iceChestbtn.setDisable(true);

            }
            //12 = Card 12 Take a trip to Breast Steet - If you pass Go, collect $200
            else if (result[0] == 12){
                int newLoc = 34;
                int[] move = model.getDice().rollDice(numDubs);
                int roll = move[0] + move[1];
                if(nowPlayer.getLocationOnBoard() > newLoc){
                    playerPassedGo(nowPlayer);
                }

                nowPlayer.setLocationOnBoard(newLoc);
                if(this.nowPlayer.isCommunityChest()){
                    iceChestbtn.setDisable(false);
                }
                moveToken(turn, newLoc);
                int rent = model.board[newLoc].landedOn(nowPlayer, roll);
                if(rent>0){
                    payRentFromPlayerToPlayer(nowPlayer,model.board[newLoc].getOwner(),rent);
                }
                iceChestbtn.setDisable(true);

            }
            //13 = Card 13 Take a walk on the Statler Street – Advance token to Statler Street
            else if (result[0] == 13){
                int newLoc = 37;
                int[] move = model.getDice().rollDice(numDubs);
                int roll = move[0] + move[1];
                if(nowPlayer.getLocationOnBoard() > newLoc){
                    playerPassedGo(nowPlayer);
                }

                nowPlayer.setLocationOnBoard(newLoc);
                if(this.nowPlayer.isCommunityChest()){
                    iceChestbtn.setDisable(false);
                }
                moveToken(turn, newLoc);
                int rent = model.board[newLoc].landedOn(nowPlayer, roll);
                if(rent>0){
                    payRentFromPlayerToPlayer(nowPlayer,model.board[newLoc].getOwner(),rent);
                }
                iceChestbtn.setDisable(true);

            }
            //14 = Card 14 You have been elected Chairman of the Board – Pay each player $50
            else if (result[0] == 14){
                nowPlayer.chairManFee();
                model.allPlayers.get(0).chairManAward();
                model.allPlayers.get(1).chairManAward();
                model.allPlayers.get(2).chairManAward();
                model.allPlayers.get(3).chairManAward();
                iceChestbtn.setDisable(true);

            }
            //15 = Card 15 Your building loan matures – Collect $150
            else if (result[0] == 15){
                nowPlayer.loanMatures();
                iceChestbtn.setDisable(true);

            }
            //16 = Card 16 You have won a crossword competition - Collect $100
            else if (result[0] == 16){
                nowPlayer.crossWordAward();
                iceChestbtn.setDisable(true);

            }
        });



    }
    //method that handles updating the images that correspond with developing a property
    public void updateHousePic(Property prop){
        int location = prop.getLocation();
        if(location==1){
            if(prop.getBuildings()==0){
                house1.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house1.setVisible(true);
                house1.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house1.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house1.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house1.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house1.setImage(hotel);
            }
        }
        else if(location==3){
            if(prop.getBuildings()==0){
                house3.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house3.setVisible(true);
                house3.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house3.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house3.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house3.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house3.setImage(hotel);
            }
        }
        else if(location==6){
            if(prop.getBuildings()==0){
                house6.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house6.setVisible(true);
                house6.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house6.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house6.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house6.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house6.setImage(hotel);
            }
        }
        else if(location==8){
            if(prop.getBuildings()==0){
                house8.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house8.setVisible(true);
                house8.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house8.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house8.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house8.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house8.setImage(hotel);
            }
        }
        else if(location==9){
            if(prop.getBuildings()==0){
                house9.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house9.setVisible(true);
                house9.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house9.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house9.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house9.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house9.setImage(hotel);
            }
        }
        else if(location==11){
            if(prop.getBuildings()==0){
                house11.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house11.setVisible(true);
                house11.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house11.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house11.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house11.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house11.setImage(hotel);
            }
        }
        else if(location==13){
            if(prop.getBuildings()==0){
                house13.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house13.setVisible(true);
                house13.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house13.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house13.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house13.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house13.setImage(hotel);
            }
        }
        else if(location==14){
            if(prop.getBuildings()==0){
                house14.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house14.setVisible(true);
                house14.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house14.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house14.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house14.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house14.setImage(hotel);
            }
        }
        else if(location==16){
            if(prop.getBuildings()==0){
                house16.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house16.setVisible(true);
                house16.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house16.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house16.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house16.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house16.setImage(hotel);
            }
        }
        else if(location==18){
            if(prop.getBuildings()==0){
                house18.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house18.setVisible(true);
                house18.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house18.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house18.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house18.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house18.setImage(hotel);
            }
        }
        else if(location==19){
            if(prop.getBuildings()==0){
                house19.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house19.setVisible(true);
                house19.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house19.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house19.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house19.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house19.setImage(hotel);
            }
        }
        else if(location==21){
            if(prop.getBuildings()==0){
                house21.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house21.setVisible(true);
                house21.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house21.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house21.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house21.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house21.setImage(hotel);
            }
        }
        else if(location==23){
            if(prop.getBuildings()==0){
                house23.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house23.setVisible(true);
                house23.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house23.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house23.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house23.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house23.setImage(hotel);
            }
        }
        else if(location==24){
            if(prop.getBuildings()==0){
                house24.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house24.setVisible(true);
                house24.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house24.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house24.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house24.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house24.setImage(hotel);
            }
        }
        else if(location==26){
            if(prop.getBuildings()==0){
                house26.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house26.setVisible(true);
                house26.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house26.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house26.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house26.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house26.setImage(hotel);
            }
        }
        else if(location==27){
            if(prop.getBuildings()==0){
                house27.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house27.setVisible(true);
                house27.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house27.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house27.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house27.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house27.setImage(hotel);
            }
        }
        else if(location==29){
            if(prop.getBuildings()==0){
                house29.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house29.setVisible(true);
                house29.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house29.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house29.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house29.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house29.setImage(hotel);
            }
        }
        else if(location==31){
            if(prop.getBuildings()==0){
                house31.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house31.setVisible(true);
                house31.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house31.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house31.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house31.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house31.setImage(hotel);
            }
        }
        else if(location==32){
            if(prop.getBuildings()==0){
                house32.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house32.setVisible(true);
                house32.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house32.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house32.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house32.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house32.setImage(hotel);
            }
        }
        else if(location==34){
            if(prop.getBuildings()==0){
                house34.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house34.setVisible(true);
                house34.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house34.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house34.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house34.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house34.setImage(hotel);
            }
        }
        else if(location==37) {
            if (prop.getBuildings() == 0) {
                house37.setVisible(false);
            }
            else if (prop.getBuildings() == 1) {
                house37.setVisible(true);
                house37.setImage(housePic1);
            }
            else if (prop.getBuildings() == 2) {
                house37.setImage(housePic2);
            }
            else if (prop.getBuildings() == 3) {
                house37.setImage(housePic3);
            }
            else if (prop.getBuildings() == 4) {
                house37.setImage(housePic4);
            }
            else if (prop.getBuildings() == 5) {
                house37.setImage(hotel);
            }
        }
        else if(location==39){
            if(prop.getBuildings()==0){
                house39.setVisible(false);
            }
            else if(prop.getBuildings()==1){
                house39.setVisible(true);
                house39.setImage(housePic1);
            }
            else if(prop.getBuildings()==2){
                house39.setImage(housePic2);
            }
            else if(prop.getBuildings()==3){
                house39.setImage(housePic3);
            }
            else if(prop.getBuildings()==4){
                house39.setImage(housePic4);
            }
            else if(prop.getBuildings()==5){
                house39.setImage(hotel);
            }
        }

    }
}
