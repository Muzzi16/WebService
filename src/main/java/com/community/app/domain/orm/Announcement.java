package com.community.app.domain.orm;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the announcement database table.
 * 
 */
@Entity
@NamedQuery(name="Announcement.findAll", query="SELECT a FROM Announcement a")
public class Announcement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANNOUNCEMENT_ANNOUNCEMENTID_GENERATOR", sequenceName="ANNOUNCEMENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANNOUNCEMENT_ANNOUNCEMENTID_GENERATOR")
	@Column(name="announcement_id", insertable=false, updatable=false)
	private int announcementId;
	
	@Column(name="individual_id")
	private int individual_id;
	

	@Temporal(TemporalType.DATE)
	@Column(name="announcement_date")
	private Date announcementDate;

	@Column(name="announcement_desc")
	private String announcementDesc;
	//bi-directional many-to-one association to Community
	@ManyToOne
	@JoinColumn(name="community_id", referencedColumnName="community_id")
	private Community community;

	public Announcement() {
	}

	public int getIndividual_id() {
		return individual_id;
	}

	public void setIndividual_id(int individual_id) {
		this.individual_id = individual_id;
	}

	public Date getAnnouncementDate() {
		return this.announcementDate;
	}

	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}

	public String getAnnouncementDesc() {
		return this.announcementDesc;
	}

	public void setAnnouncementDesc(String announcementDesc) {
		this.announcementDesc = announcementDesc;
	}

	public int getAnnouncementId() {
		return this.announcementId;
	}

	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}

	public Community getCommunity() {
		return this.community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

}