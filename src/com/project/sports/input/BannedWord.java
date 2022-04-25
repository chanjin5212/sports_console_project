package com.project.sports.input;

public class BannedWord {
	
	private int seq;
	private String bannedWord;
	
	public BannedWord(int seq, String bannedWord) {
		this.seq = seq;
		this.bannedWord = bannedWord;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getBannedWord() {
		return bannedWord;
	}

	public void setBannedWord(String bannedWord) {
		this.bannedWord = bannedWord;
	}

	@Override
	public String toString() {
		return String.format("BannedWord [seq=%s, bannedWord=%s]", seq, bannedWord);
	}
	
	
	

}
