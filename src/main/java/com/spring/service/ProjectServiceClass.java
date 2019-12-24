package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dto.Project;
import com.spring.exception.ProjectNotFoundException;
import com.spring.repository.ProjectRepository;

@Service
public class ProjectServiceClass {

	@Autowired
	ProjectRepository repo;

	public List<Project> findAllProjects() {
		
		List<Project> project= repo.findAll();
		if(project.isEmpty())
		{
			throw new ProjectNotFoundException("Project not found");
		}
		return project;
	}

	public Project addProject(Project project) {
		return repo.save(project);
	}

	public Project findOneProject(int pId) {
		Optional<Project> projectOptional = repo.findById(pId);
		if (projectOptional.isPresent()) {
			return projectOptional.get();
		} else {
			throw new ProjectNotFoundException("Project Not found with id= "+pId);
		}
	}

	public void deleteProject(int pId) {

		Optional<Project> projectOptional = repo.findById(pId);
		if (projectOptional.isPresent()) {
		repo.deleteById(pId);
		}
		else {
			throw new ProjectNotFoundException("Project Not found with id= "+pId);
		}
		
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
	
	public Project findProjectByName(String pName)
	{
		return repo.findProjectByName(pName);
		
	}

}
