package common;

import java.util.List;

import winamax.WinamaxMatch;

public class Bet implements Comparable<Bet> {
	private String id;
	private WinamaxMatch match;
	private int indexInData;
	private List<BetOutcome> outcomes;

	public Bet(WinamaxMatch match, int indexInData) {
		this.id = match.getMainBetId();
		this.match = match;
		this.indexInData = indexInData;
	}

	public String getId() {
		return id;
	}

	public List<BetOutcome> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(List<BetOutcome> outcomes) {
		this.outcomes = outcomes;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WinamaxMatch getMatch() {
		return match;
	}

	public void setMatch(WinamaxMatch match) {
		this.match = match;
	}

	@Override
	public int compareTo(Bet b) {
		return indexInData - b.indexInData;
	}

	@Override
	public String toString() {
		return "Bet [match=" + match + ", outcomes=" + outcomes + "]";
	}

}
