package com.lvc.pedidos.control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lvc.pedidos.dao.BuscaDeClienteDao;
import com.lvc.pedidos.dao.BuscaDeProdutoDao;
import com.lvc.pedidos.dao.PedidoDao;
import com.lvc.pedidos.model.Cliente;
import com.lvc.pedidos.model.Item;
import com.lvc.pedidos.model.Pedido;
import com.lvc.pedidos.model.Produto;
import com.lvc.pedidos.util.jpa.Transactional;
import com.lvc.pedidos.util.pedidos.MessagesUtil;

@Named
@ViewScoped
public class PedidosMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private BuscaDeClienteDao clienteDao;
	
	@Inject
	private BuscaDeProdutoDao produtoDao;
	
	@Inject
	private PedidoDao pedidoDao;
	
	private Pedido pedido;
	
	private Item item;
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	@PostConstruct
	public void init() {
		pedido = new Pedido();
		item = new Item();
	}
	
	public List<Cliente> buscaCliente(String nome) {
		return clienteDao.pesquisa(nome);
	}
	
	public List<Produto> buscaProduto(String descricao) {
		return produtoDao.pesquisa(descricao);
	}
	
	public void adicionaItem() {
		pedido.adiciona(item);
		item = new Item();
	}
	
	public void removeItem() {
		if(pedido.remove(item)) {
			MessagesUtil.info("Item removido com sucesso!", null);
		}else {
			MessagesUtil.error("Erro ao remover item!", null);
		}
	}
	
	public Long getQuantidadeTotalDePedidos() {
		Long total = 0L;
		for(Item i : pedido.getItens()) {
			total += i.getQuantidade();
		}
		return total;
	}
	
	// FIXME Cálculo do Valor Total do Pedido
	public Double getValorTotalDoPedido() {
		return getQuantidadeTotalDePedidos() * 20.00;
	}
	
	@Transactional
	public void salvaPedido() {
		pedidoDao.salva(pedido);
		MessagesUtil.info("Pedido cadastrado com sucesso!", null);
		init();
	}
	
}
