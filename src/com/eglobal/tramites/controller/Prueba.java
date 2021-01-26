package com.eglobal.tramites.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int dia = LocalDate.now( ZoneId.of( "America/Mexico_City" ) ).getDayOfYear();
		
		int cumplea = LocalDate.of(2024, 06, 29).getDayOfYear();
		
		DateFormat d = new SimpleDateFormat("D");
		
		String juliano = String.format("%03d", cumplea);
		
		System.out.println(juliano);
		
	

	}

}
