package com.project.sports.input;

public class Player {
	
	private int seq;
	private int teamSeq;
	private String year;
	private String position;
	private String playerNum;
	private String name;
	private String height;
	private String weight;
	private double battingAvg;
	private int homeRun;
	private int hit;
	private int hitScore;
	private int makeScore;
//	private int hitSum;
	private double earnedRunAvg;
	private int win;
	private int inning;
	private int threeOut;
	
	
	
	public Player(int seq, int teamSeq, String year, String position, String playerNum, String name,
			String height, String weight) {
		
		this.seq = seq;
		this.teamSeq = teamSeq;
		this.year = year;
		this.position = position;
		this.playerNum = playerNum;
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	//타자
	public Player(int seq, int teamSeq, String year, String position, String playerNum, String name,
			String height, String weight, double battingAvg, int homeRun, int hit, int hitScore,
			int makeScore) {
		
		this(seq, teamSeq, year, position, playerNum, name, height, weight);
		this.battingAvg = battingAvg;
		this.homeRun = homeRun;
		this.hit = hit;
		this.hitScore = hitScore;
		this.makeScore = makeScore;
//		this.hitSum = hitSum;
	}
	//투수
	public Player(int seq, int teamSeq, String year, String position, String playerNum, String name,
			String height, String weight, double earnedRunAvg, int win, int inning, int threeOut) {
		
		this(seq, teamSeq, year, position, playerNum, name, height, weight);
		this.earnedRunAvg = earnedRunAvg;
		this.win = win;
		this.inning = inning;
		this.threeOut = threeOut;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getTeamSeq() {
		return teamSeq;
	}

	public void setTeamSeq(int teamSeq) {
		this.teamSeq = teamSeq;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(String playerNum) {
		this.playerNum = playerNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getHomeRun() {
		return homeRun;
	}

	public void setHomeRun(int homeRun) {
		this.homeRun = homeRun;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getHitScore() {
		return hitScore;
	}

	public void setHitScore(int hitScore) {
		this.hitScore = hitScore;
	}

	public int getMakeScore() {
		return makeScore;
	}

	public void setMakeScore(int makeScore) {
		this.makeScore = makeScore;
	}


	public double getEarnedRunAvg() {
		return earnedRunAvg;
	}

	public void setEarnedRunAvg(double earnedRunAvg) {
		this.earnedRunAvg = earnedRunAvg;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getInning() {
		return inning;
	}

	public void setInning(int inning) {
		this.inning = inning;
	}

	public int getThreeOut() {
		return threeOut;
	}

	public void setThreeOut(int threeOut) {
		this.threeOut = threeOut;
	}
	
	
	
	
}
