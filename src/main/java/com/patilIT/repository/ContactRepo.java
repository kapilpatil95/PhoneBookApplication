package com.patilIT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patilIT.model.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
	
	

}
