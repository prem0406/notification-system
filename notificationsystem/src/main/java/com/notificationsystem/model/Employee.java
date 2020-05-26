package com.notificationsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToMany(mappedBy = "employees", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Subscriber> subscriptionType = new ArrayList<Subscriber>();
	
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String email;
	private String phone;
	private String officeLocation;

	
	
	public List<Subscriber> getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(List<Subscriber> subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOfficeLocation() {
		return officeLocation;
	}
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}
	
	@Override
	public boolean equals(Object anObject) {
		Employee emp = (Employee) anObject;
		return this.getId() == emp.getId();
	}
}
