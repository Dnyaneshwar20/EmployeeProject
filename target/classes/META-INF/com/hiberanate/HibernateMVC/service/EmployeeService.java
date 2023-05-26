package com.hiberanate.HibernateMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberanate.HibernateMVC.dao.EmployeeDAO;
import com.hiberanate.HibernateMVC.dto.EmployeeDTO;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeDTO insert(String name, String email, String designation, String username, String password) {
		// TODO Auto-generated method stub
		EmployeeDTO employee=dao.insertData(name, email, designation, username, password);
		return employee;
	}
	

		
	}
	
	

