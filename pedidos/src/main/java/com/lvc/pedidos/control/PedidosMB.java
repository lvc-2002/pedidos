package com.lvc.pedidos.control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lvc.pedidos.dao.BuscaDeClienteDao;
import com.lvc.pedidos.dao.BuscaDeProdutoDao;
import com.lvc.pedidos.model.Cliente;
import com.lvc.pedidos.model.Pedido;
import com.lvc.pedidos.model.Produto;

@Named
@ViewScoped
public class PedidosMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private BuscaDeClienteDao clienteDao;
	
	@Inject
	private BuscaDeProdutoDao produtoDao;
	
	private Pedido pedido;
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@PostConstruct
	public void init() {
		pedido = new Pedido();
	}
	
	public List<Cliente> buscaCliente(String nome) {
		return clienteDao.pesquisa(nome);
	}
	
	public List<Produto> buscaProduto(String descricao) {
		return produtoDao.pesquisa(descricao);
	}

}
