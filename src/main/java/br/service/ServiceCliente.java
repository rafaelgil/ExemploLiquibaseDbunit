package br.service;

import br.domain.Cliente;

public interface ServiceCliente {
	
	public Cliente findById(Long id);
	
	public void salvar(Cliente cliente);

}
