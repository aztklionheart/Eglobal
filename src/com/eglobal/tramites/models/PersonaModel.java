package com.eglobal.tramites.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaModel {
	
	String nombre;
	String primerApellido;
	String segundoApellido;
	String telefono;

}
