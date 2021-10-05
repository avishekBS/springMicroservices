package com.codeolate.employee.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeolate.employee.api.model.Address;
import com.codeolate.employee.api.repositories.AddressRepository;

@Service
public class AddAddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public String addAddress(Address address) {
		Address save = addressRepository.save(address);
		
		if (save.getId() !=0) {
			return "Address details saved!!";
		}
		return "Address details not saved!!";
	}
}
