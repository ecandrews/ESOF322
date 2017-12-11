
public class Property {
    // create an interface for the three properties
    private int value;
    private String color;
    private boolean mortgaged = false;
    private Player owner;
    private boolean isOwned;
    private boolean mortgageable = true;
    private int[] coord;
    private int location;

    public Player getOwner() {
        return owner;
    }

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        isOwned = owned;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCoord(int[] coord){this.coord = coord;}

    public int[] getCoord(){return this.coord;}

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    public String getColor() {
        return color;
    }

    public boolean isMortgageable() {
        return mortgageable;
    }

    public void setMortgageable(boolean mortgageable) {
        this.mortgageable = mortgageable;
    }

    public int getLocation() {
        return this.location;
    }
    public void setLocation( int location) {
        this.location = location;
    }

    //CALL THIS METHOD AFTER ROLLING
    //pass the player who rolled and the last roll
    public int landedOn(Player p, int roll){return -1;}
    public int getBuildings(){return 0;}
    public void addBuilding(){}
}
