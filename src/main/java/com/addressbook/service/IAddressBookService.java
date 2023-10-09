package com.addressbook.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.addressbook.dto.PersonDto;
import com.addressbook.model.Person;
import com.addressbook.model.Response;

public interface IAddressBookService {
	
	public ResponseEntity<Response> addPerson(PersonDto person);
	
	public ResponseEntity<Response> updatePerson(PersonDto person,int id);
	
	public ResponseEntity<Response> getPersonByName(String firstName,String lastName);
	
	public ResponseEntity<Response> getPersonById(int id);
	
	public List<PersonDto> getPersonByCity(String city);
	
	public String deletePerson(int id);
	
	

}
