package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Betriebsstelle;

public class CsvReader {
	String line="";
	private List<Betriebsstelle> betriebsStellen = new ArrayList<Betriebsstelle>();
	
	public List<Betriebsstelle> getCsvData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/DBNetz.csv"));
			while((line=br.readLine())!=null) {
				String[] data = line.split(";");
				Betriebsstelle stelle = new Betriebsstelle();
				stelle.setAbk(data[1]);
				stelle.setName(data[2]);
				stelle.setKurzName(data[3]);
				stelle.setTyp(data[4]);
				betriebsStellen.add(stelle);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return betriebsStellen;
	}
	

	
}
