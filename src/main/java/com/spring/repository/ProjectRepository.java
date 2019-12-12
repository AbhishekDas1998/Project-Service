package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.dto.Project;
import com.spring.dto.ProjectEmployee;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	
	
}
