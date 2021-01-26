package com.eglobal.tramites.entity;

import java.time.LocalDate;

import lombok.Data;


@Data
public class AdquirenteEntity {
	
	private String numeroAdquirente;
	private String descripcionAdquirente;
	private String usuarioClave;
	private LocalDate fechaModificacion;
	

}
