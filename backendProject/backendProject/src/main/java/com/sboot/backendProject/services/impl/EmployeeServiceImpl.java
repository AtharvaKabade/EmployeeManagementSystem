package com.sboot.backendProject.services.impl;

import com.sboot.backendProject.exception.ResourceNotFoundException;
import com.sboot.backendProject.model.Employee;
import com.sboot.backendProject.repository.EmployeeRepository;
import com.sboot.backendProject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getemployeeById(long id) {
       Optional<Employee> employee = employeeRepository.findById(id);
       if(employee.isPresent()){
           return employee.get();
       }else {
           throw new ResourceNotFoundException("Employee","Id",id);
       }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //check employee is present in DB
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","Id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // save existing emp to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        // check weather employee exist or not
        employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }


}
