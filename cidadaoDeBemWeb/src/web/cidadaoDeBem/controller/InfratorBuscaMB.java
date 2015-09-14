package web.cidadaoDeBem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
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
	private boolean mae=true;
	private boolean nome=true;
	private boolean cpf=true;
	private boolean apelido=true;
	
	

	

	public boolean isCpf() {
		return cpf;
	}

	public void setCpf(boolean cpf) {
		this.cpf = cpf;
	}
	
	public String cpfInfrator(){
		String cpfInfrator=null;
		if(isCpf()) cpfInfrator=busca;
		return cpfInfrator;
	}

	public boolean isApelido() {
		return apelido;
	}

	public void setApelido(boolean apelido) {
		this.apelido = apelido;
	}
	
	public String apelidoInfrator(){
		String apelidoInfrator=null;
		if(isApelido()) apelidoInfrator=busca;
		return apelidoInfrator;
	}


	public boolean isNome() {
		return nome;
	}

	public void setNome(boolean nome) {
		this.nome = nome;
	}
	
	public String nomeInfrator(){
		String nomeInfrator=null;
		if(isNome()) nomeInfrator=busca;
		return nomeInfrator;
	}

	public boolean isMae() {
		return mae;
	}

	public void setMae(boolean mae) {
		this.mae = mae;
	}
	public String nomeMae(){
		String nomeMae=null;
		if(this.isMae()) nomeMae = busca;
		return nomeMae;
	}

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
		isMae();
		isNome();
		infratores = infratorFacade.buscarInfrator(this.nomeInfrator(), this.cpfInfrator(), this.apelidoInfrator(), this.nomeMae());
		setMae(true);
		setNome(true);
		setCpf(true);
		setApelido(true);
		return null;
	}
}
