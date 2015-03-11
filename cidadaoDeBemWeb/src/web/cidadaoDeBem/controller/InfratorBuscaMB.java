package web.cidadaoDeBem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cidadaoDeBem.ejb.facade.InfratorFacade;
import cidadaoDeBem.ejb.modelo.Infrator;

@ManagedBean
@ViewScoped
public class InfratorBuscaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private InfratorFacade infratorFacade;

	private List<Infrator> infratores;
	private String busca;

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public List<Infrator> getInfratores() {
		if (infratores == null)
			infratores = new ArrayList<Infrator>();
		return infratores;
	}

	public void setInfratores(List<Infrator> infratores) {
		this.infratores = infratores;
	}

	public String buscar() {
		infratores = infratorFacade.buscarInfrator(busca, busca, busca, busca);
		return null;
	}
}
