package com.hiberanate.HibernateMVC.service;

import com.hiberanate.HibernateMVC.dto.EmployeeDTO;

public interface EmployeeServiceInterface {
	
	EmployeeDTO insert(String name,String email,String designation,String username,String password);

}
