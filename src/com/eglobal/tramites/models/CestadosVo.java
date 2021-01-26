package com.eglobal.tramites.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CestadosVo implements Serializable{

	public CestadosVo() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Vo de catálogo
	 */
	private static final long serialVersionUID = 4196697302159317367L;


	private String codEstado;
	private String nomEstado;
	private Integer darId;

}
