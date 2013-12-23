package com.gwt.shared.task;

public class Task {

	public Task(String subject, String text) {
		super();
		this.subject = subject;
		this.text = text;
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

	private String subject = "";
	private String text = "";

}
