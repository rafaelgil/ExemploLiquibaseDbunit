package br.repository;

import br.domain.Cliente;

public interface RepositoryCliente {

	public Cliente findById(Long id);

	public void salvar(Cliente cliente);

}
