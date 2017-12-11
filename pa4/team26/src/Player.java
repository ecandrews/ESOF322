import java.util.ArrayList;

//class for each player
public class Player {

	private String name;
	private boolean inJail = false;
	private int cashOnHand;
	private int totalWorth;
	private int locationOnBoard;
	private int numRailroadsOwned;
	private int numUtilsOwned;
	private boolean hasGetOutOfJail = false;
	private ArrayList<Property> propertiesOwned;
	private ArrayList<BasicProp> bPropsOwned;


	//constructor which instantiates each value
	public Player(String name) {
		this.name = name;
		this.cashOnHand = 1500; // starting amount of cash
		this.totalWorth = 1500;
		this.locationOnBoard = 0; // the GO square
		this.propertiesOwned = new ArrayList<Property>(); // initialize arrayList
		this.bPropsOwned = new ArrayList<BasicProp>(); // initialize arrayList
	}

	public String getName() {
		return this.name;
	}

	//method that sets a player in jail
	public void setInJail(boolean setJail) {
		this.inJail = setJail;
		if (setJail) {
			this.setLocationOnBoard(10);
		}
	}

	// displays all owned properties in the left side of the GUI
	public String getPropLabel(){
		String label = "";

		for (Property prop: getPropertiesOwned()) {
			if(getPropertiesOwned().indexOf(prop) == 0){
				label = Integer.toString(prop.getLocation());

			}
			else{
				label = label + ", " + Integer.toString(prop.getLocation());

			}
		}
		return label;
	}

	public boolean getInJail() {
		return this.inJail;
	}

	public int getNumUtilsOwned() {
		return numUtilsOwned;
	}

	public void setCashOnHand(double cash) // send in positive number to add cash, and negative number to subtract cash
	{
		this.cashOnHand += cash;
		this.totalWorth += cash;

	}

	public int getCashOnHand() {
		return this.cashOnHand;
	}

	public int getTotalWorth() {
		return this.totalWorth;
	}

	public int getLocationOnBoard() {
		return this.locationOnBoard;
	}

	public void setLocationOnBoard(int newLoc) {
		this.locationOnBoard = newLoc;
	}

	public ArrayList<Property> getPropertiesOwned() {
		return this.propertiesOwned;
	}

	// remove a specified property from the list
	public void removeProperty(Property prop) {
		this.propertiesOwned.remove(prop);
		if (prop.getClass().equals(BasicProp.class)) {
			this.bPropsOwned.remove(((prop)));
		}
		else if (prop.getClass().equals(Railroad.class)) {
			this.numRailroadsOwned--;
		}
	}


	// add a new property to the list
	// used in auctions, setCashOnHand to handle dynamic price
	public void addProperty(Property prop) {
		this.propertiesOwned.add(prop);
		if (prop.getClass().equals(BasicProp.class)) {
			this.bPropsOwned.add((((BasicProp) prop)));
		}
		if (prop.getClass().equals(Railroad.class)) {
			this.numRailroadsOwned++;
		}
		if(prop.getClass().equals(Utility.class)){
			this.numUtilsOwned++;
		}
	}

	// return true if the player owns the specified property, otherwise false
	// might be a redundant method, very similar to purchase property
	public boolean ownsProp(Property prop) {
		return this.propertiesOwned.contains(prop);
	}

	// sell property for mortgage amount
	public void mortgageProperty(Property prop) {
		removeProperty(prop);
		// this.setCashOnHand(prop.getMortgageVal());
	}

	public void MeatyTax() {
		this.cashOnHand -= 75;
	}

	public void oMeatTax() {
		this.cashOnHand -= 200;
	}

	public void utilityPayment(int sum){ this.cashOnHand -= (sum*10); }
	public void utilityReward(int sum){ int money = sum*10;this.cashOnHand+= money; }

	public void setGetOutOfJailFree(boolean has)
	{
		hasGetOutOfJail = has;
	}
	public boolean getHasGetOutOfJailFree()
	{
		return hasGetOutOfJail;
	}
	public int getNumRailroadsOwned() {
		return numRailroadsOwned;
	}

	public ArrayList<BasicProp> getBPropsOwned() {
		return bPropsOwned;
	}
	public boolean isCommunityChest()
	{
		if(this.locationOnBoard == 2 || this.locationOnBoard == 33 || this.locationOnBoard == 17)
		{
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isMysteryMeat()
	{
		{
			if(this.locationOnBoard == 7 || this.locationOnBoard == 22 || this.locationOnBoard == 36)
			{
			return true;
			}
			else {
			return false;
			}
		}
	}
}
