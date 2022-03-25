package com.ismaeldev.parkinng.service.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismaeldev.parkinng.dao.ParkingApiDao;
import com.ismaeldev.parkinng.dao.entity.RecordEntity;
import com.ismaeldev.parkinng.dao.entity.ReponseParkingApiEntity;
import com.ismaeldev.parkinng.models.Parking;
import com.ismaeldev.parkinng.service.ParkingService;

/**
 * Ici on définit les méthodes qui seront exposées dans l'interface
 * (ParkingService) qui les exposera dans le controller de notre choix
 * 
 * @author ismal
 *
 */
@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	public ParkingApiDao apiDao;

	@Override
	public List<Parking> getListeParkings() {
		ReponseParkingApiEntity reponse = apiDao.getParking();
		return transformEntityToModel(reponse);
	}

	private List<Parking> transformEntityToModel(ReponseParkingApiEntity reponse) {
		List<Parking> resultat = new ArrayList<Parking>();
		reponse.getRecords();
		for (RecordEntity record : reponse.getRecords()) {
			// record.getFields();
			Parking parking = new Parking();
			parking.setNom(record.getFields().getGrpNom());
			parking.setStatut(getLibelleStatut(record));
			parking.setNbPlaceDispo(record.getFields().getGrpDisponible());
			parking.setNbPlacetTotal(record.getFields().getGrpExploitation());
			parking.setHeureMaj(getHeureMaj(record));

			resultat.add(parking);
		}
		return resultat;
	}

	/**
	 * Permet de formater l'heure de la mise à jour
	 * 
	 * @param record
	 * @return
	 */
	private String getHeureMaj(RecordEntity record) {
		OffsetDateTime dateMaj = OffsetDateTime.parse(record.getFields().getGrpHorodatage());
		OffsetDateTime dateMajwithOffsetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+00:00"));

		return dateMajwithOffsetPlus2.getHour() + "h" 
		+ dateMajwithOffsetPlus2.getMinute();
	}

	/**
	 * Méthode de formatage de statut du parking (ouvert/fermé/ouvert aux abonnés/
	 * données non disponobles)
	 * 
	 * @param record
	 * @return
	 */
	private String getLibelleStatut(RecordEntity record) {
		switch (record.getFields().getGrpStatut()) {
		case "1": {
			return "FERME";
		}
		case "2": {
			return "ABONNES";
		}
		case "5": {
			return "OUVERT";
		}
		}
		return "Données non disponbles";
	}

}
