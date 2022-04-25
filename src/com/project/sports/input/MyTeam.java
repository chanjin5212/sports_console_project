package com.project.sports.input;

public class MyTeam {
	
	private int seq;
	private String id;
	private int teamSeq;
	private String teamName;
	private String type;
	
	public MyTeam(int seq, String id, int teamSeq, String teamName, String type) {
		this.seq = seq;
		this.id = id;
		this.teamSeq = teamSeq;
		this.teamName = teamName;
		this.type = type;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTeamSeq() {
		return teamSeq;
	}

	public void setTeamSeq(int teamSeq) {
		this.teamSeq = teamSeq;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("MyTeam [seq=%s, id=%s, teamSeq=%s, teamName=%s, type=%s]", seq, id,
				teamSeq, teamName, type);
	} 
	
	

}
