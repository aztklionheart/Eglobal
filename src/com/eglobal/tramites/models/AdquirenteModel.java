package com.eglobal.tramites.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AdquirenteModel {

	private String numeroAdquirente;
	private String descripcionAdquirente;
	private String usuarioClave;
	private LocalDate fechaModificacion;
	
}
