package com.hiberanate.HibernateMVC.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hiberanate.HibernateMVC.dto.EmployeeDAOInterface;
import com.hiberanate.HibernateMVC.dto.EmployeeDTO;


@Repository
public class EmployeeDAO implements EmployeeDAOInterface {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	public static void openConnections() {
		factory = Persistence.createEntityManagerFactory("wejm3");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	public static void closeConnections() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
	}

	@Override
	public EmployeeDTO insert(String name, String email, String designation, String userName, String password) {

		openConnections();

		transaction.begin();

		EmployeeDTO employee = new EmployeeDTO();
		employee.setName(name);
		employee.setEmail(email);
		employee.setDesgination(designation);
		employee.setUserName(userName);
		employee.setPassword(password);

		manager.persist(employee);

		transaction.commit();

		closeConnections();

		return employee;
	}

	@Override
	public void remove(int id) {
		openConnections();

		transaction.begin();

		EmployeeDTO employee = manager.find(EmployeeDTO.class, id);

		manager.remove(employee);

		transaction.commit();

		closeConnections();

	}

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		openConnections();

		transaction.begin();

		String jpql = "from EmployeeDTO";

		Query query = manager.createQuery(jpql);
		List<EmployeeDTO> list = query.getResultList();

		transaction.commit();

		closeConnections();

		return list;
	}

	@Override
	public EmployeeDTO search(int id) {
		openConnections();

		transaction.begin();

		EmployeeDTO find = manager.find(EmployeeDTO.class, id);
		transaction.commit();
		closeConnections();

		return find;
	}

	@Override
	public EmployeeDTO login(String userName, String password) {
		openConnections();
		transaction.begin();
		String jpql = "from EmployeeDTO where userName ='" + userName + "' and password = '" + password + "'";
		Query createQuery = manager.createQuery(jpql);
		try {
			EmployeeDTO employee = (EmployeeDTO) createQuery.getSingleResult();
			if (employee != null) {
				transaction.commit();
				closeConnections();
				return employee;
			}
		} catch (Exception e) {
			closeConnections();
			return null;
		}
		return null;
	}

	@Override
	public void update(int id, String name, String email, String designation, String userName, String password) {
		openConnections();
		transaction.begin();
		EmployeeDTO employee = manager.find(EmployeeDTO.class, id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setDesgination(designation);
		employee.setUserName(userName);
		employee.setPassword(password);
		manager.persist(employee);
		transaction.commit();
		closeConnections();

	}

}
	
	


