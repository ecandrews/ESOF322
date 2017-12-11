import javafx.beans.property.*;

public class LabelUpdater {
    //method to take in all players, and update their corresponding values to the gui at the end
    // of each turn.

    //local player variables
    public Player p1;
    public Player p2;
    public Player p3;
    public Player p4;
    public Player nowPlayer;
    //local string properties used to update values in the GUI
    StringProperty p1money = new SimpleStringProperty();
    StringProperty p1properties = new SimpleStringProperty();
    StringProperty p1monopolies = new SimpleStringProperty();
    StringProperty p1position = new SimpleStringProperty();
    StringProperty p1inJail = new SimpleStringProperty();

    StringProperty p2money = new SimpleStringProperty();
    StringProperty p2properties = new SimpleStringProperty();
    StringProperty p2monopolies = new SimpleStringProperty();
    StringProperty p2position = new SimpleStringProperty();
    StringProperty p2inJail = new SimpleStringProperty();

    StringProperty p3money = new SimpleStringProperty();
    StringProperty p3properties = new SimpleStringProperty();
    StringProperty p3monopolies = new SimpleStringProperty();
    StringProperty p3position = new SimpleStringProperty();
    StringProperty p3inJail = new SimpleStringProperty();

    StringProperty p4money = new SimpleStringProperty();
    StringProperty p4properties = new SimpleStringProperty();
    StringProperty p4monopolies = new SimpleStringProperty();
    StringProperty p4position = new SimpleStringProperty();
    StringProperty p4inJail = new SimpleStringProperty();

    public LabelUpdater(Player p1, Player p2, Player p3, Player p4) {

        //constructor instantiating local variables to the players inputted
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;

        //calls method which updates all values
        update();
    }

    //method that actually updates the values by accessing each player's current values
    public void update(){

        this.p1money.setValue(String.valueOf(p1.getCashOnHand()));
        this.p1properties.setValue(p1.getPropLabel());
        this.p1position.setValue(String.valueOf(p1.getLocationOnBoard()));
        this.p1inJail.setValue(String.valueOf(p1.getInJail()));

        this.p2money.setValue(String.valueOf(p2.getCashOnHand()));
        this.p2properties.setValue(p2.getPropLabel());
        this.p2position.setValue(String.valueOf(p2.getLocationOnBoard()));
        this.p2inJail.setValue(String.valueOf(p2.getInJail()));

        this.p3money.setValue(String.valueOf(p3.getCashOnHand()));
        this.p3properties.setValue(p3.getPropLabel());
        this.p3position.setValue(String.valueOf(p3.getLocationOnBoard()));
        this.p3inJail.setValue(String.valueOf(p3.getInJail()));

        this.p4money.setValue(String.valueOf(p4.getCashOnHand()));
        this.p4properties.setValue(p4.getPropLabel());
        this.p4position.setValue(String.valueOf(p4.getLocationOnBoard()));
        this.p4inJail.setValue(String.valueOf(p4.getInJail()));


    }
}

