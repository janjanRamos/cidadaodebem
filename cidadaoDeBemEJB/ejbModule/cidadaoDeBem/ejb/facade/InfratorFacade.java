package cidadaoDeBem.ejb.facade;

import java.util.List;

import javax.ejb.Local;

import cidadaoDeBem.ejb.modelo.Infrator;

@Local
public interface InfratorFacade {

	public List<Infrator> buscarInfrator(String nome, String cpf,
			String apelido, String nomeGenitora);

	public List<Infrator> buscarInfrator(String nome);

	public Infrator save(Infrator infrator);

	public Infrator update(Infrator infrator);

}
