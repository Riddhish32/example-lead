package com.order.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.demo.model.Lead;

@Repository
public interface LeadTableRepository extends JpaRepository<Lead, Integer>{
	List<Lead> findByMobileNumber(Long mobileNumber);

}
