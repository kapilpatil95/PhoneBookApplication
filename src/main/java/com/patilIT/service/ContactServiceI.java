package com.patilIT.service;

import java.util.List;

import com.patilIT.model.Contact;

public interface ContactServiceI {
	
	boolean saveContact(Contact contact);
	
	List<Contact>getAllContact();
	
	Contact getContactById(Integer Id);
	
	public boolean updateContact(Contact contact);
	
	boolean deleteById(Integer Id);
	
	
	

}
