package com.notificationsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subscribers")
public class Subscriber {
	
	@Id
	private Long notificationTypeId;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	    @JoinTable(
	            name = "Employee_Subscriber",
	            joinColumns = {@JoinColumn(name = "notification_type_id")},
	            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
	   )
	private List<Employee> employees = new ArrayList<Employee>();

	public Subscriber() {
		
	}

	
	
	public Subscriber(Long notificationTypeId, List<Employee> employees) {
		this.notificationTypeId = notificationTypeId;
		this.employees = employees;
	}



	public Long getNotificationTypeId() {
		return notificationTypeId;
	}

	public void setNotificationTypeId(Long notificationTypeId) {
		this.notificationTypeId = notificationTypeId;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public boolean equals(Object anObject) {
		Subscriber sub = (Subscriber) anObject;
		return this.getNotificationTypeId() == sub.getNotificationTypeId();
	}
}
