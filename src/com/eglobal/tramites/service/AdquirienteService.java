package com.eglobal.tramites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eglobal.tramites.helper.MapperHelper;
import com.eglobal.tramites.models.AdquirenteModel;
import com.eglobal.tramites.repository.AdquirenteRepository;

@Service
public class AdquirienteService {
	
	@Autowired
	AdquirenteRepository adquirenteRepository;
	
	
	public List<AdquirenteModel> obtieneAdquirienteByCorreo(String correo){
		
		
		List<AdquirenteModel> lstAdquirenteModel = MapperHelper.mapList(adquirenteRepository.getAdquirentes(), AdquirenteModel.class);
		
		return lstAdquirenteModel;
	}
	

	

}
