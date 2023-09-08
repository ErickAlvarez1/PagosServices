package com.tokio.pagos.Been;

import java.util.List;

public class ListaPolizasPendientesPagoResponse {
	int code;
	List<PolizaPagar> catalogo;
	PagosCatalogoRespuesta respuesta;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<PolizaPagar> getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(List<PolizaPagar> catalogo) {
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
		return "ListaPolizasPendientesPagoResponse [code=" + code + ", catalogo=" + catalogo + ", respuesta="
				+ respuesta + "]";
	}
}
