/**
 * 
 */
package br.com.ythalorossy.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
@Entity
@Table(name = "evento_xml")
@SequenceGenerator(name = "sq_evento_xml_generator", sequenceName = "sq_evento_xml", allocationSize = 1)
public class EventoXML {

	@Id
	@GeneratedValue(generator = "sq_evento_xml_generator", strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Evento evento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
