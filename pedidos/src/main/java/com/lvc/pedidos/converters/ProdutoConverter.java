package com.lvc.pedidos.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.lvc.pedidos.dao.BuscaDeProdutoDao;
import com.lvc.pedidos.model.Produto;

@FacesConverter(value="produtoConverter")
public class ProdutoConverter implements Converter {
	
	@Inject
	private BuscaDeProdutoDao dao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto produto = null;
		if(value != null && ! value.isEmpty()) {
			produto = dao.pesquisa(Long.parseLong(value));
		}
		return produto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			return ((Produto) value).getId()+"";
		}
		return null;
	}

}
