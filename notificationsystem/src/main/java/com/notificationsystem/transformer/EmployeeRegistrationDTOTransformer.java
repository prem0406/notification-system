package com.notificationsystem.transformer;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.notificationsystem.dto.EmployeeRegistrationDTO;
import com.notificationsystem.model.Employee;

@Component
public class EmployeeRegistrationDTOTransformer implements Function<EmployeeRegistrationDTO, Employee> {

	@Override
	public Employee apply(EmployeeRegistrationDTO dto) {
		Employee employee = new Employee();
		Optional.ofNullable(dto.getFirstName()).ifPresent(param -> employee.setFirstName(param));
		Optional.ofNullable(dto.getLastName()).ifPresent(param -> employee.setLastName(param));
		Optional.ofNullable(dto.getEmail()).ifPresent(param -> employee.setEmail(param));
		Optional.ofNullable(dto.getPhone()).ifPresent(param -> employee.setPhone(param));
		Optional.ofNullable(dto.getOfficeLocation()).ifPresent(param -> employee.setOfficeLocation(param));
		return employee;
	}

}
