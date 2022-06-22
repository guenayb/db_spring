package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Betriebsstelle;
import com.example.demo.service.BetriebsstellenService;

/**
 * Definition of the API endpoints and configuration of HTTP Response with ResponseEntity
 * 
 */
@RestController
@RequestMapping("/api/v1")
public class BetriebsstellenController {
	@Autowired
	private BetriebsstellenService service;
	
	
	@GetMapping("/betriebsstelle")
	public ResponseEntity<List<Betriebsstelle>> getData() {
		return ResponseEntity.ok(service.getCsvData());
	}
	
	/**
	 * GET Request to find a specific "Betriebsstelle"
	 * @param id The route parameter that the user passes in the URL
	 * @return ResponseEntity that contains the object or status 404 if not found
	 */
	@GetMapping("/betriebsstelle/{id}")
	public ResponseEntity<Betriebsstelle> getBetriebsstelle(@PathVariable String id) {
		Betriebsstelle b = service.getBetriebsstelle(id);
		if(b.getAbk() == null) {
			return new ResponseEntity<Betriebsstelle>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(b);
	}
}
