/**
 * 
 */
package br.com.ythalorossy.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
@Entity
@Table(name = "pessoa")
@SequenceGenerator(sequenceName = "sq_pessoa", name = "sq_pessoa", allocationSize = 1)
public class Pessoa {

	@Id
	@GeneratedValue(generator = "sq_pessoa", strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String nome;
	@Column
	private String sobrenome;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "pessoa")
	private List<Contato> contatos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}
