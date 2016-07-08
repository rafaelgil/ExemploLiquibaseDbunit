package br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.domain.Cliente;
import br.repository.RepositoryCliente;

@Service
@Transactional
public class ServiceClienteImpl implements ServiceCliente {

	@Autowired
	private RepositoryCliente repositoryCliente;
	
	public Cliente findById(Long id) {
		return repositoryCliente.findById(id);
	}

	public void salvar(Cliente cliente) {
		repositoryCliente.salvar(cliente);
	}

}
