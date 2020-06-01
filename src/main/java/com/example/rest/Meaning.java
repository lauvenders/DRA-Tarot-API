package com.example.rest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Entity
@Table(name = "meaning")
public class Meaning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 65)
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "text")
	private String text;
	
	@ManyToOne
	@JoinTable(
		name="has_meaning",
		joinColumns = {@JoinColumn(name="meaning_id")},
		inverseJoinColumns = {@JoinColumn(name="card_id")}
	)
	private Card cards;
	
	// Hibernate requires a no-arg constructor
	public Meaning() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
