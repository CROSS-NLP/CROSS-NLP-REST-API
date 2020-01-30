package org.crossnlp.api.model;

public class Instance {

	String newsgroup;
	String subject; 
	String text;
	private int threadId, positionFromThreadBeginning;

	public String getNewsgroup() {
		return newsgroup;
	}

	public void setNewsgroup(String newsgroup) {
		this.newsgroup = newsgroup;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public int getPositionFromThreadBeginning() {
		return positionFromThreadBeginning;
	}

	public void setPositionFromThreadBeginning(int positionFromThreadBeginning) {
		this.positionFromThreadBeginning = positionFromThreadBeginning;
	}
	
}
