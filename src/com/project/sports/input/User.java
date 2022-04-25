package com.project.sports.input;

public class User {
	
	private int seq;
	private String name;
	private String jumin;
	private String number;
	private String id;
	private String password;
	private int point;
	private int warningCount;
	
	public User(int seq, String name, String jumin, String number, String id, String password,
			int point, int warningCount) {
		this.seq = seq;
		this.name = name;
		this.jumin = jumin;
		this.number = number;
		this.id = id;
		this.password = password;
		this.point = point;
		this.warningCount = warningCount;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(int warningCoint) {
		this.warningCount = warningCoint;
	}

	@Override
	public String toString() {
		return String.format(
				"User [seq=%s, name=%s, jumin=%s, number=%s, id=%s, password=%s, point=%s, warningCoint=%s]",
				seq, name, jumin, number, id, password, point, warningCount);
	}
	
	
	
	
}
