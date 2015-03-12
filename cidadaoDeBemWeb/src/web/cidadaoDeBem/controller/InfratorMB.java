package web.cidadaoDeBem.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import web.cidadaoDeBem.enums.Estado;
import web.cidadaoDeBem.enums.RegimeDePena;
import web.cidadaoDeBem.utilitarios.ImagemUtil;
import cidadaoDeBem.ejb.facade.InfratorFacade;
import cidadaoDeBem.ejb.modelo.Biotipo;
import cidadaoDeBem.ejb.modelo.Endereco;
import cidadaoDeBem.ejb.modelo.Filiacao;
import cidadaoDeBem.ejb.modelo.Imagem;
import cidadaoDeBem.ejb.modelo.Infrator;
import cidadaoDeBem.ejb.modelo.Mandado;

@ManagedBean
@ViewScoped
public class InfratorMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private InfratorFacade infratorFacade;

	private Infrator infrator;
	private Biotipo biotipo;
	private Endereco endereco;
	private String complemento;
	private String rua;
	private Filiacao filiacao;
	private Mandado mandado;
	private List<Imagem> imagens;

	@ManagedProperty(value = "#{uploadMB}")
	private UploadMB uploadMB;

	// Strings de navegação
	public final String MOSTRAR_INFRATOR_CADASTRADO = "/protect/policial/feedBack_cadastrar_infrator.xhtml";

	public List<Imagem> getImagens() {
		if (imagens == null)
			imagens = new ArrayList<Imagem>();
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	// Modo uploadSimples
	// public UploadedFile getFile() {
	// return file;
	// }
	//
	// public void setFile(UploadedFile file) {
	// this.file = file;
	// }

	public Estado[] getEstados() {

		return Estado.values();
	}

	public RegimeDePena[] getRegimeDePena() {
		return RegimeDePena.values();
	}

	public Mandado getMandado() {
		if (mandado == null)
			mandado = new Mandado();
		return mandado;
	}

	public void setMandado(Mandado mandado) {
		this.mandado = mandado;
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

	public String cadastrarInfrator() {
		return "cadastro_infrator";
	}

	public Date getHoje() {
		return new Date();
	}

	public UploadMB getUploadMB() {
		return uploadMB;
	}

	public void setUploadMB(UploadMB uploadMB) {
		this.uploadMB = uploadMB;
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
		if (imagens == null)
			imagens = new ArrayList<Imagem>();
		if (!(uploadMB.getListaImageBytes() == null)) {
			imagens = ImagemUtil.handlePicture(this.uploadMB
					.getListaImageBytes());
			System.out.println(this.uploadMB.getListaImageBytes());
			infrator.setImagens(imagens);
		}
		infratorFacade.save(infrator);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage("Cadastro",
						"Cadastro do infrator Efetuado com Sucesso"));

		filiacao = null;
		biotipo = null;
		endereco = null;
		rua = null;
		complemento = null;

		return this.MOSTRAR_INFRATOR_CADASTRADO;
	}

	public boolean validarDataNascimento() {
		if (infrator.getDataNascimento().after(getHoje())
				|| infrator.getDataNascimento().before(getHojeMenos100anos()))
			return false;

		return true;
	}

	// tamanho máximos das imagens

	private static int Max_tamanho_imagem = 2 * 1024 * 1024;
	private static int Max_qtd_imagens = 3;

	public int getTamanhoMaximoImagem() {
		return Max_tamanho_imagem;

	}

	public int getQuantidadeMaximaImagens() {
		return Max_qtd_imagens;
	}
}
