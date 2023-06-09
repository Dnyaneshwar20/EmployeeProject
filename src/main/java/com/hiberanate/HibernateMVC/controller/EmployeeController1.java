package com.hiberanate.HibernateMVC.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.hiberanate.HibernateMVC.dao.EmployeeDAO;
import com.hiberanate.HibernateMVC.dto.EmployeeDTO;


@Controller
public class EmployeeController1 {

	@Autowired
	private EmployeeDAO service;

	@GetMapping("/insert")
	public String insertPage(ModelMap map, @SessionAttribute(name = "login", required = false) EmployeeDTO login) {
		if (login != null) {
			return "insertEmployee";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@PostMapping("/insert")
	public String insertData(@RequestParam String name, @RequestParam String email, @RequestParam String designation,
			@RequestParam String userName, @RequestParam String password, ModelMap map,
			@SessionAttribute(name = "login", required = false) EmployeeDTO login) {
		if (login != null) {
			EmployeeDTO employee = service.insert(name, email, designation, userName, password);
			if (employee != null) {
				map.addAttribute("msg", "Employee inserted successfully..!!");
				map.addAttribute("employee", employee);
				return "insertEmployee";
			}
			return "insertEmployee";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";

	}

	@GetMapping("/search")
	public String searchPage(ModelMap map, @SessionAttribute(name = "login", required = false) EmployeeDTO login) {
		if (login != null) {
			return "searchEmployee";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@PostMapping("/search")
	public String searchData(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) EmployeeDTO login) {
		if (login != null) {
			EmployeeDTO employee = service.search(id);
			if (employee != null) {
				map.addAttribute("employee", employee);
			} else {
				map.addAttribute("msg", "Employee record not found..!!");
			}

			return "searchEmployee";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@GetMapping("/remove")
	public String removePage(ModelMap map, @SessionAttribute(name = "login", required = false) EmployeeDTO login) {
		if (login != null) {
			List<EmployeeDTO> employees = service.findAllEmployees();
			map.addAttribute("employeeList", employees);

			return "removeEmployee";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@PostMapping("/remove")
	public String removeData(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) EmployeeDTO login) {
		if (login != null) {
			service.remove(id);
			map.addAttribute("msg", "Employee removed successfully..!!");

			List<EmployeeDTO> employees = service.findAllEmployees();
			map.addAttribute("employeeList", employees);

			return "removeEmployee";
		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@GetMapping("/update")
	public String updatePage(ModelMap map, @SessionAttribute(name = "login", required = false) EmployeeDTO login) {
		if (login != null) {
			List<EmployeeDTO> employees = service.findAllEmployees();
			map.addAttribute("employees", employees);
			return "updateEmployee";

		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@PostMapping("/update")
	public String updateData(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) EmployeeDTO login) {
		if (login != null) {
			EmployeeDTO employee = service.search(id);
			if (employee != null) {
				map.addAttribute("employee", employee);
			}
			map.addAttribute("msg", "Employee record not found..!!");
			List<EmployeeDTO> employees = service.findAllEmployees();
			map.addAttribute("employees", employees);
			return "updateEmployee";

		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@PostMapping("/updateData")
	public String update(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam String designation, @RequestParam String userName, @RequestParam String password,
			ModelMap map, @SessionAttribute(name = "login", required = false) EmployeeDTO login) {
		if (login != null) {
			service.update(id, name, email, designation, userName, password);
			map.addAttribute("msg", "Employee updated successfully..!!");

			List<EmployeeDTO> employees = service.findAllEmployees();
			map.addAttribute("employees", employees);
			return "updateEmployee";

		}
		map.addAttribute("msg", "Please login and try again..!!");
		return "loginPage";
	}

	@GetMapping("/login")
	public String login() {
		return "loginPage";
	}

	@PostMapping("/login")
	public String loginData(HttpSession session, HttpServletRequest request, @RequestParam String userName,
			@RequestParam String password, ModelMap map) {

		EmployeeDTO employee = service.login(userName, password);
		if (employee != null) {
			session = request.getSession();
			session.setAttribute("login", employee);
			session.setMaxInactiveInterval(300);
			return "homePage";
		}
		map.addAttribute("msg", "Invalid username or password..!!");
		return "loginPage";
	}

	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("msg", "Successfully logged out..!!");
		return "loginPage";
	}
}

