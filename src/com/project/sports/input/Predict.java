package com.project.sports.input;

public class Predict {
	
	private int seq;
	private String id;
	private int scheduleSeq;
	private String teamName;
	private String result;
	
	public Predict(int seq, String id, int scheduleSeq, String teamName, String result) {
		this.seq = seq;
		this.id = id;
		this.scheduleSeq = scheduleSeq;
		this.teamName = teamName;
		this.result = result;
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

	public int getScheduleSeq() {
		return scheduleSeq;
	}

	public void setScheduleSeq(int scheduleSeq) {
		this.scheduleSeq = scheduleSeq;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return String.format("Predict [seq=%s, id=%s, scheduleSeq=%s, teamName=%s, result=%s]", seq,
				id, scheduleSeq, teamName, result);
	}
	
	
	
	

}
