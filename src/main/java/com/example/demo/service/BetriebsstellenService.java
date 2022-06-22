package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Betriebsstelle;
import com.example.demo.utils.CsvReader;

/**
 * Service to get the ArrayList from the CsvReader class and definition of
 * two functions to return
 * 1. All Objects in the ArrayList
 * 2. One Object if the URL parameter matches the object property
 */

@Service
public class BetriebsstellenService {

	private CsvReader csvReader = new CsvReader();
	List<Betriebsstelle> betriebsStellen = csvReader.getCsvData();
	
	
	
	public List<Betriebsstelle> getCsvData() {
		
		return betriebsStellen;
	}
	
	/**
	 * Loop through the ArrayList and check if the property exists on the object
	 * @param stellenAbk The route parameter in the Controller
	 * @return gesuchteStelle
	 */
	public Betriebsstelle getBetriebsstelle(String stellenAbk) {
		Betriebsstelle gesuchteStelle = new Betriebsstelle();
		for(Betriebsstelle b : betriebsStellen) {
			if(b.getAbk().equals(stellenAbk.toUpperCase())) {
				gesuchteStelle = b;
			}
		} 
		return gesuchteStelle;
	}
	
}
