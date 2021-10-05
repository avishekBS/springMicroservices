package com.codeolate.employee.api.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth;
	
	private String panNumber;
	
	private String adharNumber;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	private Date joiningDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_employee_id", referencedColumnName = "id")
	private List<Address> listofAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public List<Address> getListofAddress() {
		return listofAddress;
	}

	public void setListofAddress(List<Address> listofAddress) {
		this.listofAddress = listofAddress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", panNumber=" + panNumber
				+ ", adharNumber=" + adharNumber + ", joiningDate=" + joiningDate
				+ "]";
	}
}
