package com.eglobal.tramites.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketModel {
	
	private Integer idTicket;
	private String descripcion;
	private String idComercio;
	private String idAdquirente;
	private PersonaModel atencion;


}
