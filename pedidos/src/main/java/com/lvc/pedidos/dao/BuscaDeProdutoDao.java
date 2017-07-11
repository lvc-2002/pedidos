package com.lvc.pedidos.dao;

import java.util.List;

import com.lvc.pedidos.model.Produto;

public interface BuscaDeProdutoDao {
	
	public Produto pesquisa(Long id);
	
	public List<Produto> pesquisa(String descricao);

}
