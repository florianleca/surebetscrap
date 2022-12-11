package betclic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public List<BetclicMatch> isolatedDataToBetclicMatches(List<String> isolatedMatchesData) {
		List<BetclicMatch> betclicMatches = new ArrayList<>();
		
		for(String data : isolatedMatchesData) {
			BetclicMatch match = new BetclicMatch();
			
			data = match.setContestant1Name(data);
			data = match.setContestant1ShortName(data);
			data = match.setContestant2Name(data);
			data = match.setContestant2ShortName(data);
			data = match.setOdds1(data);
			data = match.setOddsN(data);
			data = match.setOdds2(data);
			
			
			
			
			
			//name:Reims,odds:3
			System.out.println(match.getContestant1Name());
			System.out.println(match.getContestant1ShortName());
			System.out.println(match.getContestant2Name());
			System.out.println(match.getContestant2ShortName());
			System.out.println(match.getOdds1());
			System.out.println(match.getOddsN());
			System.out.println(match.getOdds2());
			
			System.out.println(data);
			
			betclicMatches.add(match);
		}
		
		return betclicMatches;
	}
	
}
