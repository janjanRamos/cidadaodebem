package cidadaoDeBem.ejb.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ @NamedQuery(name = "BuscarInfratores", query = "select i from Infrator as i where i.nome LIKE :nome"
		+ " or  i.cpf LIKE :cpf" + " or i.apelido LIKE :apelido"
// + " or i.filiacao.nomeGenitora LIKE :nomeGenitora"
), })
public class Infrator implements Serializable {

	public static final String BUSCAR_INFRATORES = "BuscarInfratores";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private Date dataNascimento;
	private String apelido;
	private String orgaoExpeditorRG;
	private String ufRG;
	private String nacionalidade;
	private String naturalidade;

	@OneToOne(cascade = CascadeType.ALL)
	private Biotipo biotipo;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	@OneToOne(cascade = CascadeType.ALL)
	private Filiacao filiacao;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Mandado> mandados;
	@OneToMany(cascade = CascadeType.ALL)
	private List<MarcaCorporal> marcasCorporais;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Imagem> imagens;

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Biotipo getBiotipo() {
		return biotipo;
	}

	public void setBiotipo(Biotipo biotipo) {
		this.biotipo = biotipo;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Filiacao getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}

	public List<Mandado> getMandados() {
		return mandados;
	}

	public void setMandados(List<Mandado> mandados) {
		this.mandados = mandados;
	}

	public List<MarcaCorporal> getMarcasCorporais() {
		return marcasCorporais;
	}

	public void setMarcasCorporais(List<MarcaCorporal> marcasCorporais) {
		this.marcasCorporais = marcasCorporais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getOrgaoExpeditorRG() {
		return orgaoExpeditorRG;
	}

	public void setOrgaoExpeditorRG(String orgaoExpeditorRG) {
		this.orgaoExpeditorRG = orgaoExpeditorRG;
	}

	public String getUfRG() {
		return ufRG;
	}

	public void setUfRG(String ufRG) {
		this.ufRG = ufRG;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((biotipo == null) ? 0 : biotipo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result
				+ ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result
				+ ((filiacao == null) ? 0 : filiacao.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((mandados == null) ? 0 : mandados.hashCode());
		result = prime * result
				+ ((marcasCorporais == null) ? 0 : marcasCorporais.hashCode());
		result = prime * result
				+ ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result
				+ ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((orgaoExpeditorRG == null) ? 0 : orgaoExpeditorRG.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((ufRG == null) ? 0 : ufRG.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Infrator other = (Infrator) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (biotipo == null) {
			if (other.biotipo != null)
				return false;
		} else if (!biotipo.equals(other.biotipo))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (filiacao == null) {
			if (other.filiacao != null)
				return false;
		} else if (!filiacao.equals(other.filiacao))
			return false;
		if (id != other.id)
			return false;
		if (mandados == null) {
			if (other.mandados != null)
				return false;
		} else if (!mandados.equals(other.mandados))
			return false;
		if (marcasCorporais == null) {
			if (other.marcasCorporais != null)
				return false;
		} else if (!marcasCorporais.equals(other.marcasCorporais))
			return false;
		if (nacionalidade == null) {
			if (other.nacionalidade != null)
				return false;
		} else if (!nacionalidade.equals(other.nacionalidade))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (orgaoExpeditorRG == null) {
			if (other.orgaoExpeditorRG != null)
				return false;
		} else if (!orgaoExpeditorRG.equals(other.orgaoExpeditorRG))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (ufRG == null) {
			if (other.ufRG != null)
				return false;
		} else if (!ufRG.equals(other.ufRG))
			return false;
		return true;
	}

}
