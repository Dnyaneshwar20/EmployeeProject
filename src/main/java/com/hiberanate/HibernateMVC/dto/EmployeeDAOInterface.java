package com.hiberanate.HibernateMVC.dto;

import java.util.List;

import com.hiberanate.HibernateMVC.dao.EmployeeDAO;


public interface EmployeeDAOInterface {

	EmployeeDTO insert(String name, String email, String designation, String userName, String password);
	void remove(int id);

	List<EmployeeDTO> findAllEmployees();

	EmployeeDTO search(int id);

	EmployeeDTO login(String userName, String password);

	void update(int id, String name, String email, String designation, String userName, String password);

}