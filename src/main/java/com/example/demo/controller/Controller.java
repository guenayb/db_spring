package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Betriebsstelle;
import com.example.demo.services.BetriebsstellenService;

@RestController
public class Controller {
	@Autowired
	private BetriebsstellenService service;
	
	@GetMapping(value="/betriebsstelle")
	public ResponseEntity<List<Betriebsstelle>> getData() {
		return ResponseEntity.ok(service.getCsvData());
	}
	
	@GetMapping("/betriebsstelle/{id}")
	public ResponseEntity<Betriebsstelle> getBetriebsstelle(@PathVariable String id) {
		Betriebsstelle b = service.getBetriebsstelle(id);
		if(b.getAbk() == null) {
			return new ResponseEntity<Betriebsstelle>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(b);
	}
}
