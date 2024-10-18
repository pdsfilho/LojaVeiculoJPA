package br.com.fuctura.jpa.Interfaces;

import br.com.fuctura.jpa.models.Cliente;

public interface ClienteInterface {
	public void insert(Cliente cliente);
	public Cliente findById(Integer id);
	public Cliente findByCpf(String cpf);
	public void update(Cliente cliente);
	public void delete(Cliente cliente);
}
