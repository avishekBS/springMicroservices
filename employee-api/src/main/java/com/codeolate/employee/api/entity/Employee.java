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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Employee {
	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@NotBlank(message = "Please add name for request")
	@NotEmpty(message = "Name field cant be empty")
	private String name;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	private Date dateOfBirth;
	
	@NotBlank
	//@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String panNumber;
	
	@NotBlank
	@Size(min = 12, max = 14)
	private String adharNumber;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(value = TemporalType.DATE)
	private Date joiningDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_employee_id", referencedColumnName = "id")
	private List<Address> listofAddress;
}
