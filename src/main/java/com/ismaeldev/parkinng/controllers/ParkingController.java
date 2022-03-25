package com.ismaeldev.parkinng.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ismaeldev.parkinng.models.Parking;
import com.ismaeldev.parkinng.service.ParkingService;

/**
 * Cette classe nous permet de définir les différentes méthodes de notre Parking
 * qui sont appeler quand dans l'url. Et ces méthode font appel aà unn service
 * (Une interface) qui implemente à son tour les méthode de différentes couches
 * de notre application.
 * 
 * @author ismael
 *
 */
@RestController
public class ParkingController {
	@Autowired
	private ParkingService parkingService;

	@CrossOrigin("*")
	@RequestMapping(path = "/api/parkings", method = RequestMethod.GET)
	public List<Parking> getListeParking() {

		return parkingService.getListeParkings();

	}

}
