package com.eglobal.tramites.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eglobal.tramites.common.QueriesConstants;
import com.eglobal.tramites.entity.AdquirenteEntity;
import com.eglobal.tramites.helper.AdquirenteRowMapper;

@Repository
public class AdquirenteRepository {
	
	@Resource(name="jdbcCatalogos")
	private JdbcTemplate catalogos;
	
	public List<AdquirenteEntity> getAdquirentes(){
		
		return catalogos.query(QueriesConstants.OBTIENE_ADQUIRENTE, new AdquirenteRowMapper());
		
	}

	public AdquirenteEntity getAdquirenteByTd(String id) {
		
		return catalogos.queryForObject(QueriesConstants.OBTIENE_ADQUIRENTE_ID, new Object[] {id} , new AdquirenteRowMapper());
	}

}
