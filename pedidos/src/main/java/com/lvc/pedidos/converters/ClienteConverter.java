package com.lvc.pedidos.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import com.lvc.pedidos.dao.BuscaDeClienteDao;
import com.lvc.pedidos.model.Cliente;

public class ClienteConverter implements Converter {
	
	@Inject
	private BuscaDeClienteDao dao;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cliente cliente = null;
		if(value != null & ! value.isEmpty()) {
			cliente = dao.pesquisa(Long.parseLong(value)); 
		}
		return cliente;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			return ((Cliente) value).getId()+"";
		}
		return null;
	}

}
