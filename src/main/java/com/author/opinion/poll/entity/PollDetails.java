package com.author.opinion.poll.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PollDetails {

	
	public int getId() {
		return id;
	}
	public String getAuthor() {
		return author;
	}
	public Long getVote() {
		return vote;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Override
	public String toString() {
		return "PollDetails [id=" + id + ", author=" + author + ", vote=" + vote + "]";
	}
	public PollDetails(int id, String author, Long vote) {
		super();
		this.id = id;
		this.author = author;
		this.vote = vote;
	}
	private String author;
	private Long vote;
	
	protected PollDetails() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setVote(Long vote) {
		this.vote = vote;
	}
	
}
