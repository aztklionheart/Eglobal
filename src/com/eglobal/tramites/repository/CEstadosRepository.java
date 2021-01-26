package com.eglobal.tramites.repository;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eglobal.tramites.common.QueriesConstants;
import com.eglobal.tramites.helper.CestadosRowMapper;
import com.eglobal.tramites.models.CestadosVo;


@Repository("cestadosRepository")
public class CEstadosRepository {


	@Resource(name="jdbcComercio")
	private JdbcTemplate aclaraciones;

	public List<CestadosVo> getEstadosById(Integer id) {
		
		return aclaraciones.query(QueriesConstants.OBTENER_ESTADO_ID, 
				new Object[] {id} , new CestadosRowMapper());
		
		
	}
	
public List<CestadosVo> getEstados() {

	
		return aclaraciones.query(
				QueriesConstants.OBTENER_ESTADOS,
                (rs, rowNum) ->
                        new CestadosVo(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3)
                        )
        );
		
		
	}
	

	

}
