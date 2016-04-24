package br.com.ythalorossy.sessions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import br.com.ythalorossy.model.entities.Contato;
import br.com.ythalorossy.model.entities.ContatoType;
import br.com.ythalorossy.model.entities.Pessoa;
import br.com.ythalorossy.model.entities.metamodels.Contato_;
import br.com.ythalorossy.model.entities.metamodels.Pessoa_;

@Startup
@Singleton
@LocalBean
public class PessoaBean extends AbstractBean<Pessoa> {

	public PessoaBean() {
	}
	
	public List<Pessoa> selectAllByModel() {
		
		CriteriaQuery<Pessoa> cq = criteriaBuilder.createQuery(Pessoa.class);
		
		Metamodel metamodel = entityManager.getMetamodel();
		
		EntityType<Pessoa> Pessoa_ = metamodel.entity(Pessoa.class);
		
		Root<Pessoa> pessoa = cq.from(Pessoa_);

		cq.select(pessoa);
		
		TypedQuery<Pessoa> typedQuery = entityManager.createQuery(cq);

		return typedQuery.getResultList();
	}

	public List<Pessoa> selectAllWithContatos() {

		CriteriaQuery<Pessoa> cq = criteriaBuilder.createQuery(Pessoa.class);
		
		Metamodel metamodel = entityManager.getMetamodel();
		
		EntityType<Pessoa> PessoaModel = metamodel.entity(Pessoa.class);
		
		Root<Pessoa> pessoa = cq.from(PessoaModel);

//		Join<Pessoa, Contato> contatos = pessoa.join(Pessoa_.contatos);
		
		TypedQuery<Pessoa> typedQuery = entityManager.createQuery(cq);

		return typedQuery.getResultList();
	}

	public List<Contato> selectAllContatoSemPessoa() {

		CriteriaQuery<Contato> cq = criteriaBuilder.createQuery(Contato.class);
		
		Metamodel metamodel = entityManager.getMetamodel();
		
		EntityType<Contato> contatoModel = metamodel.entity(Contato.class);
		
		Root<Contato> contato = cq.from(contatoModel);

		cq.where(contato.get(Contato_.pessoa).isNull());
		
		TypedQuery<Contato> typedQuery = entityManager.createQuery(cq);

		return typedQuery.getResultList();
	}
	
	
	@PostConstruct
	public void validateJPA() {
		
//		List<Contato> contatosSemPessoa = selectAllContatoSemPessoa();
//		for (Contato contato : contatosSemPessoa) {
//			entityManager.remove(contato);
//		}
		
		
//		Pessoa pessoa = new Pessoa();
//		Date date = new Date();
//		pessoa.setNome("YR" + date.toString());
//		pessoa.setSobrenome("SL" + date.toString());
//		
//		List<Contato> contatos = new ArrayList<Contato>();
//		contatos.add(new Contato(ContatoType.EMAIL, "ythalorssoy@gmail.com", pessoa));
//		
//		pessoa.setContatos(contatos);
//		
//		persist(pessoa);
		
		// Listagem de todos as pessoas
//		List<Pessoa> pessoas = findAll(Pessoa.class);
//		List<Pessoa> pessoas = selectAllByModel();
//		List<Pessoa> pessoas = selectAllWithContatos();
//		for (Pessoa p : pessoas) {
//			
//			System.out.println(p.getNome() + " " + p.getSobrenome());
//			
//			p.setNome(p.getNome().replaceAll("[0-9]", "X"));
//			p.setSobrenome(p.getSobrenome().replaceAll("[0-9]", "X"));
//			
//			for (Contato contato : p.getContatos()) {
//				System.out.println(" - " + contato.getValor());
//			}
//			
//			update(p);
//		}
		
//		if (pessoas.size() > 5) {
//			delete(pessoas.get(0));
//		}
	}
}
