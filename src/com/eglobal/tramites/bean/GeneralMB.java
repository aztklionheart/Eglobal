package com.eglobal.tramites.bean;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.PrimeFacesContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import lombok.extern.java.Log;


@Log
public class GeneralMB extends SpringBeanAutowiringSupport {
	
	protected static final String ATRIBUTO_CORREO = "correousuario";
	protected static final String ATRIBUTO_COMERCIO = "objetocomercio";
	protected static final String PANTALLA_CONSULTA_COMERCIO = "pantallaConsultaComercio";

    /**
   * Método que obtiene un atributo de la sesión.
   * 
   * @param name Nombre del atributo
   * @return Objeto con el valor del atributo que se busco. En caso de no encontrar el atributo, devuelve {@code null}
   */
  protected Object getAttribute( String name )
  {
    HttpSession session = getSession();
    Object obj = null;
    if( session != null )
    {
      obj = session.getAttribute( name );
    }
    return obj;
  }
  
    /**
   * Método que agrega a sesión un atributo deseado.
   * 
   * @param name Nombre del atributo
   * @param value Valor del atributo
   */
  protected void setAttribute( String name, Object value )
  {
    HttpSession session = getSession();
    
    
    if( session != null )
    {
      session.setAttribute( name, value );
    }
    System.out.println("SESION------------------------" + session.getAttribute(name) );
  }
    
   /**
   * Método que elimina un atributo de la sesión.
   * 
   * @param name Nombre del atributo a eliminar.
   */
  protected void removeAttribute( String name )
  {
    HttpSession session = getSession();
    if( session != null )
    {
      session.removeAttribute( name );
    }
  }
  
  /**
   * Method that redirects to the page associated with the specified URL.
   * 
   * @param url Relative unified resource locator to the page.
   * @throws IOException if an input/output error occurs.
   * @author afuentes
   */
  public void redirect( String url ) throws IOException
  {
    FacesContext ctx = FacesContext.getCurrentInstance();
    ExternalContext context = ctx.getExternalContext();
    context.redirect( buildStringUsingMutable( context.getRequestContextPath(), url ) );

  }
  
  public static HttpSession getSession() {
	  
	  ExternalContext e = getExtCont();
	  
	  HttpSession https = null;
	  
	  if(null != e) {
		  https = (HttpSession)  e.getSession(true);
	  }
	  
      return https;
  }
  
  private static ExternalContext getExtCont() {
      FacesContext facesContext = getFacesContext();
      if (facesContext == null) {
    	  log.info("No se puede acceder al contexto desde el FacesContext.");
          return null;
      } else {
          return getFacesContext().getExternalContext();
      }
  }
  
  /**
   * M&eacute;todo que construye una cadena usando una cadena mutable en base a los argumentos proporcionados.
   * 
   * @param args Argumentos para construir la cadena mutable.
   * @return {@link String} con la cadena no mutable en base a los argumentos proporcionados.
   * @author afuentes
   */
  public static String buildStringUsingMutable( Object... args )
  {
    return buildMutableString( args ).toString();
  }
  /**
   * M&eacute;todo que construye una cadena mutable en base a los argumentos proporcionados.
   * 
   * @param args Argumentos para construir la cadena mutable.
   * @return {@link StringBuilder} con la cadena mutable en base a los argumentos proporcionados.
   * @author afuentes
   */
  public static StringBuilder buildMutableString( Object... args )
  {
    StringBuilder builder = new StringBuilder();
    for( Object object : args )
    {
      builder.append( object );
    }
    return builder;
  }
  
  /**
   * Hace un recuento del número de mensajes agregados al contexto actual de
   * faces.
   *
   * @return Número de mensajes agregados al contexto actual de faces
   */
  public static int countMessages() {
      FacesContext facesContext = getFacesContext();
      if (facesContext == null) {
          log.info("No fue posible recuperar el número de mensajes.");
          return 0;
      } else {
          return getFacesContext().getMessageList().size();
      }
  }
  private static FacesContext getFacesContext() {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      if (facesContext == null) {
    	  log.info("Se intentó acceder al FacesContext fuera del contexto de Java Server Faces, se regresará una instancia nula.");
    	  facesContext = PrimeFacesContext.getCurrentInstance();
    	  
    	  log.info("......"+facesContext );
      }
      return facesContext;
  }
  
	
}
