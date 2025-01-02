package com.mecap.self_tracking_backend.entities.trackableform;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserTrackableFormLineResponse {
	@Id
	@GeneratedValue // Sequence would be created and used to set value
	private Long id;
	private Float value; // make nullable? either this or customSelectedOption must be non-null
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="custom_selected_option_id")
	private UserCustomTrackableFormLineOption customSelectedOption;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="form_line_id")
	private UserTrackableFormLine formLine;
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="form_entry_id")
	private UserTrackableFormEntry formEntry;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public UserCustomTrackableFormLineOption getCustomSelectedOption() {
		return customSelectedOption;
	}
	public void setCustomSelectedOption(UserCustomTrackableFormLineOption customSelectedOption) {
		this.customSelectedOption = customSelectedOption;
	}
	public UserTrackableFormLine getFormLine() {
		return formLine;
	}
	public void setFormLine(UserTrackableFormLine formLine) {
		this.formLine = formLine;
	}
	public UserTrackableFormEntry getFormEntry() {
		return formEntry;
	}
	public void setFormEntry(UserTrackableFormEntry formEntry) {
		this.formEntry = formEntry;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	
	

}
