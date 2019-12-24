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
		return ser.findOneProject(pId);

	}

	@GetMapping(path = "/getProjectbyName/{pName}")
	public Project findOneProjectbyName(@PathVariable String pName) {
		return ser.findProjectByName(pName);
	}

	@DeleteMapping(path = "/deleteProject/{pId}")
	public String deleteProject(@PathVariable int pId) {
			ser.deleteProject(pId);
			return "Project deleted with pId " + pId;
	}

	@PutMapping(path = "/updateProject")
	public String updateProject(@RequestBody Project project) {
		ser.updateProject(project);
		return "Project updated with id " + project.getpId();
	}

}
