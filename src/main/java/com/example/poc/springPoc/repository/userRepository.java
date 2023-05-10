package com.example.poc.springPoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.poc.springPoc.Entity.user;

public interface userRepository extends JpaRepository<user, Integer>{

}
