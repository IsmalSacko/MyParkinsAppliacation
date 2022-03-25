package com.ismaeldev.parkinng.models;

public class Parking {
	private String nom;
	private int nbPlaceDispo;
	private int nbPlacetTotal;
	private String statut;
	private String heureMaj;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbPlaceDispo() {
		return nbPlaceDispo;
	}
	public void setNbPlaceDispo(int nbPlaceDispo) {
		this.nbPlaceDispo = nbPlaceDispo;
	}
	public int getNbPlacetTotal() {
		return nbPlacetTotal;
	}
	public void setNbPlacetTotal(int nbPlacetTotal) {
		this.nbPlacetTotal = nbPlacetTotal;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getHeureMaj() {
		return heureMaj;
	}
	public void setHeureMaj(String heureMaj) {
		this.heureMaj = heureMaj;
	}
	
}
