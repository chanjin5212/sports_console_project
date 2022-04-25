package com.project.sports.input;

import java.util.ArrayList;
import java.util.List;

public class RelativeRecord {
	
	private int seq;
	private List<Record> list = new ArrayList<Record>();
	
	public RelativeRecord(int seq, List<Record> list) {
		this.seq = seq;
		this.list = list;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public List<Record> getList() {
		return list;
	}

	public void setList(List<Record> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return String.format("RelativeRecord [seq=%s, list=%s]", seq, list);
	}
	
	
	
	

}
