package com.spring.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
@NamedQuery(name = "Project.findProjectByName", query = "SELECT p FROM Project p WHERE p.pName = :pName")
public class Project {

	@Id
	private int pId;
	private String pName;

	public Project() {

	}

	public Project(int pId, String pName) {
		super();
		this.pId = pId;
		this.pName = pName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Override
	public String toString() {
		return "Project [pId=" + pId + ", pName=" + pName + "]";
	}

}
