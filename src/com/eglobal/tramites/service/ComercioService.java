package com.eglobal.tramites.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eglobal.tramites.models.ComercioModel;
import com.eglobal.tramites.models.PersonaModel;
import com.eglobal.tramites.models.TicketModel;
import com.eglobal.tramites.repository.ComerciosRepository;

@Service
public class ComercioService {

	@Autowired
	ComerciosRepository comercioRepository;
	
	
	
	public List<ComercioModel> autoCompleteComercio(String query){
		
		List<ComercioModel> lst = comercioRepository.autocompleteComercios(query);
		
		for (ComercioModel comercioModel : lst) {
			comercioModel.setLstTickets(comercioRepository.obtieneTiketsByComercio(comercioModel.getAfiliacion()));
		}
				
				
		
		
		return lst;
				
	}
	
	public List<TicketModel> obtieneTiketsByComercio(String comercio){
		
		return comercioRepository.obtieneTiketsByComercio(comercio);
		
	}
	
	public List<PersonaModel> obtieneContactos(String idComercio){
		
		return llenaContactosTemp();
		
	}
	
	public List<PersonaModel> llenaContactosTemp(){
		
		List<PersonaModel> lst = new ArrayList();
		
		lst.add(new PersonaModel("Pedro","Marquez","Suarez","5522462314" ));
		lst.add(new PersonaModel("Sandra","Rodriguez","Hernandez","55886413" ));
		lst.add(new PersonaModel("Raul","Montañez","Fernandez","55541845" ));
		lst.add(new PersonaModel("Jorge","Romero","Castro","4447128865" ));
		lst.add(new PersonaModel("Maria","Estrella","Rosales","77521984" ));
		lst.add(new PersonaModel("Francisco","Armandariz","Rojas","2287116662" ));
		
		return lst;
		
	}
	
	
}
