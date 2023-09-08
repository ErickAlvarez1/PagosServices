package com.tokio.pagos.Been;

public class SimpleResponse {
	
	private int code;
	private String msg;
	private String folio;
	private int idCotizacion;
	private double tipoCambio;
	
	
	public double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
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
	public int getIdCotizacion() {
		return idCotizacion;
	}
	public void setIdCotizacion(int idCotizacion) {
		this.idCotizacion = idCotizacion;
	}
	@Override
	public String toString() {
		return "SimpleResponse [code=" + code + ", msg=" + msg + ", folio=" + folio + ", idCotizacion=" + idCotizacion
				+ "]";
	}

	
	
}
