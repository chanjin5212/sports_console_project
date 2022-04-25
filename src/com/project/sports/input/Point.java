package com.project.sports.input;

import java.util.Calendar;

public class Point {
	
	private int seq;
	private String id;
	private String changePoint;
	private String detail;
	private Calendar date;
	
	public Point(int seq, String id, String changePoint, String detail, Calendar date) {
		this.seq = seq;
		this.id = id;
		this.changePoint = changePoint;
		this.detail = detail;
		this.date = date;
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

	public String getChangePoint() {
		return changePoint;
	}

	public void setChangePoint(String changePoint) {
		this.changePoint = changePoint;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	
	
	

}
