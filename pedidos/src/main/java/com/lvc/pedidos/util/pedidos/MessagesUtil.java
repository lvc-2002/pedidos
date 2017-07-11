package com.lvc.pedidos.util.pedidos;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesUtil {
	
	public static void info(String summary, String detail) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		addMessage(msg);
	}
	
	public static void error(String summary, String detail) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
		addMessage(msg);
	}
	
	public static void fatal(String summary, String detail) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
		addMessage(msg);
	}
	
	public static void warn(String summary, String detail) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
		addMessage(msg);
	}
	
	private static void addMessage(FacesMessage msg) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, msg);
	}

}
