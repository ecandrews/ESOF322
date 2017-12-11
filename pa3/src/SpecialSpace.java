
public class SpecialSpace extends Property {
	private String type;
	// handles the 3 spaces that either tax or send the player to jail
	public SpecialSpace(String type, int[] coord) {
		this.type = type;
		super.setCoord(coord);
	}

	@Override
	public int landedOn(Player p, int roll){

		switch(type){
			case("oTax"):
				p.oMeatTax();
			case("mTax"):
				p.MeatyTax();
			case("go2Jail"):
				p.setInJail(true);
				p.setLocationOnBoard(10);
			default:
				break;
			case("iChest"):
		}
		return -1;
	}
}
