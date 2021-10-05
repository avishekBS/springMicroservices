package com.codeolate.employee.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codeolate.employee.api.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
