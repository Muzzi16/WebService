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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the calender database table.
 * 
 */
@Entity
@NamedQuery(name = "Calender.findAll", query = "SELECT c FROM Calender c")
public class Calender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CALENDER_CALENDERID_GENERATOR", sequenceName = "CALENDER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CALENDER_CALENDERID_GENERATOR")
	@Column(name = "calender_id")
	private BigDecimal calenderId;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "event_desc")
	private String eventDesc;

	@Column(name = "event_location")
	private String eventLocation;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;

	private String status;

	// bi-directional many-to-one association to Community
	@ManyToOne
	@JoinColumn(name = "community_id", referencedColumnName = "community_id")
	private Community community;

	public Calender() {
	}

	public BigDecimal getCalenderId() {
		return this.calenderId;
	}

	public void setCalenderId(BigDecimal calenderId) {
		this.calenderId = calenderId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEventDesc() {
		return this.eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getEventLocation() {
		return this.eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Community getCommunity() {
		return this.community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

}