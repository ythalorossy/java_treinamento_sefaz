/**
 * 
 */
package br.com.ythalorossy.sessions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import br.com.ythalorossy.model.entities.Evento;
import br.com.ythalorossy.model.entities.EventoXML;
import br.com.ythalorossy.model.entities.ItemEvento;
import br.com.ythalorossy.model.entities.ItemEvento.ItemPK;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com - http://yross.wordpress.com)
 */
@Startup
@Singleton
@LocalBean
public class EventoBean extends AbstractBean {
	
//	@Inject private ItemEvento itemEvento;
//	@Inject private Evento evento;
	

	@PostConstruct
	private void validateJPA(){
		
		//persistEvento();
		
		//persistItems();
		
//		Evento eventoItem = new Evento();
//		eventoItem.setData(Calendar.getInstance());
//		eventoItem.setNotaFiscal(Calendar.getInstance().getTimeInMillis());
//
//		entityManager.persist(eventoItem);
//		
//		ItemEvento itemEvento = new ItemEvento();
//		itemEvento.setItemPK(new ItemPK());
//		itemEvento.setEvento(eventoItem);
//		itemEvento.getItemPK().setSequencialEvento(eventoItem.getId());
//		itemEvento.getItemPK().setNumeroItem(1L);
//		
//		List<ItemEvento> items = new ArrayList<ItemEvento>();
//		items.add(itemEvento);
//		
//		eventoItem.setItens(items);
//		
//		entityManager.merge(eventoItem);
//		
//		Evento eventoDb = entityManager.find(Evento.class, eventoItem.getId());
//		
//		for (ItemEvento item : eventoDb.getItens()) {
//			System.out.println(item.getItemPK().getNumeroItem());
//			
//		}

		EventoXML eventoXML = new EventoXML();

		Evento evento = new Evento();
		evento.setData(Calendar.getInstance());
		evento.setNotaFiscal(Calendar.getInstance().getTimeInMillis());
		
		ItemEvento itemEvento = new ItemEvento();
		
		itemEvento.setItemPK(new ItemPK());
		itemEvento.getItemPK().setEvento(evento);
		itemEvento.getItemPK().setNumeroItem(1L);
		
		List<ItemEvento> items = new ArrayList<ItemEvento>();
		items.add(itemEvento);
		
		evento.setItens(items);		

		eventoXML.setEvento(evento);
		
		entityManager.persist(eventoXML);
		
		EventoXML eventoXMLDB = entityManager.find(EventoXML.class, 1L);
		
		System.out.println("Item: " + eventoXMLDB.getEvento().getItens().get(0).getItemPK().getNumeroItem());
		
	}


	private void persistItems() {
//		itemEvento.getItemPK().setSequencialEvento(evento.getId());
//		itemEvento.getItemPK().setNumeroItem(1L);
//		
//		entityManager.persist(itemEvento);
	}

	private void persistEvento() {
//		evento.setData(Calendar.getInstance());
//		evento.setNotaFiscal(Calendar.getInstance().getTimeInMillis());
//		
//		entityManager.persist(evento);
	}

}
