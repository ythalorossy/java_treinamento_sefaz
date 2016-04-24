/**
 * 
 */
package br.com.ythalorossy.model.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com - http://yross.wordpress.com)
 */
@Entity
@Table(name = "evento")
@SequenceGenerator(name = "sq_evento_generator", sequenceName = "sq_evento", allocationSize=1)
public class Evento {

	@Id
	@GeneratedValue(generator = "sq_evento_generator", strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Column
	private Long notaFiscal;
	
	@OneToMany(mappedBy = "itemPK.evento", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ItemEvento> itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Long getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(Long notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public List<ItemEvento> getItens() {
		return itens;
	}

	public void setItens(List<ItemEvento> itens) {
		this.itens = itens;
	}
	
	
	
}
