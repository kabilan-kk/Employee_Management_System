package com.Empoyee_Application.Employee_Management_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Employee_Service {
    @Autowired
    Employee_Repository employeeRepository;

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Save an employee
    public Employee saveEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    // Update employee by id
    public Employee updateEmployee(Long id, Employee updatedEntity) {
        Optional<Employee> existingEntityOptional = employeeRepository.findById(id);

        if (existingEntityOptional.isPresent()) {
            Employee existingEntity = existingEntityOptional.get();
            existingEntity.setFirstName(updatedEntity.getFirstName());
            existingEntity.setLastName(updatedEntity.getLastName());
            existingEntity.setEmail(updatedEntity.getEmail());

            return employeeRepository.save(existingEntity);
        } else {
            throw new RuntimeException("Employee not found!!! Please enter a valid Id!");
        }
    }

    // Delete employee by id
    public String deleteEmployeeById(Long id) {
        Optional<Employee> empOptional = employeeRepository.findById(id);

        if (empOptional.isPresent()) {
            Employee emp = empOptional.get();
            employeeRepository.deleteById(id);
            return "Deleted: " + emp.getFirstName() + " " + emp.getLastName();
        } else {
            throw new RuntimeException("Employee not found!!! Please enter a valid Id!");
        }
    }
}
