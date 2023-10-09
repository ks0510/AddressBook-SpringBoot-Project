package com.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.addressbook.dto.PersonDto;
import com.addressbook.model.Person;
import com.addressbook.model.Response;
import com.addressbook.service.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	AddressBookService service;
	
	@PostMapping("/addperson")
	public ResponseEntity<Response> add(@RequestBody PersonDto person){
		return service.addPerson(person);
	}
	
	@PutMapping("/updateperson")
	public ResponseEntity<Response> update(@RequestBody PersonDto person,@RequestParam int id){
		return service.updatePerson(person,id);
	}
	
	@GetMapping("/getpersonbyname")
	public ResponseEntity<Response> getPersonByName(@RequestParam String firstName,@RequestParam String lastName){
		return service.getPersonByName(firstName,lastName);
	}
	
	@GetMapping("/getpersonbyId")
	public ResponseEntity<Response> getPersonById(@RequestParam int id){
		return service.getPersonById(id);
	}
	
	@GetMapping("/getpersonbycity")
	public List<PersonDto> getPersonByCity(@RequestParam String city) {
		return service.getPersonByCity(city);
	}
	
	@DeleteMapping("/deleteperson")
	public String delete(@RequestParam int id) {
		return service.deletePerson(id);
	}

}
