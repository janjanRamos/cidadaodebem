package cidadaoDeBem.ejb.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import cidadaoDeBem.ejb.dao.InfratorDAO;
import cidadaoDeBem.ejb.modelo.Infrator;

@Stateless
public class InfratorImpl implements InfratorFacade {
	@EJB
	private InfratorDAO infratorDAO;

	@Override
	public List<Infrator> buscarInfrator(String nome, String cpf,
			String apelido, String nomeGenitora) {
		// TODO Auto-generated method stub
		return infratorDAO.buscarInfrator(nome, cpf, apelido, nomeGenitora);
	}

	@Override
	public List<Infrator> buscarInfrator(String nome) {
		// TODO Auto-generated method stub
		return infratorDAO.buscarInfrator(nome);
	}

	private void isInfratorWithAllData(Infrator infrator) { // Verifica se o
															// Objeto trazido do
															// MnagedBean é do
															// tipo Infrator
		boolean hasError = false;

		if (infrator == null) {
			hasError = true;
		}

		if (infrator.getNome() == null || "".equals(infrator.getNome().trim())) {
			hasError = true;

		}

		if (hasError) {
			throw new IllegalArgumentException(
					"The Infrator is missing data. Check the name and weight, they should have value.");
		}
	}

	@Override
	public Infrator save(Infrator infrator) {
		// TODO Auto-generated method stub
		isInfratorWithAllData(infrator);
		infratorDAO.save(infrator);
		return infrator;
	}

	@Override
	public Infrator update(Infrator infrator) {
		// TODO Auto-generated method stub
		isInfratorWithAllData(infrator);
		infratorDAO.update(infrator);
		return infrator;
	}

}
