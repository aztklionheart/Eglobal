package com.eglobal.tramites.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eglobal.tramites.common.QueriesConstants;
import com.eglobal.tramites.helper.ComerciosRowMapper;
import com.eglobal.tramites.models.ComercioModel;
import com.eglobal.tramites.models.PersonaModel;
import com.eglobal.tramites.models.TicketModel;

import lombok.extern.java.Log;

@Log
@Repository
public class ComerciosRepository {
	
	@Resource(name="jdbcComercio")
	private JdbcTemplate comercio;
	
	public List<ComercioModel> autocompleteComercios(String query){

		String q = "'%" + query + "%'";
		
		return comercio.query(QueriesConstants.AUTOCOMPLETE_COMERCIOS + q, new ComerciosRowMapper());
		
	}
	
	
	public List<TicketModel> obtieneTiketsByComercio(String comercio){
		
		return generaTickets(comercio);
	}
	
	private List<TicketModel> generaTickets(String comercio){
		
		List<TicketModel> lst = new ArrayList();
		
		lst.add(new TicketModel(1, "Ticket1", "0000811","12",  obtienePersona(1)));
		lst.add(new TicketModel(2, "Ticket2", "0001310","12",  obtienePersona(2)));
		lst.add(new TicketModel(3, "Ticket3", "4198000","12",  obtienePersona(3)));
		lst.add(new TicketModel(4, "Ticket4", "4198000","12",  obtienePersona(1)));
		lst.add(new TicketModel(5, "Ticket5", "4198000","12",  obtienePersona(2)));
		lst.add(new TicketModel(6, "Ticket6", "0001310","12",  obtienePersona(3)));
		
		return lst.stream().filter(t -> t.getIdComercio().equals(comercio.trim())).collect(Collectors.toList());
		
	}
	
	private PersonaModel obtienePersona(int a) {
		
		
		PersonaModel p1 = new PersonaModel();
		p1.setNombre("Alejandro");
		p1.setPrimerApellido("Ramirez");
		p1.setSegundoApellido("Suarez");
		
		PersonaModel p2 = new PersonaModel();
		p2.setNombre("Pedro");
		p2.setPrimerApellido("Sanchez");
		p2.setSegundoApellido("Juarez");
		
		PersonaModel p3 = new PersonaModel();
		p3.setNombre("Antonio");
		p3.setPrimerApellido("Perez");
		p3.setSegundoApellido("Lopezs");
		
		switch (a) {
		case 1:
			return p1;
		case 2:
			return p2;
		case 3:
			return p3;
		default:
			return p3;
		}
		
	}
	
}
