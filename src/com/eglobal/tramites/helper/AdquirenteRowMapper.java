package com.eglobal.tramites.helper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.eglobal.tramites.common.BaseHelper;
import com.eglobal.tramites.entity.AdquirenteEntity;

public class AdquirenteRowMapper extends BaseHelper implements RowMapper<AdquirenteEntity> {

	@Override
	public AdquirenteEntity mapRow(ResultSet rs, int arg1) throws SQLException {

		AdquirenteEntity vo = new AdquirenteEntity();

		vo.setDescripcionAdquirente(rs.getString("c_adq_des"));
		vo.setFechaModificacion(getLocalDate(rs,"c_adq_fec_mod") );
		vo.setNumeroAdquirente(rs.getString("c_adq_numero"));
		vo.setUsuarioClave(rs.getString("c_adq_usu_clave"));

		return vo;
	}
	
	/**
     * Get LocalDate instance from the ResultSet rs with columnName
     * @param rs
     * @param columnName
     * @return null if the sqlDate retrieved from the result set is null.
     * @throws SQLException
     */
    static public LocalDate getLocalDate(ResultSet rs, String columnName) throws SQLException {
        Date sqlDate = rs.getDate(columnName);
        return sqlDate == null ? null : sqlDate.toLocalDate();
    }

}
