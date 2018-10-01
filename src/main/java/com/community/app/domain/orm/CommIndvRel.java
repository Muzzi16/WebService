package com.community.app.domain.orm;

import java.io.Serializable;
import java.math.BigDecimal;

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

/**
 * The persistent class for the comm_indv_rel database table.
 * 
 */
@Entity
@Table(name = "comm_indv_rel")
@NamedQuery(name = "CommIndvRel.findAll", query = "SELECT c FROM CommIndvRel c")
public class CommIndvRel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COMM_INDV_REL_COMMINDVRELID_GENERATOR", sequenceName = "COMMINDVREL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMM_INDV_REL_COMMINDVRELID_GENERATOR")
	@Column(name = "comm_indv_rel_id")
	private BigDecimal commIndvRelId;

	@Column(name = "rels_status")
	private String relsStatus;

	@Column(name = "role_type")
	private String roleType;

	// bi-directional many-to-one association to Community
	@ManyToOne
	@JoinColumn(name = "community_id", referencedColumnName = "community_id")
	private Community community;

	// bi-directional many-to-one association to Individual
	@ManyToOne
	@JoinColumn(name = "individual_id", referencedColumnName = "individual_id")
	private Individual individual;

	public CommIndvRel() {
	}

	public BigDecimal getCommIndvRelId() {
		return this.commIndvRelId;
	}

	public void setCommIndvRelId(BigDecimal commIndvRelId) {
		this.commIndvRelId = commIndvRelId;
	}

	public String getRelsStatus() {
		return this.relsStatus;
	}

	public void setRelsStatus(String relsStatus) {
		this.relsStatus = relsStatus;
	}

	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public Community getCommunity() {
		return this.community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public Individual getIndividual() {
		return this.individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

}