package com.notificationsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "event-subscribers")
public class EventSubscriber {
	
	@Id
	private Long id;
	
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee")
	private Employee employee;

	public EventSubscriber() {
		
	}
	
	public EventSubscriber(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
