package betclic;

import common.ScrapTools;

public class BetclicMatch {
	private String name;
	private String contestant1Name;
	private String contestant1ShortName;
	private String contestant2Name;
	private String contestant2ShortName;
	private String odds1;
	private String oddsN;
	private String odds2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContestant1Name() {
		return contestant1Name;
	}

	public String setContestant1Name(String data) {
		String value = ScrapTools.getPropertyValue(data, "name", ",", false, true);
		contestant1Name = value;
		return data.substring(data.indexOf(value) + value.length());
	}

	public String getContestant1ShortName() {
		return contestant1ShortName;
	}

	public String setContestant1ShortName(String data) {
		String value = ScrapTools.getPropertyValue(data, "short_name", ",", false, true);
		contestant1ShortName = value;
		return data.substring(data.indexOf(value) + value.length());
	}

	public String getContestant2Name() {
		return contestant2Name;
	}

	public String setContestant2Name(String data) {
		String value = ScrapTools.getPropertyValue(data, "name", ",", false, true);
		contestant2Name = value;
		return data.substring(data.indexOf(value) + value.length());
	}

	public String getContestant2ShortName() {
		return contestant2ShortName;
	}

	public String setContestant2ShortName(String data) {
		String value = ScrapTools.getPropertyValue(data, "short_name", ",", false, true);
		contestant2ShortName = value;
		return data.substring(data.indexOf(value) + value.length());
	}

	public String getOdds1() {
		return odds1;
	}

	// name:Reims,odds:3
	// ,name:Paris SG,odds:1.12,
	public String setOdds1(String data) {
		String propertyName = ",name:" + contestant1Name + ",odds";
		String value = ScrapTools.getPropertyValue(data, propertyName, ",", false, true);
		odds1 = value;
		return data.substring(data.indexOf(value) + value.length());
	}

	// ,name:Nul,odds:
	public String getOddsN() {
		return oddsN;
	}

	public String setOddsN(String data) {
		String propertyName = ",name:Nul,odds";
		String value = ScrapTools.getPropertyValue(data, propertyName, ",", false, true);
		oddsN = value;
		return data.substring(data.indexOf(value) + value.length());
	}

	public String getOdds2() {
		return odds2;
	}

	public String setOdds2(String data) {
		String propertyName = ",name:" + contestant2Name + ",odds";
		String value = ScrapTools.getPropertyValue(data, propertyName, ",", false, true);
		odds2 = value;
		return data.substring(data.indexOf(value) + value.length());
	}

}
