package cidadaoDeBem.ejb.facade;

import java.util.List;

import javax.ejb.Local;

import cidadaoDeBem.ejb.modelo.Policial;

@Local
public interface PolicialFacade {
	public Policial salvarPolicial(Policial policial);

	public List<Policial> BuscarPolicial(String nome, String matricula);

}
