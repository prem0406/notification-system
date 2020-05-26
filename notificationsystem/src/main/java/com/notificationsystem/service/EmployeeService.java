package com.notificationsystem.service;

import com.notificationsystem.dto.EmployeeRegistrationDTO;
import com.notificationsystem.model.Employee;

public interface EmployeeService {
	public Employee saveEmployee(EmployeeRegistrationDTO employeeDto);
	public Employee getEmployeeByID(Long id);
}
