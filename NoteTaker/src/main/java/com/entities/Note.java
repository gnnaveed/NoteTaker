package com.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Random;


@Entity
@Table(name="notes")
public class Note {
    private int id;
    private String title;
    private String content;
    private Date addedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public Note(String title, String content, Date addedDate) {
	    this.id = new Random().nextInt(100000); // generate random ID
	    this.title = title;
	    this.content = content;
	    this.addedDate = addedDate;
	}

	
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}

