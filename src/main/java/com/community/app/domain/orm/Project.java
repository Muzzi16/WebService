package com.community.app.domain.orm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the projects database table.
 * 
 */
@Entity
@Table(name="projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROJECTS_PROJECTID_GENERATOR", sequenceName="PROJECT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROJECTS_PROJECTID_GENERATOR")
	@Column(name="project_id")
	private BigDecimal projectId;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="project_budget")
	private BigDecimal projectBudget;

	@Column(name="project_disc")
	private String projectDisc;


	@Column(name="project_name")
	private String projectName;

	@Column(name="project_status")
	private String projectStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to Community
	@ManyToOne
	@JoinColumn(name="community_id", referencedColumnName="community_id")
	private Community community;

	public Project() {
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getProjectBudget() {
		return this.projectBudget;
	}

	public void setProjectBudget(BigDecimal projectBudget) {
		this.projectBudget = projectBudget;
	}

	public String getProjectDisc() {
		return this.projectDisc;
	}

	public void setProjectDisc(String projectDisc) {
		this.projectDisc = projectDisc;
	}

	public BigDecimal getProjectId() {
		return this.projectId;
	}

	public void setProjectId(BigDecimal projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStatus() {
		return this.projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Community getCommunity() {
		return this.community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

}