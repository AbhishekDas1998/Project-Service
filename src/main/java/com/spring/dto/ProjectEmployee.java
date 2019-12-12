package com.spring.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProjectEmp")
public class ProjectEmployee {

	@Id
	private int eId;
	private int pId;
	private String pName;

	public ProjectEmployee() {

	}

	public ProjectEmployee(int eId, int pId, String pName) {
		super();
		this.eId = eId;
		this.pId = pId;
		this.pName = pName;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
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

}
