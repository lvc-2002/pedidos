package com.lvc.pedidos.dao;

import java.util.List;

import com.lvc.pedidos.model.Cliente;

public interface BuscaDeClienteDao {
	
	public Cliente pesquisa(Long id);
	
	public List<Cliente> pesquisa(String nome);

}
