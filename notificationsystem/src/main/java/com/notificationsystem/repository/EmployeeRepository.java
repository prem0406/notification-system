package com.notificationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notificationsystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
