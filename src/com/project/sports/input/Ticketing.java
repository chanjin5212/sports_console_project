package com.project.sports.input;

public class Ticketing {
	
	private int seq;
	private String id;
	private int scheduleSeq;
	private String block;
	private String seatNum;
	
	public Ticketing(int seq, String id, int scheduleSeq, String block, String seatNum) {
		super();
		this.seq = seq;
		this.id = id;
		this.scheduleSeq = scheduleSeq;
		this.block = block;
		this.seatNum = seatNum;
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

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	@Override
	public String toString() {
		return String.format("Ticketing [seq=%s, id=%s, scheduleSeq=%s, block=%s, seatNum=%s]", seq,
				id, scheduleSeq, block, seatNum);
	}
	
	


}
