package com.tokio.pagos.Been;

import java.util.List;

public class PagosCatalogoResponse {
	List<PagosCatalogo> catalogo;
	PagosCatalogoRespuesta respuesta;
	
	public List<PagosCatalogo> getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(List<PagosCatalogo> catalogo) {
		this.catalogo = catalogo;
	}
	public PagosCatalogoRespuesta getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(PagosCatalogoRespuesta respuesta) {
		this.respuesta = respuesta;
	}
	@Override
	public String toString() {
		return "PagosCatalogoResponse [catalogo=" + catalogo + ", respuesta=" + respuesta + "]";
	}
}
