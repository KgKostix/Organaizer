package com.gwt.shared.task;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task implements Serializable {
	private static final long serialVersionUID = -6011496818179621243L;
	
	@Id  
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "task_seq_gen")
	@SequenceGenerator(name = "task_seq_gen", sequenceName = "tak_id_seq")
	private long id;
	
	@Column(name="SUBJECT",unique = false, nullable = false, length = 200)
	private String subject;
	
	@Column(name="EVENTTEXT",unique = false, nullable = true)
	private String text;
	
	@Column(name="DATAEVENT",unique = false, nullable = true)
	private Date dateEvent;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}
}
