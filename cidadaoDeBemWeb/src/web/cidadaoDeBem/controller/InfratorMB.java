package web.cidadaoDeBem.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import web.cidadaoDeBem.enums.Estado;
import cidadaoDeBem.ejb.facade.InfratorFacade;
import cidadaoDeBem.ejb.modelo.Biotipo;
import cidadaoDeBem.ejb.modelo.Endereco;
import cidadaoDeBem.ejb.modelo.Filiacao;
import cidadaoDeBem.ejb.modelo.Infrator;

@ManagedBean
@RequestScoped
public class InfratorMB {

	@EJB
	private InfratorFacade infratorFacade;

	private String busca;
	private List<Infrator> infratores;
	private Infrator infrator;
	private Biotipo biotipo;
	private Endereco endereco;
	private String complemento;
	private String rua;
	private Filiacao filiacao;

	public Estado[] getEstados() {

		return Estado.values();
	}

	public Filiacao getFiliacao() {
		if (filiacao == null)
			filiacao = new Filiacao();
		return filiacao;
	}

	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Endereco getEndereco() {
		if (endereco == null)
			endereco = new Endereco();
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Biotipo getBiotipo() {
		if (biotipo == null)
			biotipo = new Biotipo();
		return biotipo;
	}

	public void setBiotipo(Biotipo biotipo) {
		this.biotipo = biotipo;
	}

	public Infrator getInfrator() {
		if (infrator == null)
			infrator = new Infrator();
		return infrator;
	}

	public void setInfrator(Infrator infrator) {
		this.infrator = infrator;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public String buscar() {
		infratores = infratorFacade.buscarInfrator(busca, busca, busca, busca);
		return null;
	}

	public List<Infrator> getInfratores() {
		return infratores;
	}

	public void setInfratores(List<Infrator> infratores) {
		this.infratores = infratores;
	}

	public String cadastrarInfrator() {
		return "cadastro_infrator";
	}

	public Date getHoje() {
		return new Date();
	}

	public Date getHojeMenos100anos() {
		Calendar menos100 = Calendar.getInstance();
		menos100.add(Calendar.YEAR, -100);
		return menos100.getTime();
	}

	public boolean dataDeNascimentoValida() {
		boolean valida = false;
		if (this.infrator.getDataNascimento().before(this.getHoje()))
			valida = true;
		return valida;
	}

	public String salvar() {

		if (!infratorFacade.buscarInfrator(null, infrator.getCpf(), null, null)
				.isEmpty()) {

			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("CPF já cadastrado");
			context.addMessage(null, message);
			return null;

		}
		endereco.setRua(this.getRua() + " " + this.getComplemento());
		List<Endereco> enderecos = new ArrayList<Endereco>();
		infrator.setEnderecos(enderecos);
		infrator.getEnderecos().add(endereco);
		infrator.setBiotipo(biotipo);
		if (filiacao.getDataNascimentoGenitora() == null)
			filiacao.setNomeGenitora("");
		if (filiacao.getNomeGenitor() == null)
			filiacao.setNomeGenitor("");
		infrator.setFiliacao(filiacao);
		infratorFacade.save(infrator);
		infrator = null;
		filiacao = null;
		biotipo = null;
		endereco = null;
		rua = null;
		complemento = null;
		return "index";
	}

	public boolean validarDataNascimento() {
		if (infrator.getDataNascimento().after(getHoje())
				|| infrator.getDataNascimento().before(getHojeMenos100anos()))
			return false;

		return true;
	}

}
