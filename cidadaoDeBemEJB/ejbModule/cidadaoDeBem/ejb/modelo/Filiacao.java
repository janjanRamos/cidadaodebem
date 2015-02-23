package cidadaoDeBem.ejb.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filiacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nomeGenitora;
	private String nomeGenitor;
	private Date dataNascimentoGenitora;
	private Date dataNascimentoGenitor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeGenitora() {
		return nomeGenitora;
	}

	public void setNomeGenitora(String nomeGenitora) {
		this.nomeGenitora = nomeGenitora;
	}

	public String getNomeGenitor() {
		return nomeGenitor;
	}

	public void setNomeGenitor(String nomeGenitor) {
		this.nomeGenitor = nomeGenitor;
	}

	public Date getDataNascimentoGenitora() {
		return dataNascimentoGenitora;
	}

	public void setDataNascimentoGenitora(Date dataNascimentoGenitora) {
		this.dataNascimentoGenitora = dataNascimentoGenitora;
	}

	public Date getDataNascimentoGenitor() {
		return dataNascimentoGenitor;
	}

	public void setDataNascimentoGenitor(Date dataNascimentoGenitor) {
		this.dataNascimentoGenitor = dataNascimentoGenitor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataNascimentoGenitor == null) ? 0 : dataNascimentoGenitor
						.hashCode());
		result = prime
				* result
				+ ((dataNascimentoGenitora == null) ? 0
						: dataNascimentoGenitora.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((nomeGenitor == null) ? 0 : nomeGenitor.hashCode());
		result = prime * result
				+ ((nomeGenitora == null) ? 0 : nomeGenitora.hashCode());
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
		Filiacao other = (Filiacao) obj;
		if (dataNascimentoGenitor == null) {
			if (other.dataNascimentoGenitor != null)
				return false;
		} else if (!dataNascimentoGenitor.equals(other.dataNascimentoGenitor))
			return false;
		if (dataNascimentoGenitora == null) {
			if (other.dataNascimentoGenitora != null)
				return false;
		} else if (!dataNascimentoGenitora.equals(other.dataNascimentoGenitora))
			return false;
		if (id != other.id)
			return false;
		if (nomeGenitor == null) {
			if (other.nomeGenitor != null)
				return false;
		} else if (!nomeGenitor.equals(other.nomeGenitor))
			return false;
		if (nomeGenitora == null) {
			if (other.nomeGenitora != null)
				return false;
		} else if (!nomeGenitora.equals(other.nomeGenitora))
			return false;
		return true;
	}

}
