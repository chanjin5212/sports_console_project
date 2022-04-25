package com.project.sports.input;

public class Record {
	
	private int teamSeq;
	private int win;
	private int lose;
	
	public Record(int teamSeq, int win, int lose) {
		this.teamSeq = teamSeq;
		this.win = win;
		this.lose = lose;
	}

	public int getTeamSeq() {
		return teamSeq;
	}

	public void setTeamSeq(int teamSeq) {
		this.teamSeq = teamSeq;
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

	@Override
	public String toString() {
		return String.format("Record [teamSeq=%s, win=%s, lose=%s]", teamSeq, win, lose);
	}
	
	
	

}
