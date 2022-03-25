package com.ismaeldev.parkinng.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Cette Annotation permet d'ignorer les champs/données que nous n'avons pas 
 * besoin d'utiliser via l'API que nous faisons référence.
 * @author ismal
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordEntity {
	@JsonProperty(value = "fields")
	private FieldsEntity fields;
	

	public FieldsEntity getFields() {
		return fields;
	}

	public void setFields(FieldsEntity fields) {
		this.fields = fields;
	}
	
	
}
