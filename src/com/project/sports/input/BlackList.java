package com.project.sports.input;

public class BlackList {
	
	private int seq;
	private String name;
	private String id;
	private int warningCount;
	private String detail;
	
	public BlackList(int seq, String name, String id, int warningCount, String detail) {
		this.seq = seq;
		this.name = name;
		this.id = id;
		this.warningCount = warningCount;
		this.detail = detail;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return String.format("BlackList [seq=%s, name=%s, id=%s, warningCount=%s, detail=%s]", seq,
				name, id, warningCount, detail);
	}
	
	
	


}
