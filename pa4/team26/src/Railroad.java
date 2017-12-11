
public class Railroad extends Property {


    //special class for the 4 railroad spaces on the board
    public Railroad(int location, int[] coord) {
        super.setValue(200);
        super.setCoord(coord);
        super.setLocation(location);
    }

    @Override
    public int landedOn(Player p, int roll){
        if(this.getOwner() == null){
            return 0;

        }
        int rent = getRent();
        return rent;

    }

    public int getRent() {
        int rentDecider = this.getOwner().getNumRailroadsOwned();
        switch (rentDecider) {
            case 1:
                rentDecider = 25;
                break;
            case 2:
                rentDecider = 50;
                break;
            case 3:
                rentDecider = 100;
                break;
            case 4:
                rentDecider = 200;
                break;
        }
        return rentDecider;
    }
}
