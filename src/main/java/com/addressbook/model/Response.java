package com.addressbook.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Response {
	
	private Object object;
	private String msg;

}
