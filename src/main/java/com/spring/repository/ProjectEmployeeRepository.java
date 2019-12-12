package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.dto.ProjectEmployee;

public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Integer> {

	
	
}
