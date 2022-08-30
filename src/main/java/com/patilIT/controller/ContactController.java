package com.patilIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patilIT.model.Contact;
import com.patilIT.service.ContactServiceI;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServiceI contactServiceI;
	
	@PostMapping(value="/savecontact",consumes = "application/json")
	public ResponseEntity<String>saveContact(@RequestBody Contact contact){
		
		boolean saveContact = contactServiceI.saveContact(contact);
		
		if(saveContact==true) {
			
			String msg="Contact Saved Succesfully...";
			
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}else {
			
			String msg="Contact Not Saved!!!";
			
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
		
		
		
	}
	@GetMapping(value="/getAll",produces = "application/json")
	public ResponseEntity<List<Contact>>getAllContact(){
		
	
		List<Contact> allContact = contactServiceI.getAllContact();
		
		if(allContact!=null) {
			
			return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
			
		}else {
			return new ResponseEntity<List<Contact>>(allContact,HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping(value="/getById/{Id}",produces = "application/json")
	public ResponseEntity<String>getById(@PathVariable Integer Id){
		
     Contact byId=contactServiceI.getContactById(Id);
		
		return new ResponseEntity<String>(HttpStatus.OK);
		
	}
	@PutMapping(value="/update",consumes = "application/json")
	public ResponseEntity<String>updateContact(@RequestBody Contact contact){
		
		boolean updateContact = contactServiceI.updateContact(contact);
		
		if(updateContact==true) {
			
			String msg="Contact updated Succesfully";
			
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
		}else {
			
			String msg="Contact Not Updated!!!!";
			
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
			
		}
	
			
		}
	@DeleteMapping(value="/delete/{Id}",produces = "application/json")
	public ResponseEntity<String>deleteContactByid(@PathVariable Integer Id){
		
		boolean deleteById = contactServiceI.deleteById(Id);
		
		if(deleteById) {
			
			String msg="Record deleted Succesfully";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
		}else {
			String msg="Record not deleted";
			return  new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
			
		}
		
		
		
	}
			
		
		
		
	}


