package br.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.domain.Cliente;

@Repository
public class RepositoryClienteImpl implements RepositoryCliente {

	@Autowired
	private SessionFactory sessionFactory;

	public Cliente findById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Cliente.class, "cliente");
		if(id!=null){
			criteria.add(Restrictions.eq("codigo", id));
		}	
		Cliente cliente = (Cliente)criteria.uniqueResult();
		
		return cliente;
	}

	public void salvar(Cliente cliente) {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(cliente);
		session.flush();

	}

}
