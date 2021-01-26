package com.eglobal.tramites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eglobal.tramites.models.CestadosVo;
import com.eglobal.tramites.repository.CEstadosRepository;


@Service
public class CEstadosDaoService {

	@Autowired
	private CEstadosRepository cestadosRepository;
	
	public List<CestadosVo> getEstadosById(Integer id) {
		
		return cestadosRepository.getEstadosById(id);
	}
	
	public List<CestadosVo> getEstados() {
		
		return cestadosRepository.getEstados();
	}
	

}
