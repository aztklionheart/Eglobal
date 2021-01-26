package com.eglobal.tramites.bean.ticket;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.eglobal.tramites.bean.GeneralMB;
import com.eglobal.tramites.models.ComercioModel;
import com.eglobal.tramites.models.PersonaModel;
import com.eglobal.tramites.service.ComercioService;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@ManagedBean
@ViewScoped
@Getter
@Setter
public class AgregaTicketMB extends GeneralMB implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ComercioModel comercioModel;
	private boolean skip;
	
	/**
	 * itemGroup
	 */
	private List<SelectItem> categorias;    
    private String selection;
    
    /**
     * Personas
     */
    private List<PersonaModel> contactos;
    private PersonaModel contactoSelected;
    
    @Autowired
    ComercioService comercioService;
	
	@PostConstruct
    public void init() {
		
		setComercioModel(null);
		 if (null != getAttribute(ATRIBUTO_COMERCIO)) {
	        	setComercioModel(null);
	        	setComercioModel((ComercioModel)getAttribute(ATRIBUTO_COMERCIO));
	        }
	        
	        removeAttribute(ATRIBUTO_COMERCIO);
	        
	        //cambiar esto ()itemgroup
	        categorias = new ArrayList<SelectItem>();
	        SelectItemGroup group1 = new SelectItemGroup("Group 1");
	        SelectItemGroup group2 = new SelectItemGroup("Group 2");
	        SelectItemGroup group3 = new SelectItemGroup("Group 3");
	        SelectItemGroup group4 = new SelectItemGroup("Group 4");
	        
	        SelectItemGroup group11 = new SelectItemGroup("Group 1.1");
	        SelectItemGroup group12 = new SelectItemGroup("Group 1.2");
	        
	        SelectItemGroup group21 = new SelectItemGroup("Group 2.1");
	        
	        SelectItem option31 = new SelectItem("Option 3.1", "Option 3.1");
	        SelectItem option32 = new SelectItem("Option 3.2", "Option 3.2");
	        SelectItem option33 = new SelectItem("Option 3.3", "Option 3.3");
	        SelectItem option34 = new SelectItem("Option 3.4", "Option 3.4");
	        
	        SelectItem option41 = new SelectItem("Option 4.1", "Option 4.1");
	        
	        SelectItem option111 = new SelectItem("Option 1.1.1");
	        SelectItem option112 = new SelectItem("Option 1.1.2");
	        group11.setSelectItems(new SelectItem[]{option111, option112});
	        
	        SelectItem option121 = new SelectItem("Option 1.2.1", "Option 1.2.1");
	        SelectItem option122 = new SelectItem("Option 1.2.2", "Option 1.2.2");
	        SelectItem option123 = new SelectItem("Option 1.2.3", "Option 1.2.3");
	        group12.setSelectItems(new SelectItem[]{option121, option122, option123});
	        
	        SelectItem option211 = new SelectItem("Option 2.1.1", "Option 2.1.1");
	        group21.setSelectItems(new SelectItem[]{option211});
	        
	        group1.setSelectItems(new SelectItem[]{group11, group12});
	        group2.setSelectItems(new SelectItem[]{group21});
	        group3.setSelectItems(new SelectItem[]{option31, option32, option33, option34});
	        group4.setSelectItems(new SelectItem[]{option41});
	        
	        categorias.add(group1);
	        categorias.add(group2);
	        categorias.add(group3);
	        categorias.add(group4);
	        
	        // llenar contactos
	        contactos = comercioService.obtieneContactos(getComercioModel().getAfiliacion());
			
	}
	
	public String calculaFolio() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yy");
		int dia = LocalDate.now( ZoneId.of( "America/Mexico_City" ) ).getDayOfYear();
		String juliano = String.format("%03d", dia);
		
		String ano = formato.format(LocalDate.now());
		
		String res = ano + getComercioModel().getAdquirente()+juliano+"00001";
		
		return res;
	}
	
	public String onFlowProcess(FlowEvent event) {
		if(skip) {
			skip = false;	//reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}
	
	public void borrarContacto() {
		contactos.remove(contactoSelected);
		
	}
	

}
