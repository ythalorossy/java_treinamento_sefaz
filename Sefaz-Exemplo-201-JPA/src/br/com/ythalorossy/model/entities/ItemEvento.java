/**
 * 
 */
package br.com.ythalorossy.model.entities;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
@Entity
@Table(name = "item_evento")
public class ItemEvento {

	@Inject
	@EmbeddedId private ItemPK itemPK;
	
	@Embeddable public static class ItemPK implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@ManyToOne
		@JoinColumn(name="seq_evento")
		private Evento evento;
		
		@Column(name = "num_item")
		private Long numeroItem;

		public Long getNumeroItem() {
			return numeroItem;
		}

		public void setNumeroItem(Long numeroItem) {
			this.numeroItem = numeroItem;
		}

		public Evento getEvento() {
			return evento;
		}

		public void setEvento(Evento evento) {
			this.evento = evento;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((evento == null) ? 0 : evento.hashCode());
			result = prime * result + ((numeroItem == null) ? 0 : numeroItem.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItemPK other = (ItemPK) obj;
			if (evento == null) {
				if (other.evento != null)
					return false;
			} else if (!evento.equals(other.evento))
				return false;
			if (numeroItem == null) {
				if (other.numeroItem != null)
					return false;
			} else if (!numeroItem.equals(other.numeroItem))
				return false;
			return true;
		}

		
	}

	public ItemPK getItemPK() {
		return itemPK;
	}

	public void setItemPK(ItemPK itemPK) {
		this.itemPK = itemPK;
	}
	
	
}
