package io.mcnamee.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Post implements Serializable {

	private Long id;

	private Date date = Date.valueOf(LocalDate.now());

	private Time time = Time.valueOf(LocalTime.now());

	private String author;

	private String body, title;

	public Post() {}

	public Post(String body) {
		this.body = body;
	}

	public Post(String author, String body, String title) {
		this.author = author;
		this.body = body;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the subject to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
