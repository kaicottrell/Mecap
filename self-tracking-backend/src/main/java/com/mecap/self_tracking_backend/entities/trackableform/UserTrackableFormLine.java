package com.mecap.self_tracking_backend.entities.trackableform;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// THE Question of what is it that is being tracked? Ex. Did you go to the gym? (Content) 
@Entity
public class UserTrackableFormLine {
	@Id
	@GeneratedValue // Sequence would be created and used to set value
	private Long id;
	private String content;
	private String colorHexValue;
	private DefaultTrackablecustomFormLineType defaultFormLineType; // nullable by default
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="custom_form_line_type_id")
	private UserCustomTrackableFormLineType customFormLineType; // fk
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="form_template_id")
	private UserTrackableFormTemplate formTemplateId; // fk
    public UserTrackableFormLine() { }

	public Long getId( ) {
		return id;
	}

	public UserCustomTrackableFormLineType getCustomFormLineType() {
		return customFormLineType;
	}

	public void setCustomFormLineType(UserCustomTrackableFormLineType customFormLineType) {
		this.customFormLineType = customFormLineType;
	}

	public UserTrackableFormTemplate getFormTemplateId() {
		return formTemplateId;
	}

	public void setFormTemplateId(UserTrackableFormTemplate formTemplateId) {
		this.formTemplateId = formTemplateId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getColorHexValue() {
		return colorHexValue;
	}

	public void setColorHexValue(String colorHexValue) {
		this.colorHexValue = colorHexValue;
	}


	public DefaultTrackablecustomFormLineType getDefaultFormLineType() {
		return defaultFormLineType;
	}
	
	public void setDefaultFormLineType(DefaultTrackablecustomFormLineType defaultFormLineType) {
		this.defaultFormLineType = defaultFormLineType;
	}


}

enum DefaultTrackablecustomFormLineType {
	STAR, EMOTION_FACE, NUMBER_INPUT, DECIMAL_INPUT, ONE_TO_TEN_RANGE, ONE_TO_HUNDRED_RANGE
}
