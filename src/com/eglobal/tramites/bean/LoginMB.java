package com.eglobal.tramites.bean;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named(value = "login" )
@RequestScoped
public class LoginMB  {

//	SAMLCredential credential = (SAMLCredential) SecurityContextHolder.getContext().getAuthentication().getCredentials();
	
	public String getCorreo() {
//		return credential.getNameID().getValue();
		return "hola";
	}
}
