package com.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.addressbook.model.Person;

public interface IPersonRepo extends JpaRepository<Person,Integer> {
	
	public Person findById(int id);
	
	public Person findByFirstNameAndLastName(String firstName,String lastName);
	
	public List<Person> findAll();

}
