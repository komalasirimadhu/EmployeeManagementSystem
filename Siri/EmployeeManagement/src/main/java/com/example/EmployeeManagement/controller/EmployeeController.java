package com.example.EmployeeManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagement.entity.EmployeeEntity;
import com.example.EmployeeManagement.service.EmployeeService;



@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {
	 private final EmployeeService employeeService;

	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }

	
       @PostMapping
	    public EmployeeEntity createEmployee( EmployeeEntity employee) {
	        return employeeService.saveEmployee(employee);
	    }

	   
	    @GetMapping("/{id}")
	    public List<EmployeeEntity>  getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	    // Get employee by id
	    @PostMapping("/{id}")
	    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
	        return employeeService.getEmployeeById(id);
	    }

	    // Update employee
	    @PutMapping("/{id}")
	    public EmployeeEntity updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeEntity employee) {
	        return employeeService.updateEmployee(id, employee);
	    }

	    // Delete employee
	    @DeleteMapping("/{id}")
	    public String deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return "Employee deleted successfully!";
	    }
	}


