package winamax;

public enum WinamaxWebPages {
	WIN_FOOT_DE_1("https://www.winamax.fr/paris-sportifs/sports/1/30/42", "42"),
	WIN_FOOT_DE_2("https://www.winamax.fr/paris-sportifs/sports/1/30/41", "41"),
	
	WIN_FOOT_EN_1("https://www.winamax.fr/paris-sportifs/sports/1/1/1", "1"),
	WIN_FOOT_EN_2("https://www.winamax.fr/paris-sportifs/sports/1/1/2", "2"),
	
	WIN_FOOT_ES_1("https://www.winamax.fr/paris-sportifs/sports/1/32/36", "36"),
	WIN_FOOT_ES_2("https://www.winamax.fr/paris-sportifs/sports/1/32/37", "37"),
	
	WIN_FOOT_FR_1("https://www.winamax.fr/paris-sportifs/sports/1/7/4", "4"),
	WIN_FOOT_FR_2("https://www.winamax.fr/paris-sportifs/sports/1/7/19", "19"),
	
	WIN_FOOT_IT_1("https://www.winamax.fr/paris-sportifs/sports/1/31/33", "33"),
	WIN_FOOT_IT_2("https://www.winamax.fr/paris-sportifs/sports/1/31/34", "34");
	
	private String url;
	private String tournamentId;
	
	private WinamaxWebPages(String url, String tournamentId) {
		this.url = url;
		this.tournamentId = tournamentId;
	}

	public String getUrl() {
		return url;
	}

	public String getTournamentId() {
		return tournamentId;
	}
	
	
	
}
