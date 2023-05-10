package com.example.poc.springPoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.poc.springPoc.Entity.customer;

public interface customerRepository extends JpaRepository<customer, Integer>{

}
