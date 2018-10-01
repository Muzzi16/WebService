package com.community.app.domain.orm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the individual database table.
 * 
 */
@Entity
@NamedQuery(name="Individual.findAll", query="SELECT i FROM Individual i")
public class Individual implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INDIVIDUAL_INDIVIDUALID_GENERATOR", sequenceName="INDIVIDUAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INDIVIDUAL_INDIVIDUALID_GENERATOR")
	@Column(name="individual_id", insertable=false, updatable=false)
	private BigDecimal individualId;

	@Column(name="adress_city")
	private String adressCity;

	@Column(name="adress_country")
	private String adressCountry;

	@Column(name="adress_line1")
	private String adressLine1;

	@Column(name="adress_line2")
	private String adressLine2;

	@Column(name="adress_postal_code")
	private String adressPostalCode;

	@Column(name="adress_state")
	private String adressState;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="email")
	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="full_name")
	private String fullName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	//bi-directional many-to-one association to CommIndvRel
	@OneToMany(mappedBy="individual")
	private List<CommIndvRel> commIndvRels;

	public Individual() {
	}

	public BigDecimal getIndividualId() {
		return individualId;
	}

	public void setIndividualId(BigDecimal individualId) {
		this.individualId = individualId;
	}

	public String getAdressCity() {
		return this.adressCity;
	}

	public void setAdressCity(String adressCity) {
		this.adressCity = adressCity;
	}

	public String getAdressCountry() {
		return this.adressCountry;
	}

	public void setAdressCountry(String adressCountry) {
		this.adressCountry = adressCountry;
	}

	public String getAdressLine1() {
		return this.adressLine1;
	}

	public void setAdressLine1(String adressLine1) {
		this.adressLine1 = adressLine1;
	}

	public String getAdressLine2() {
		return this.adressLine2;
	}

	public void setAdressLine2(String adressLine2) {
		this.adressLine2 = adressLine2;
	}

	public String getAdressPostalCode() {
		return this.adressPostalCode;
	}

	public void setAdressPostalCode(String adressPostalCode) {
		this.adressPostalCode = adressPostalCode;
	}

	public String getAdressState() {
		return this.adressState;
	}

	public void setAdressState(String adressState) {
		this.adressState = adressState;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<CommIndvRel> getCommIndvRels() {
		return this.commIndvRels;
	}

	public void setCommIndvRels(List<CommIndvRel> commIndvRels) {
		this.commIndvRels = commIndvRels;
	}

	public CommIndvRel addCommIndvRel(CommIndvRel commIndvRel) {
		getCommIndvRels().add(commIndvRel);
		commIndvRel.setIndividual(this);

		return commIndvRel;
	}

	public CommIndvRel removeCommIndvRel(CommIndvRel commIndvRel) {
		getCommIndvRels().remove(commIndvRel);
		commIndvRel.setIndividual(null);

		return commIndvRel;
	}

}