package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dto.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	Project findProjectByName(String pName);
}
