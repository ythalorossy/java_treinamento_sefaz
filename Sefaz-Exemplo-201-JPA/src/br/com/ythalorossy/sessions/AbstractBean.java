/**
 * 
 */
package br.com.ythalorossy.sessions;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
public class AbstractBean<T> {

	@Inject
	protected EntityManager entityManager;

	@Inject
	protected CriteriaBuilder criteriaBuilder;

	public AbstractBean() {
		super();
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public List<T> findAll(Class<T> clazz) {

		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);

		Root<T> entity = criteriaQuery.from(clazz);

		criteriaQuery.select(entity);

		TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);

		return typedQuery.getResultList();
	}

	public T findById(Class<T> clazz, Object id) {
		return entityManager.find(clazz, id);
	}

}