package com.eglobal.tramites.bean;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml.SAMLCredential;

import com.eglobal.tramites.models.AdquirenteModel;
import com.eglobal.tramites.service.AdquirienteService;

@Named
@RequestScoped

public class AdquirenteMB extends GeneralMB{
	
	@Autowired
	AdquirienteService adquirienteService;

	private List<AdquirenteModel> lstAdquirienteModel;
	
	private AdquirenteModel adquirienteModelSelected;

	
	public String llenaAutoCompliteInput(AdquirenteModel adquirenteModel) {

        String adquirente = "";

        if (null != adquirenteModel) {
        	adquirente = adquirenteModel.getNumeroAdquirente() + " - " + adquirenteModel.getDescripcionAdquirente();
        }

        return adquirente;
    }

	public AdquirienteService getAdquirienteService() {
		return adquirienteService;
	}



	public void setAdquirienteService(AdquirienteService adquirienteService) {
		this.adquirienteService = adquirienteService;
	}

	public List<AdquirenteModel> getLstAdquirienteModel() {
		
		SAMLCredential credential = (SAMLCredential) SecurityContextHolder.getContext().getAuthentication().getCredentials();
		
		return  adquirienteService.obtieneAdquirienteByCorreo(credential.getNameID().getValue());
	}
	
	public void setLstAdquirienteModel(List<AdquirenteModel> lstAdquirienteModel) {
		this.lstAdquirienteModel = lstAdquirienteModel;
	}



	public AdquirenteModel getAdquirienteModelSelected() {
		return adquirienteModelSelected;
	}



	public void setAdquirienteModelSelected(AdquirenteModel adquirienteModelSelected) {
		this.adquirienteModelSelected = adquirienteModelSelected;
	}

	
}
