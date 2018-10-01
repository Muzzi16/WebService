package com.community.app.domain.orm;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the community database table.
 * 
 */
@Entity
@NamedQuery(name="Community.findAll", query="SELECT c FROM Community c")
public class Community implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMMUNITY_COMMUNITYID_GENERATOR", sequenceName="COMMUNITY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMMUNITY_COMMUNITYID_GENERATOR")
	@Column(name="community_id", insertable=false, updatable=false)
	private int community_id;

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

	@Column(name="community_name")
	private String communityName;

	@Column(name="community_type")
	private String communityType;

	private String contact;

	//bi-directional many-to-one association to Announcement
	@OneToMany(mappedBy="community")
	private List<Announcement> announcements;

	//bi-directional many-to-one association to Calender
	@OneToMany(mappedBy="community")
	private List<Calender> calenders;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="community")
	private List<Project> projects;

	//bi-directional many-to-one association to CommIndvRel
	@OneToMany(mappedBy="community")
	private List<CommIndvRel> commIndvRels;

	public Community() {
	}

	public int getCommunity_id() {
		return community_id;
	}

	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
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

	public String getCommunityName() {
		return this.communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getCommunityType() {
		return this.communityType;
	}

	public void setCommunityType(String communityType) {
		this.communityType = communityType;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Announcement> getAnnouncements() {
		return this.announcements;
	}

	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

	public Announcement addAnnouncement(Announcement announcement) {
		getAnnouncements().add(announcement);
		announcement.setCommunity(this);

		return announcement;
	}

	public Announcement removeAnnouncement(Announcement announcement) {
		getAnnouncements().remove(announcement);
		announcement.setCommunity(null);

		return announcement;
	}

	public List<Calender> getCalenders() {
		return this.calenders;
	}

	public void setCalenders(List<Calender> calenders) {
		this.calenders = calenders;
	}

	public Calender addCalender(Calender calender) {
		getCalenders().add(calender);
		calender.setCommunity(this);

		return calender;
	}

	public Calender removeCalender(Calender calender) {
		getCalenders().remove(calender);
		calender.setCommunity(null);

		return calender;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setCommunity(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setCommunity(null);

		return project;
	}

	public List<CommIndvRel> getCommIndvRels() {
		return this.commIndvRels;
	}

	public void setCommIndvRels(List<CommIndvRel> commIndvRels) {
		this.commIndvRels = commIndvRels;
	}

	public CommIndvRel addCommIndvRel(CommIndvRel commIndvRel) {
		getCommIndvRels().add(commIndvRel);
		commIndvRel.setCommunity(this);

		return commIndvRel;
	}

	public CommIndvRel removeCommIndvRel(CommIndvRel commIndvRel) {
		getCommIndvRels().remove(commIndvRel);
		commIndvRel.setCommunity(null);

		return commIndvRel;
	}

}