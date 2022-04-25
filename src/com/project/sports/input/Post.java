package com.project.sports.input;

import java.util.Calendar;

public class Post {
	
	private int seq;
	private Calendar date;
	private String id;
	private String subject;
	private String title;
	private String content;
	private int view;
	
	public Post(int seq, Calendar date, String id, String subject, String title, String content,
			int view) {
		this.seq = seq;
		this.date = date;
		this.id = id;
		this.subject = subject;
		this.title = title;
		this.content = content;
		this.view = view;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return String.format(
				"Post [seq=%s, date=%s, id=%s, subject=%s, title=%s, content=%s, view=%s]", seq,
				date, id, subject, title, content, view);
	}
	
	
	

}
