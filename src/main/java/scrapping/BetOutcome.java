package scrapping;

public class BetOutcome {
	private String id;
	private Match match;
	private Bet bet;
	private String label;
	private double odd;
	
	public BetOutcome(String id, Match match, Bet bet) {
		super();
		this.id = id;
		this.match = match;
		this.bet = bet;
	}

	public String getId() {
		return id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setOdd(double odd) {
		this.odd = odd;
	}

	@Override
	public String toString() {
		return label + " : " + odd;
	}
	
}
