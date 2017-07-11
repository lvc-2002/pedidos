package com.lvc.pedidos.model;

public enum Status {
	
	ENCOMENDADO("Encomendado"),
	EM_PRODUCAO("Em Produção"),
	EM_CONFERENCIA("Em Conferência"),
	FINALIZADO("Finalizado"),
	ENTREGUE("Entregue");
	
	private String descricao;
	
	private Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
