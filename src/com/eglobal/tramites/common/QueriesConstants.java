package com.eglobal.tramites.common;

public class QueriesConstants {
	
	public static final String OBTENER_ESTADO_ID = "SELECT c_estado_clave, c_estado_nombre, c_dar_clave"
			+ " FROM C_ESTADOS WHERE c_dar_clave = ? ";
	
	public static final String OBTENER_ESTADOS = "SELECT c_estado_clave, c_estado_nombre, c_dar_clave "
			+ " FROM C_ESTADOS ";

	public static final String AUTOCOMPLETE_COMERCIOS = "SELECT com.no_afiliacion, com.c_adq_numero, com.razon_social, com.calle_no, com.colonia, com.ciudad, "
			+ " est.c_estado_nombre, com.cod_postal, com.telefono_1, gir.c_giro_desc "
			+ " FROM c_comercios_mq com JOIN c_estados est ON com.c_estado_clave = est.c_estado_clave "
			+ "  JOIN c_giros gir on com.c_giro_clave = gir.c_giro_clave where com.no_afiliacion like ";
	
	/**
	 * CATALOGOS
	 */
	public static final String OBTIENE_ADQUIRENTE = "SELECT c_adq_numero, c_adq_des,c_adq_usu_clave, c_adq_fec_mod FROM c_adquirente";
	public static final String OBTIENE_ADQUIRENTE_ID = "SELECT c_adq_numero, c_adq_des,c_adq_usu_clave, c_adq_fec_mod FROM c_adquirente where c_adq_numero = ?";
}


