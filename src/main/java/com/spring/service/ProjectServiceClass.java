package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Project;
import com.spring.dto.ProjectEmployee;
import com.spring.repository.ProjectEmployeeRepository;
import com.spring.repository.ProjectRepository;

@Service
public class ProjectServiceClass {

	@Autowired
	ProjectRepository repo;
	
	@Autowired
	ProjectEmployeeRepository projrepo;

	public List<Project> findAllProjects() {
		return repo.findAll();
	}

	public Project addProject(Project project) {
		return repo.save(project);
	}

	public Project findOneProject(int pId) {
		Optional<Project> projectOptional = repo.findById(pId);
		if (projectOptional.isPresent()) {
			return projectOptional.get();
		} else {
			return new Project();
		}
	}

	public void deleteProject(int pId) {

		repo.deleteById(pId);
	}

	public Project updateProject(Project project) {
		Project savedproject = new Project();
		Optional<Project> projectOptional = repo.findById(project.getpId());
		if (projectOptional.isPresent()) {
			savedproject = projectOptional.get();
			savedproject.setpName(project.getpName());
			repo.save(savedproject);
		}
		return savedproject;

	}
	
	public ProjectEmployee saveProjEmp(ProjectEmployee project)
	{
		return projrepo.save(project);
		
	}
	
	public ProjectEmployee findOneProjectEmployee(int eId) {
		Optional<ProjectEmployee> projectEmpOptional = projrepo.findById(eId);
		if (projectEmpOptional.isPresent()) {
			return projectEmpOptional.get();
		} else {
			return new ProjectEmployee();
		}
	}

}
