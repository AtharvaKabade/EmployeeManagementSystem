package com.sboot.backendProject.repository;

import com.sboot.backendProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
