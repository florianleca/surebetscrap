package winamax;

public class WinamaxMatch {
	private String title;
	private String equipeHome;
	private String equipeAway;
	private String mainBetId;
	private String tournamentId;
	
	
	public String getTitle() {
		return title;
	}
	
	public String getMainBetId() {
		return mainBetId;
	}
	
	public String getTournamentId() {
		return tournamentId;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setEquipeHome(String equipeHome) {
		this.equipeHome = equipeHome;
	}

	public void setEquipeAway(String equipeAway) {
		this.equipeAway = equipeAway;
	}

	public void setMainBetId(String mainBetId) {
		this.mainBetId = mainBetId;
	}
	
	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
	
	@Override
	public String toString() {
		return title;
	}

}
