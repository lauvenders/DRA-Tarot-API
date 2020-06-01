package com.example.rest;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Entity
@Table(name = "cards")
public class Card implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(max = 65)
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "img")
	private String img;
	
	@ManyToOne
	@JoinTable(
		name="belongs_to",
		joinColumns = {@JoinColumn(name = "card_id")},
		inverseJoinColumns = {@JoinColumn(name = "deck_id")}
	)
	private Deck deck;
	
	@OneToMany(mappedBy = "cards")
	private Set<Meaning> meanings;

	// Hibernate requires a no-arg constructor
	public Card() {

	}

	public Card(String name, String img) {
		this.name = name;
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
