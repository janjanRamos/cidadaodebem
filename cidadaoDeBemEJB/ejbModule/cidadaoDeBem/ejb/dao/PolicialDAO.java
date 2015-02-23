package cidadaoDeBem.ejb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import cidadaoDeBem.ejb.modelo.Policial;

@Stateless
public class PolicialDAO extends GenericDAO<Policial> {

	public PolicialDAO() {
		super(Policial.class);
		// TODO Auto-generated constructor stub
	}

	public void delete(Policial policial) {
		// TODO Auto-generated method stub
		super.delete(policial.getId(), Policial.class);
	}

	public List<Policial> buscarPolicial(String nome, String matricula) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nome", nome);
		parameters.put("matricula", matricula);
		return super.filterResult(Policial.BUSCAR_POLICIAIS, parameters);
	}

}
