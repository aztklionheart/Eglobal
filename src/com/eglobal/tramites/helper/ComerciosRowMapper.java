package com.eglobal.tramites.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.RowMapper;

import com.eglobal.tramites.common.BaseHelper;
import com.eglobal.tramites.models.ComercioModel;


public class ComerciosRowMapper extends BaseHelper implements RowMapper<ComercioModel> {

	@Override
	public ComercioModel mapRow(ResultSet rs, int arg1) throws SQLException {

		ComercioModel comercioModel = new ComercioModel();

		comercioModel.setAdquirente(rs.getString("c_adq_numero"));
		comercioModel.setAfiliacion(rs.getString("no_afiliacion"));
		comercioModel.setCalle(rs.getString("calle_no"));
		comercioModel.setCiudad(rs.getString("ciudad"));
		comercioModel.setCodigoPostal(rs.getString("cod_postal"));
		comercioModel.setColonia(rs.getString("colonia"));
		comercioModel.setEntidadFederativa(rs.getString("c_estado_nombre"));
		comercioModel.setGiro(rs.getString("c_giro_desc"));
		comercioModel.setRazonSocial( StringUtils.trim ( rs.getString("razon_social") ));
		comercioModel.setTelefono(rs.getString("telefono_1"));
		
		return comercioModel;
	}



}
