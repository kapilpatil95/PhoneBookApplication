package com.patilIT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patilIT.model.Contact;
import com.patilIT.repository.ContactRepo;


@Service
public class ContactServiceImpl implements ContactServiceI {
	
	@Autowired
	private ContactRepo contactRepo;

	@Override
	public boolean saveContact(Contact contact) {
		
		Contact saveContact = contactRepo.save(contact);
		
		if(saveContact!=null) {
			
			return true;
			
		}else {
			return false;
			
		}
		
		
	}

	@Override
	public List<Contact> getAllContact() {
		
		List<Contact> findAll = contactRepo.findAll();
		
		return findAll;
	}

	@Override
	public Contact getContactById(Integer Id) {
		
		Contact findById = contactRepo.findById(Id).get();
		return findById;
	}

	@Override
	public boolean updateContact(Contact contact) {
		
      Contact save=contactRepo.save(contact);
      
      if(save==null) {
    	  return false;
    	  
      }
		
		return true;
	}

	@Override
	public boolean deleteById(Integer Id) {
		
		boolean existsById = contactRepo.existsById(Id);
		
		if(existsById) {
			contactRepo.deleteById(Id);	
			return true;
		}else {
			return false;
			
		}
		
	}

}
