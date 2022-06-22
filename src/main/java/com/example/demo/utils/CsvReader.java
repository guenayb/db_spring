package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Betriebsstelle;

/**
 * Purpose: Read CSV Data and store each line as an object in an ArrayList
 * 
 */

public class CsvReader {
	private static final String CSV_PATH = "src/main/resources/DBNetz.csv";
	private List<Betriebsstelle> betriebsStellen = new ArrayList<Betriebsstelle>();
	String line="";
	
	
	/**
	 * Read CSV file and loop through all lines, store the required column values in an object and add it to the array
	 * @return betriebsStellen The array that stores the objects
	 */
	public List<Betriebsstelle> getCsvData() {
		BufferedReader br = null;
	
		try {
			 br = new BufferedReader(new FileReader(CSV_PATH));
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
		finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		
	}
		return betriebsStellen;
	}
	

	
}
