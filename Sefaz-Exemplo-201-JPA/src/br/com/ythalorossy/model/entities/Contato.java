/**
 * 
 */
package br.com.ythalorossy.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
@Entity
@Table(name = "contatos")
@SequenceGenerator(name = "sq_contato", sequenceName = "sq_contato")
public class Contato {

	@Id
	@GeneratedValue(generator = "sq_contato", strategy = GenerationType.AUTO)
	private Integer id;

	public Contato() {
	}
	
	public Contato(ContatoType tipo, String valor, Pessoa pessoa) {
		this.tipo = tipo;
		this.valor = valor;
		this.pessoa = pessoa;
	}

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo")
	private ContatoType tipo;

	@Column
	private String valor;

	@ManyToOne
	private Pessoa pessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ContatoType getTipo() {
		return tipo;
	}

	public void setTipo(ContatoType tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
