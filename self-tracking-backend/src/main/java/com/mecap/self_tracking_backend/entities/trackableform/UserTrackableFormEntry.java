package com.mecap.self_tracking_backend.entities.trackableform;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserTrackableFormEntry {
	@Id
	@GeneratedValue // Sequence would be created and used to set value
	private Long id;
	private TrackableFormStatus status;
	private Date date;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="form_template_id")
	private UserTrackableFormTemplate formTemplate;
    public UserTrackableFormEntry() { }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TrackableFormStatus getStatus() {
		return status;
	}
	public void setStatus(TrackableFormStatus status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserTrackableFormTemplate getFormTemplate() {
		return formTemplate;
	}
	public void setFormTemplate(UserTrackableFormTemplate formTemplate) {
		this.formTemplate = formTemplate;
	}
	
	
}

enum TrackableFormStatus{
	DRAFT, SUBMITTED
}
