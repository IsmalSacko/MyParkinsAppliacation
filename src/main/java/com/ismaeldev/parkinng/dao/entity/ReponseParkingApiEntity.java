package com.ismaeldev.parkinng.dao.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Cette Annotation permet d'ignorer les champs/données que nous n'avons pas
 * besoin d'utiliser via l'API que nous faisons référence.
 * 
 * @author ismal
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReponseParkingApiEntity {
	@JsonProperty(value = "records")
	private List<RecordEntity> records;

	public List<RecordEntity> getRecords() {
		return records;
	}

	public void setRecords(List<RecordEntity> records) {
		this.records = records;
	}

}
