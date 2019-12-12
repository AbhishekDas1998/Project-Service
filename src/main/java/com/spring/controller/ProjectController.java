package com.spring.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.spring.dto.Project;
import com.spring.dto.ProjectEmployee;
import com.spring.exception.ProjectNotFoundException;
import com.spring.service.ProjectServiceClass;

@RestController
@RequestMapping("project")
public class ProjectController {

	@Autowired
	ProjectServiceClass ser;

	@GetMapping(path = "/getAllProjects")
	public List<Project> findAllProjects() {
		return ser.findAllProjects();
	}

	@PostMapping(path = "/addProject")
	public ResponseEntity<Project> addProject(@Valid @RequestBody Project project) throws Exception {
		Project savedProject = ser.addProject(project);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{pId}")
				.buildAndExpand(savedProject.getpId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/getProject/{pId}")
	public Project findOneProject(@PathVariable int pId) {
		Project project = ser.findOneProject(pId);
		String p=Integer.toString(project.getpId());
		if (p.isEmpty())
			throw new ProjectNotFoundException("Project Not found with pId =" + pId);
		else
			return project;

	}

	@DeleteMapping(path = "/deleteProject/{pId}")
	public String deleteProject(@PathVariable int pId) {
		Project project = ser.findOneProject(pId);
		String p=Integer.toString(project.getpId());
		if (p.isEmpty()) {
			throw new ProjectNotFoundException("Project Not found with pId =" + pId);
		} else {
			ser.deleteProject(pId);
			return "Project deleted with pId " + pId;
		}
	}

	@PutMapping(path = "/updateProject")
	public String updateProject(@RequestBody Project project) {
		ser.updateProject(project);
		return "Project updated with id " + project.getpId();
	}
	
	@PostMapping(path = "/addProjectEmp")
	public ResponseEntity<ProjectEmployee> addProjectEmployee(@Valid @RequestBody ProjectEmployee project) throws Exception {
		ProjectEmployee savedProject = ser.saveProjEmp(project);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{pId}")
				.buildAndExpand(savedProject.getpId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/getProjectEmp/{eId}")
	public ProjectEmployee findOneProjectEmployee(@PathVariable int eId) {
		ProjectEmployee project = ser.findOneProjectEmployee(eId);
		String p=Integer.toString(project.geteId());
		if (p.isEmpty())
			throw new ProjectNotFoundException("Employee with Project Not found with eId =" + eId);
		else
			return project;

	}

}
