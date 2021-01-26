package com.eglobal.tramites.models;

import java.util.List;

import lombok.Data;

@Data
public class ComercioModel {
	
	
	
	String afiliacion;
	String razonSocial;
	String calle;
	String colonia;
	String ciudad;
	String entidadFederativa;
	String codigoPostal;
	String telefono;
	String giro;
	String adquirente;
	private List<TicketModel> lstTickets;
	

}
