package com.project.sports.input;

public class YearTeam {
	
	private int seq;
	private String type;
	private String teamName;
	private String starting;
	
	public YearTeam(int seq, String type, String teamName, String starting) {
		this.seq = seq;
		this.type = type;
		this.teamName = teamName;
		this.starting = starting;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getStarting() {
		return starting;
	}

	public void setStarting(String starting) {
		this.starting = starting;
	}

	@Override
	public String toString() {
		return String.format("YearTeam [seq=%s, type=%s, teamName=%s, starting=%s]", seq, type,
				teamName, starting);
	}
	
	
	
	
	
	

}
