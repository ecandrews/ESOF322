
public class Utility extends Property {

    private int mult=0;
    //just a class for the specialized type of property for the two utility pieces with their
    // corresponding rents etc.
    public Utility(int location, int[] coord) {
        super.setValue(150);
        super.setCoord(coord);
        super.setLocation(location);
    }
    @Override
    public int landedOn(Player p, int roll){

        if(this.getOwner() == null){
            return 0;

        }else{
            if(this.getOwner().getNumUtilsOwned()==1){
                mult = 4;
            }
            else if(this.getOwner().getNumUtilsOwned()==2){
                mult = 10;
            }
        }
        int rent = getRent(roll);
        return rent;
    }
    public int getRent(int lastRoll) {
        return (lastRoll * mult);
    }
}