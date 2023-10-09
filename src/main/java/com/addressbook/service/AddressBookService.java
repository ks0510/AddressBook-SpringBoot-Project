package com.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.addressbook.dto.PersonDto;
import com.addressbook.model.Address;
import com.addressbook.model.Person;
import com.addressbook.model.Response;
import com.addressbook.repository.IAddressRepo;
import com.addressbook.repository.IPersonRepo;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	IPersonRepo repo;

	@Autowired
	ModelMapper mapper;

	@Autowired
	Response response;

	@Autowired
	IAddressRepo addressRepo;

	@Override
	public ResponseEntity<Response> addPerson(PersonDto person) {
		Person person1 = mapper.map(person, Person.class);
		repo.save(person1);
		response.setObject(person);
		response.setMsg("Person Details added successfully");
		return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Response> updatePerson(PersonDto person, int id) {
		Person person1 = repo.findById(id);
		if (person1 != null) {
			Person person2 = mapper.map(person,Person.class);
			person2.setPersonId(id);
			repo.save(person2);
			response.setObject(person);
			response.setMsg("Person Details updated successfully");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		} else {

			response.setMsg("Person Not found");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}

	}

	@Override
	public ResponseEntity<Response> getPersonByName(String firstName, String lastName) {
		Person person = repo.findByFirstNameAndLastName(firstName, lastName);
		if (person != null) {
			PersonDto person1 = mapper.map(person, PersonDto.class);
			response.setObject(person1);
			response.setMsg("Person found with given name");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		} else

		{

			response.setMsg("Person Not found please enter correct name");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}

	}

	@Override
	public ResponseEntity<Response> getPersonById(int id) {
		Person person = repo.findById(id);
		if (person != null) {
			response.setObject(person);
			response.setMsg("Person found with given id");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		} else {

			response.setMsg("Person Not found please enter correct person id");
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}

	}

	@Override
	public List<PersonDto> getPersonByCity(String city) {
		List<Person> list = repo.findAll();
		List<PersonDto> personList = new ArrayList<>();
		for (Person p : list) {
			List<Address> address = p.getAddress();
			for (Address a : address) {
				if (city.equals(a.getCity())) {
					PersonDto person = mapper.map(p,PersonDto.class);
					personList.add(person);
				}
			}
		}
		return personList;
	}

	@Override
	public String deletePerson(int id) {
		repo.deleteById(id);
		return "Person deleted successfully";
	}

}
