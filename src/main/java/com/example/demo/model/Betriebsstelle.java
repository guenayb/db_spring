package com.example.demo.model;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Betriebsstelle {
	@JsonIgnore
	private String abk;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Kurzname")
	private String kurzName;
	
	@JsonProperty("Typ")
	private String typ;
	
	public Betriebsstelle(String name, String kurzName, String typ, String abk) {
		this.name = name;
		this.kurzName = kurzName;
		this.typ = typ;
		this.abk = abk;
	}

	public Betriebsstelle() {
		
	}
	
	
	public String getAbk() {
		return abk;
	}
	public void setAbk(String abk) {
		this.abk = abk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKurzName() {
		return kurzName;
	}
	public void setKurzName(String kurzName) {
		this.kurzName = kurzName;
	}
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}
	
	@Override
	public String toString() {
		return "Betriebsstelle [abk=" + abk + ", name=" + name + ", kurzName=" + kurzName + ", typ=" + typ + "]";
	}
}
