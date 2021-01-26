package com.eglobal.tramites.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseJDBCRepository {
	
	protected JdbcTemplate jdbcTemplate;
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    protected BaseJDBCRepository() {
        super();
    }
    
    @Autowired
    protected void setDataSource(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    
    protected String prepararConsultaClausulaIN(String consulta, Integer numeroParametros) {
        StringBuilder sb = new StringBuilder();
        sb.append("IN (");
        for (int i = 0; i < numeroParametros; i++) {
            sb.append("?,");
        }
        sb.append(")");
        String clausula = sb.deleteCharAt(sb.length() - 2).toString();
        return consulta.replace("IN ()", clausula);
    }
}