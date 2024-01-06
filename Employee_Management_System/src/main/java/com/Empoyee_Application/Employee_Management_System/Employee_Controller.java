package com.Empoyee_Application.Employee_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Employee")
public class Employee_Controller {

    @Autowired
    Employee_Service employeeService;

    // Show all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Save an employee
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    // Update an employee by id
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee updatedEntity = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(updatedEntity);
    }

    // Delete an employee by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        String message = employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok(message);
    }
}
