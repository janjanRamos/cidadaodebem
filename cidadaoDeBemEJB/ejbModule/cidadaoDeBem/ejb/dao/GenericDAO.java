package cidadaoDeBem.ejb.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<T> {
	// unidade de persistência
	// mesmo valor específicado no persistence.xml
	private final static String UNIT_NAME = "cidadaoDeBemEM";

	@PersistenceContext(unitName = UNIT_NAME, type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	private Class<T> entityClass;

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	protected void delete(Object id, Class<T> classe) {
		T entityToBeRemoved = entityManager.getReference(classe, id);

		entityManager.remove(entityToBeRemoved);
	}

	public T update(T entity) {
		return entityManager.merge(entity);
	}

	public T find(int entityID) {
		return entityManager.find(entityClass, entityID);
	}

	// Query Generica pra retornar todos as entidades sem nenhum filtro
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return entityManager.createQuery(cq).getResultList();
	}

	// retornar um único valor com indeterminados filtros, implementado com um
	// map, o par chave/valor representa coluna/valor
	@SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;

		try {
			Query query = entityManager.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null
			// and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (T) query.getSingleResult();

		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	// retornar uma lista de resultados com indeterminados filtros, implementado
	// com um
	// map, o par chave/valor representa coluna/valor
	@SuppressWarnings("unchecked")
	protected List<T> filterResult(String namedQuery,
			Map<String, Object> parameters) {
		List<T> result = null;

		try {
			Query query = entityManager.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null
			// and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (List<T>) query.getResultList();

		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	// polular a qualquer query
	private void populateQueryParameters(Query query,
			Map<String, Object> parameters) {

		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

}
