package com.example.rest;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource()
public interface DeckRepository extends CrudRepository<Deck, Long> {
	
	Set<Deck> findByName(String name);
}
