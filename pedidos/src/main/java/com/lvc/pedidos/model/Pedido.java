package com.lvc.pedidos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@NotNull
	private Cliente cliente;
	
	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
	private List<Item> itens;
	
	public Pedido() {
		data = Calendar.getInstance();
		status = Status.ENCOMENDADO;
		itens = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", status=" + status + ", cliente=" + cliente + ", itens="
				+ itens + "]";
	}
	
	public void adiciona(Item item) {
		long numero = itens.size() + 1;
		item.setNumero(numero);
		item.setPedido(this);
		itens.add(item);
	}
	
	public boolean remove(Item item) {
		boolean resultado = itens.remove(item);
		long numero = 0;
		for(Item i : itens) {
			i.setNumero(++numero);
		}
		return resultado;
	}
	
	public Long getQuantidadeTotal() {
		Long total = 0L;
		if (!itens.isEmpty()) {
			for (Item i : itens) {
				total += i.getQuantidade();
			}
		}
		return total;
	}
	
	public Double getValorTotal() {
		return getQuantidadeTotal() * 20.00;
	}
	
}
