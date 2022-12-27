package betclic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.Match;
import common.ScrapTools;

public class BetclicScrapTools {
	
	public String dataClean(String data) {
		return data.replace("&q;", "");
	}
	
//	web page -> list of matches isolated data
	public List<String> isolateMatchesData(String data){
		List<String> isolatedMatchesData = new ArrayList<>(Arrays.asList(data.split("event_type:Match},")));
		isolatedMatchesData.remove(0);
		for (int i = 0; i < isolatedMatchesData.size(); i++) {
			isolatedMatchesData.set(i, isolatedMatchesData.get(i).substring(isolatedMatchesData.get(i).indexOf("contestants:")));
		}
		return isolatedMatchesData;
	}
	
// single match isolated data -> 1N2 odds
//	public List<Double> odds1N2(String isolatedMatchData){
//		List<Double> odds = new ArrayList<>();
//		for (int i = 0; i < 3; i++) {
//			odds.add(Double.parseDouble(GlobalScrapTools.getPropertyValue(isolatedMatchData, ",odds:", ",")));
//			isolatedMatchData = isolatedMatchData.substring(isolatedMatchData.indexOf(",odds:")+1);
//		}
//		return odds;
//	}
	
//	single match isolated data -> List<BetclicMatch>
	public List<Match> isolatedDataToBetclicMatches(List<String> isolatedMatchesData) {
		List<Match> betclicMatches = new ArrayList<>();
		
		for(String data : isolatedMatchesData) {
			Match match = new Match();
			
			data = setContestant1Name(match, data);
			data = setContestant1ShortName(match, data);
			data = setContestant2Name(match, data);
			data = setContestant2ShortName(match, data);
			data = setOdds1(match, data);
			data = setOddsN(match, data);
			data = setOdds2(match, data);
			
			//name:Reims,odds:3
			System.out.println(match.getHomeTeamName(0));
			System.out.println(match.getHomeTeamName(1));
			System.out.println(match.getAwayTeamName(0));
			System.out.println(match.getAwayTeamName(1));
			System.out.println(match.getMainBetOdd('1'));
			System.out.println(match.getMainBetOdd('N'));
			System.out.println(match.getMainBetOdd('2'));
			
			System.out.println(data);
			
			betclicMatches.add(match);
		}
		return betclicMatches;
	}
	
	public String setContestant1Name(Match match, String data) {
		String value = ScrapTools.getPropertyValue(data, "name", ",", false, true);
		match.addHomeTeamName(value);
		return data.substring(data.indexOf(value) + value.length());
	}
	
	public String setContestant1ShortName(Match match, String data) {
		String value = ScrapTools.getPropertyValue(data, "short_name", ",", false, true);
		match.addHomeTeamName(value);
		return data.substring(data.indexOf(value) + value.length());
	}
	
	public String setContestant2Name(Match match, String data) {
		String value = ScrapTools.getPropertyValue(data, "name", ",", false, true);
		match.addAwayTeamName(value);
		return data.substring(data.indexOf(value) + value.length());
	}

	public String setContestant2ShortName(Match match, String data) {
		String value = ScrapTools.getPropertyValue(data, "short_name", ",", false, true);
		match.addAwayTeamName(value);
		return data.substring(data.indexOf(value) + value.length());
	}

	// name:Reims,odds:3
	// ,name:Paris SG,odds:1.12,
	public String setOdds1(Match match, String data) {
		String propertyName = ",name:" + match.getHomeTeamName(0) + ",odds";
		String value = ScrapTools.getPropertyValue(data, propertyName, ",", false, true);
		match.setMainBetOdd('1', Double.parseDouble(value));
		return data.substring(data.indexOf(value) + value.length());
	}

	public String setOddsN(Match match, String data) {
		String propertyName = ",name:Nul,odds";
		String value = ScrapTools.getPropertyValue(data, propertyName, ",", false, true);
		match.setMainBetOdd('N', Double.parseDouble(value));
		return data.substring(data.indexOf(value) + value.length());
	}

	public String setOdds2(Match match, String data) {
		String propertyName = ",name:" + match.getAwayTeamName(0) + ",odds";
		String value = ScrapTools.getPropertyValue(data, propertyName, ",", false, true);
		match.setMainBetOdd('2', Double.parseDouble(value));
		return data.substring(data.indexOf(value) + value.length());
	}
	
}
