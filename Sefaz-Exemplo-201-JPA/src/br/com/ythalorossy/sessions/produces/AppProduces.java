/**
 * 
 */
package br.com.ythalorossy.sessions.produces;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com - http://yross.wordpress.com)
 */
public class AppProduces {

	@PersistenceContext
	@Produces
	private EntityManager entityManager;
	
	@Produces
	public CriteriaBuilder createCriteriaBuilder(){
		
		return entityManager.getCriteriaBuilder();
	}
	
}
