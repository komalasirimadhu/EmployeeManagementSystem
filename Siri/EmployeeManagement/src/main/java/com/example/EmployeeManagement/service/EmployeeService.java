package com.example.EmployeeManagement.service;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagement.entity.EmployeeEntity;
import com.example.EmployeeManagement.repository.EmployeeRepository;



import java.util.List;
@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public  List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeDetails) {
        EmployeeEntity employee = getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDepartment(employeeDetails.getDepartment());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

   
        
}
