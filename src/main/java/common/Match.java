package common;

import java.util.ArrayList;
import java.util.List;

public class Match {
	private String title;
	private List<String> homeTeamNames;
	private List<String> awayTeamNames;
	private double[] mainBetOdds;

	// constructor
	public Match() {
		homeTeamNames = new ArrayList<>();
		awayTeamNames = new ArrayList<>();
		mainBetOdds = new double[3];
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

	// main bet odds getter and setter
	
	public double getMainBetOdd(char outcome) {
		double odd = 0;
		switch (outcome) {
		case '1':
			odd = mainBetOdds[0];
			break;
		case 'N':
			odd = mainBetOdds[1];
			break;
		case '2':
			odd = mainBetOdds[2];
			break;
		default:
			break;
		}
		return odd;
	}
	
	public void setMainBetOdd(char outcome, double odd) {
		switch (outcome) {
		case '1':
			mainBetOdds[0] = odd;
			break;
		case 'N':
			mainBetOdds[1] = odd;
			break;
		case '2':
			mainBetOdds[2] = odd;
			break;
		default:
			throw new IllegalArgumentException("Only '1', 'N' or '2' are valid outcomes.");
		}
	}	
}