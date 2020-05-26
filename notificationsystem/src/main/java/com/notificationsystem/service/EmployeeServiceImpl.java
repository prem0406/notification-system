package com.notificationsystem.service;

import org.springframework.stereotype.Service;

import com.notificationsystem.dto.EmployeeRegistrationDTO;
import com.notificationsystem.model.Employee;
import com.notificationsystem.repository.EmployeeRepository;
import com.notificationsystem.transformer.EmployeeRegistrationDTOTransformer;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeRegistrationDTOTransformer transformer;
	EmployeeRepository employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRegistrationDTOTransformer transformer, EmployeeRepository employeeRepo) {
		this.transformer = transformer;
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee saveEmployee(EmployeeRegistrationDTO employeeDto) {
		Employee employee = this.transformer.apply(employeeDto);
		return employeeRepo.save(employee);
	
	}

	@Override
	public Employee getEmployeeByID(Long id) {
		
		return employeeRepo.getOne(id);
	}

}
