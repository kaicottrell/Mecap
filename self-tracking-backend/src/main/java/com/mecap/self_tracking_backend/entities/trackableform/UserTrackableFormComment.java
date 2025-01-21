package com.mecap.self_tracking_backend.entities.trackableform;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserTrackableFormComment {
	@Id
	@GeneratedValue // Sequence would be created and used to set value
	private Long id;
	private String content;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="form_entry_id")
	private UserTrackableFormEntry formEntry;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public UserTrackableFormEntry getFormEntry() {
		return formEntry;
	}
	public void setFormEntry(UserTrackableFormEntry formEntry) {
		this.formEntry = formEntry;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
