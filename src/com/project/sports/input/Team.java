package com.project.sports.input;

public class Team {
	
	private int seq;
	private int year;
	private String type;
	private String teamName;
	private int win;
	private int lose;
	private String place;
	
	public Team(int seq, int year, String type, String teamName, int win, int lose, String place) {
		this.seq = seq;
		this.year = year;
		this.type = type;
		this.teamName = teamName;
		this.win = win;
		this.lose = lose;
		this.place = place;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return String.format(
				"Team [seq=%s, year=%s, type=%s, teamName=%s, win=%s, lose=%s, place=%s]", seq,
				year, type, teamName, win, lose, place);
	}
	
	
	
	
	
	
}
