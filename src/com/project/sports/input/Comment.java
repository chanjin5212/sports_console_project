package com.project.sports.input;

import java.util.Calendar;

public class Comment {
	
	private int seq;
	private int postSeq;
	private Calendar date;
	private String id;
	private String content;
	
	public Comment(int seq, int postSeq, Calendar date, String id, String content) {
		this.seq = seq;
		this.postSeq = postSeq;
		this.date = date;
		this.id = id;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getPostSeq() {
		return postSeq;
	}

	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("Comment [seq=%s, postSeq=%s, date=%s, id=%s, content=%s]", seq,
				postSeq, date, id, content);
	}
	
	


}
