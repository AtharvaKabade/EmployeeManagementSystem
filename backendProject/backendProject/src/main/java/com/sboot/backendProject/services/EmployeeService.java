package com.sboot.backendProject.services;

import com.sboot.backendProject.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getemployeeById(long id);
    Employee updateEmployee(Employee employee,long id);
    void deleteEmployee(long id);
}
