package com.tokio.pagos.Been;

public class ListaMoneda {
	int idMoneda;
	String descripcion;
	public int getIdMoneda() {
		return idMoneda;
	}
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "{\"idMoneda\":\"" + idMoneda + "\", \"descripcion\":\"" + descripcion + "\"}";
	}
}
