package com.eglobal.tramites.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eglobal.tramites.common.BaseHelper;
import com.eglobal.tramites.models.CestadosVo;


public class CestadosRowMapper extends BaseHelper implements RowMapper<CestadosVo>{

	@Override
	public CestadosVo mapRow(ResultSet rs, int arg1) throws SQLException {
		
		CestadosVo vo = new CestadosVo();
		
		vo.setCodEstado(rs.getString("c_estado_clave"));
		vo.setNomEstado(rs.getString("c_estado_nombre"));
		vo.setDarId(rs.getInt("c_dar_clave"));
		
		return vo;
	}

}
