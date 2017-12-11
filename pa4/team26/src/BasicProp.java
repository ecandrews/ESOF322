public class BasicProp extends Property {
    //contains the costs of each property's building cost
    private int[] rent_list = new int[6];
    private int buildings = 0;
    private int monop_num;
    private String color;
    private int buildingCost;
    private int location;

    public BasicProp(int[] rent_list, String color, int value, int location, int[] coord) {
        super.setLocation(location);
        this.rent_list = rent_list;
        this.color = color;
        super.setValue(value);
        super.setCoord(coord);
        switch(color){
            case "brown":
                this.buildingCost = 50;
                break;

            case "ltblue":
                this.buildingCost = 50;
                break;
            case "pink":
                this.buildingCost = 100;
                break;

            case "orange":
                this.buildingCost = 100;
                break;

            case "red":
                this.buildingCost = 150;
                break;

            case "yellow":
                this.buildingCost = 150;
                break;

            case "green":
                this.buildingCost = 200;
                break;

            case "dkblue":
                this.buildingCost = 200;
                break;
        }
    }

    @Override
    //method to develop a property
    public void addBuilding() {
        this.buildings++;
        updateMortgageablitiy();
    }

    //method to allow a player to mortgage a property or not, if it meets the validity condition
    // of having developments
    private void updateMortgageablitiy() {
        if (this.getBuildings() == 0){
            this.setMortgageable(true);
        }
        else {
            this.setMortgageable(false);
        }
    }


    //method to sell a development
    public void removeBuilding() {
        this.buildings--;
        updateMortgageablitiy();
    }
    @Override
    //get method for buildings
    public int getBuildings() {
        return buildings;
    }

    //get method for color of property
    public String getColor() {
        return color;
    }

    //get cost of the building
    public int getBuildingCost() {
        return buildingCost;
    }

    @Override
    //determines if a property is owned upon being landed on
    public int landedOn(Player p, int roll){

        if(this.getOwner() == null){
            return 0;
        }
        return this.rent_list[buildings];
    }
}
