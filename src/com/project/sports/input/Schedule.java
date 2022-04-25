package com.project.sports.input;

import java.util.Calendar;

public class Schedule {
	// 상대전적 삭제
	private int seq;
	private String team1;
	private String team2;
	private String starting1;
	private String starting2;
	private String place;
	private Calendar date;
	private String time;
	private String weather;
	private int team1Score;
	private int team2Score;
	
	public Schedule(int seq, String team1, String team2, String starting1, String starting2,
			String place, Calendar date, String time, String weather, int team1Score,
			int team2Score) {
		this.seq = seq;
		this.team1 = team1;
		this.team2 = team2;
		this.starting1 = starting1;
		this.starting2 = starting2;
		this.place = place;
		this.date = date;
		this.time = time;
		this.weather = weather;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getStarting1() {
		return starting1;
	}

	public void setStarting1(String starting1) {
		this.starting1 = starting1;
	}

	public String getStarting2() {
		return starting2;
	}

	public void setStarting2(String starting2) {
		this.starting2 = starting2;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}

	public int getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}

	@Override
	public String toString() {
		return String.format(
				"Schedule [seq=%s, team1=%s, team2=%s, starting1=%s, starting2=%s, place=%s, date=%s, time=%s, weather=%s, team1Score=%s, team2Score=%s]",
				seq, team1, team2, starting1, starting2, place, date, time, weather, team1Score,
				team2Score);
	}
	
	
	

}
