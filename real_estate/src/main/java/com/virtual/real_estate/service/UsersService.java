package com.virtual.real_estate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("users")
public class UsersService {

	public ArrayList<String> users;
	
	public void userAdd(String email) {
		if(users == null) {
			users = new ArrayList<String>();
		}
		System.out.println("users ==== " + email);
		users.add(email);
	}
	
	public List<String> userAll() {
		return users;
	}
	
	
}
