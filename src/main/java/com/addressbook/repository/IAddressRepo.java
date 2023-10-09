package com.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.addressbook.model.Address;
import com.addressbook.model.Person;

public interface IAddressRepo extends JpaRepository<Address,Integer> {
	
	public Person findByCity(String city);

}
