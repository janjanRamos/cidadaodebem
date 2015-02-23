package cidadaoDeBem.ejb.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mandado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String numeroMandado;
	private String numeroProcesso;
	private String situacao;
	private Date dataExpedicao;
	private Date datavalidade;
	private String regimeCumprimento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroMandado() {
		return numeroMandado;
	}

	public void setNumeroMandado(String numeroMandado) {
		this.numeroMandado = numeroMandado;
	}

	public String getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public Date getDatavalidade() {
		return datavalidade;
	}

	public void setDatavalidade(Date datavalidade) {
		this.datavalidade = datavalidade;
	}

	public String getRegimeCumprimento() {
		return regimeCumprimento;
	}

	public void setRegimeCumprimento(String regimeCumprimento) {
		this.regimeCumprimento = regimeCumprimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataExpedicao == null) ? 0 : dataExpedicao.hashCode());
		result = prime * result
				+ ((datavalidade == null) ? 0 : datavalidade.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((numeroMandado == null) ? 0 : numeroMandado.hashCode());
		result = prime * result
				+ ((numeroProcesso == null) ? 0 : numeroProcesso.hashCode());
		result = prime
				* result
				+ ((regimeCumprimento == null) ? 0 : regimeCumprimento
						.hashCode());
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
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
		Mandado other = (Mandado) obj;
		if (dataExpedicao == null) {
			if (other.dataExpedicao != null)
				return false;
		} else if (!dataExpedicao.equals(other.dataExpedicao))
			return false;
		if (datavalidade == null) {
			if (other.datavalidade != null)
				return false;
		} else if (!datavalidade.equals(other.datavalidade))
			return false;
		if (id != other.id)
			return false;
		if (numeroMandado == null) {
			if (other.numeroMandado != null)
				return false;
		} else if (!numeroMandado.equals(other.numeroMandado))
			return false;
		if (numeroProcesso == null) {
			if (other.numeroProcesso != null)
				return false;
		} else if (!numeroProcesso.equals(other.numeroProcesso))
			return false;
		if (regimeCumprimento == null) {
			if (other.regimeCumprimento != null)
				return false;
		} else if (!regimeCumprimento.equals(other.regimeCumprimento))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}

}
