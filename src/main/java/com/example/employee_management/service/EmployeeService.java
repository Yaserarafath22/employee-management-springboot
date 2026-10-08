package com.example.employee_management.service;

import com.example.employee_management.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.example.employee_management.service.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
}

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }
        public List<Employee> searchByName(String name) {
    return employeeRepository.findByNameContainingIgnoreCase(name);
        
    }
}