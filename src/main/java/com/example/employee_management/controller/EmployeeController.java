package com.example.employee_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.employee_management.Employee;
import com.example.employee_management.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
public List<Employee> getAllEmployees(@RequestParam(required = false) String name) {
    if (name != null) {
        return employeeService.searchByName(name);
    }
    return employeeService.getAllEmployees();
}
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
    }
}