package com.eglobal.tramites.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import com.eglobal.tramites.models.ComercioModel;
import com.eglobal.tramites.models.TicketModel;
import com.eglobal.tramites.service.ComercioService;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Controller;

@ManagedBean
@ViewScoped
@Getter
@Setter
public class ComercioMB extends GeneralMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ComercioModel comercioModelSelected;
	
	@Autowired
	ComercioService comercioService;
	
	private String selectedComercio;
	
	
	
	@PostConstruct
    public void init() {
		setComercioModelSelected(null);
		
	}
	
	public String activaBoton() {
		String flag= "true";
		
		if(null != getComercioModelSelected()) {
			flag = "false";
		}

		return flag;
	}
	
	public String autocompleteInput(ComercioModel comercioModel) {
		String input = null;
		if (null != comercioModel ) {
			input = comercioModel.getAfiliacion() + " - " + comercioModel.getRazonSocial().trim();
		}
		return input;
	}
	
	
	public List<ComercioModel> autoCompleteComercio(String query){
		
		 List<ComercioModel> list = comercioService.autoCompleteComercio(query);
		 
		 if(list.isEmpty()) {
			 
			 String stringMessage =  query + " No tiene coincidencias";
			  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Cuidado!", stringMessage);
			  FacesContext.getCurrentInstance().addMessage("", message);
		 }
		 
		return comercioService.autoCompleteComercio(query);
	}
	
	public void abreAccion( String url) {
		
        url = "/page/tickets/" + url + ".xhtml";
        
        
        setAttribute(ATRIBUTO_COMERCIO, getComercioModelSelected());
        
        try {
            redirect(url);
        } catch (IOException ex) {

        }
        
    }
	

}

