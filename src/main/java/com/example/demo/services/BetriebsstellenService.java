package com.example.demo.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Betriebsstelle;
import com.example.demo.utils.CsvReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Service
public class BetriebsstellenService {

	private CsvReader csvReader = new CsvReader();
	
	String line="";
	List<Betriebsstelle> betriebsStellen = csvReader.getCsvData();
	
	
	public List<Betriebsstelle> getCsvData() {
		
		return betriebsStellen;
	}
	
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
