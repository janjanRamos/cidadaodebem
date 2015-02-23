package cidadaoDeBem.ejb.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import cidadaoDeBem.ejb.dao.PolicialDAO;
import cidadaoDeBem.ejb.modelo.Policial;

@Stateless
public class PolicialImpl implements PolicialFacade {

	@EJB
	private PolicialDAO policiaoDAO;

	private void isPolicialWithAllData(Policial policial) { // Verifica se o
		// Objeto trazido do
		// MnagedBean é do
		// tipo Polcial
		boolean hasError = false;

		if (policial == null) {
			hasError = true;
		}

		if (policial.getNome() == null || "".equals(policial.getNome().trim())) {
			hasError = true;

		}

		if (hasError) {
			throw new IllegalArgumentException(
					"The Policial is missing data. Check the name and weight, they should have value.");
		}
	}

	@Override
	public Policial salvarPolicial(Policial policial) {
		// TODO Auto-generated method stub
		isPolicialWithAllData(policial);
		policiaoDAO.save(policial);
		return policial;
	}

	@Override
	public List<Policial> BuscarPolicial(String nome, String matricula) {
		// TODO Auto-generated method stub

		return policiaoDAO.buscarPolicial(nome, matricula);
	}

}
