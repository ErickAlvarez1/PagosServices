package com.tokio.pagos.Been;

public class SolicitarPagoResponse {
	int code;
	String msg;
	String folio;
	String referencia;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	@Override
	public String toString() {
		return "SolicitarPagoResponse [code=" + code + ", msg=" + msg + ", folio=" + folio + ", referencia="
				+ referencia + "]";
	}
	
}
