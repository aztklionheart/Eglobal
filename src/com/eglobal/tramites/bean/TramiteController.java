package com.eglobal.tramites.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml.SAMLCredential;

import com.eglobal.tramites.models.ComercioModel;
import com.eglobal.tramites.service.TramiteService;


@Named(value = "tramite" )
@RequestScoped
//@Data

//@ManagedBean(name = "tramite")
//@SessionScoped
public class TramiteController extends GeneralMB implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String afiliacion;
	
	private ComercioModel comercioModelSelected;
	
	
	public ComercioModel getComercioModelSelected() {
		return comercioModelSelected;
	}
	public void setComercioModelSelected(ComercioModel comercioModelSelected) {
		this.comercioModelSelected = comercioModelSelected;
	}
	public String getAfiliacion() {
		return this.afiliacion;
	}
	public void setAfiliacion(String afiliacion) {
		this.afiliacion = afiliacion;
	}
	
	@Autowired
	TramiteService tramiteService;
	

	
	public void abreAccion( String url) {
        url = "/page/tickets/" + url + ".xhtml";
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext e =facesContext.getExternalContext();
        HttpSession https = (HttpSession)  e.getSession(true);
        
        https.setAttribute("uno", "uno");;
        
        
        setAttribute(ATRIBUTO_COMERCIO, getComercioModelSelected());
        
        try {
            redirect(url);
        } catch (IOException ex) {

        }
    }
	
	public String getName() {
    	
    	SAMLCredential credential = (SAMLCredential) SecurityContextHolder.getContext().getAuthentication().getCredentials();
    	
    	setAttribute(ATRIBUTO_CORREO,credential.getNameID().getValue());
    	
        return credential.getNameID().getValue();
    }
    
    
    public void setName(String name) {
    }

}
