package com.addressbook.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address>address;

}
