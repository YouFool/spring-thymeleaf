package org.jlnh.employeecrud.controller;

import java.util.List;

import org.jlnh.employeecrud.entity.EmployeeEntity;
import org.jlnh.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<EmployeeEntity> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		model.addAttribute("employee", employeeEntity);
		return "employees/employee-form";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("id") int id, Model model) {
		EmployeeEntity employeeEntity = employeeService.findById(id);
		model.addAttribute("employee", employeeEntity);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") EmployeeEntity employeeEntity) {
		employeeService.save(employeeEntity);
		return "redirect:/employees/list";
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
	

}
