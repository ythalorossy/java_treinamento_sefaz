/**
 * 
 */
package br.com.ythalorossy.model.entities.metamodels;

import javax.persistence.metamodel.SingularAttribute;

import br.com.ythalorossy.model.entities.Contato;
import br.com.ythalorossy.model.entities.ContatoType;
import br.com.ythalorossy.model.entities.Pessoa;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
public class Contato_ {

	public static volatile SingularAttribute<Contato, Integer> id;
	public static volatile SingularAttribute<Contato, ContatoType> tipo;
	public static volatile SingularAttribute<Contato, String> valor;
	public static volatile SingularAttribute<Contato, Pessoa> pessoa;
}
