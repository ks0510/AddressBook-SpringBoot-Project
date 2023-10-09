package com.addressbook.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.addressbook.model.Address;

import lombok.Data;

@Component
@Data
public class PersonDto {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private List<Address>address;


}
