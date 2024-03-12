package in.sellenium.entity;

public class Monkey implements Animal{

	private int leg ;
	private int hand;
	private String nam;
	
	public Monkey() {
	}

	public Monkey(int leg, int hand, String nam) {
		super();
		this.leg = leg;
		this.hand = hand;
		this.nam = nam;
	}

	@Override
	public int legs() {
		return leg;
	}

	@Override
	public int hands() {
		return hand;
	}

	@Override
	public String name() {
		return nam;
	}

	@Override
	public String toString() {
		return "Monkey [leg=" + leg + ", hand=" + hand + ", nam=" + nam + "]";
	}
	
	

}
