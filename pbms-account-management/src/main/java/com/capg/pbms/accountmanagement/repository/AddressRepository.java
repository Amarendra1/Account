package com.capg.pbms.accountmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.pbms.accountmanagement.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
