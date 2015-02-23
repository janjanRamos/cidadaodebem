package cidadaoDeBem.ejb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import cidadaoDeBem.ejb.modelo.Infrator;

@Stateless
public class InfratorDAO extends GenericDAO<Infrator> {

	public InfratorDAO() {
		super(Infrator.class);
		// TODO Auto-generated constructor stub
	}

	public void delete(Infrator infrator) {
		// TODO Auto-generated method stub
		super.delete(infrator.getId(), Infrator.class);
	}

	public List<Infrator> buscarInfrator(String nome, String cpf,
			String apelido, String nomeGenitora) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		nome = "%" + nome + "%";
		cpf = "%" + cpf + "%";
		apelido = "%" + apelido + "%";
		nomeGenitora = "%" + nomeGenitora + "%";

		parameters.put("nome", nome);
		parameters.put("cpf", cpf);
		parameters.put("apelido", apelido);
		// parameters.put("nomeGenitora", nomeGenitora);

		return super.filterResult(Infrator.BUSCAR_INFRATORES, parameters);

	}

	public List<Infrator> buscarInfrator(String nome) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		nome = "%" + nome + "%";
		parameters.put("nome", nome);
		System.out.println(nome);
		return super.filterResult(Infrator.BUSCAR_INFRATORES, parameters);
	}
}
