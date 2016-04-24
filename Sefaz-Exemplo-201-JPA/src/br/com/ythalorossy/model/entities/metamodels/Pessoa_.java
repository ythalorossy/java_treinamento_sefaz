package br.com.ythalorossy.model.entities.metamodels;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.com.ythalorossy.model.entities.Contato;
import br.com.ythalorossy.model.entities.Pessoa;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
@StaticMetamodel(value = Pessoa.class)
public class Pessoa_ {

	public static volatile SingularAttribute<Pessoa, Integer> id;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile SingularAttribute<Pessoa, String> sobrenome;
	public static volatile SetAttribute<Pessoa, Contato> contatos;
}
