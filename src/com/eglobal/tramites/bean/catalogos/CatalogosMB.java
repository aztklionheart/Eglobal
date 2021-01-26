package com.eglobal.tramites.bean.catalogos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.eglobal.tramites.bean.GeneralMB;
import com.eglobal.tramites.models.CestadosVo;
import com.eglobal.tramites.service.CEstadosDaoService;

@Named
@RequestScoped
public class CatalogosMB extends GeneralMB implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 5743772004966212609L;

	
	private CestadosVo cestadosVo;
	
	private List<CestadosVo> lstCestadosVo;

	@Autowired
	CEstadosDaoService cEstadosDaoService;
	
	@PostConstruct
    public void init() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!init");
	}
	
	public CestadosVo getCestadosVo() {
		return cestadosVo;
	}

	public void setCestadosVo(CestadosVo cestadosVo) {
		this.cestadosVo = cestadosVo;
	}

	public List<CestadosVo> getLstCestadosVo() {
		
		if (null == lstCestadosVo) {
			setLstCestadosVo( cEstadosDaoService.getEstados());
		}
		
		
		return lstCestadosVo;
	}

	public void setLstCestadosVo(List<CestadosVo> lstCestadosVo) {
		this.lstCestadosVo = lstCestadosVo;
	}
	
	
	
}