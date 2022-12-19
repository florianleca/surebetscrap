package common;

import java.util.ArrayList;
import java.util.List;

public abstract class Match {
	private String title;
	private List<String> homeTeamNames;
	private List<String> awayTeamNames;
	private List<Bet> bets;
	
	// constructor
	public Match() {
		homeTeamNames = new ArrayList<>();
		awayTeamNames = new ArrayList<>();
		bets = new ArrayList<>();
	}
	
	// title getter and setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	// homeTeamNames getters and adder
	public List<String> getHomeTeamNames() {
		return homeTeamNames;
	}
	public String getHomeTeamName(int index) {
		return homeTeamNames.get(index);
	}
	public void addHomeTeamName(String name) {
		homeTeamNames.add(name);
	}
	
	// awayTeamNames getters and adder
	public List<String> getAwayTeamNames() {
		return awayTeamNames;
	}
	public String getAwayTeamName(int index) {
		return awayTeamNames.get(index);
	}
	public void addAwayTeamName(String name) {
		awayTeamNames.add(name);
	}

	// bets getters and adder
	public List<Bet> getBets() {
		return bets;
	}
	public Bet getBet(int index) {
		return bets.get(index);
	}
	public void addBet(Bet bet) {
		bets.add(bet);
	}	
}