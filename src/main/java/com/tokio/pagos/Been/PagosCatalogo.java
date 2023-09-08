package com.tokio.pagos.Been;

public class PagosCatalogo {
	int idCatalogoDetalle;
	String descripcion;
	String valor;
	public int getIdCatalogoDetalle() {
		return idCatalogoDetalle;
	}
	public void setIdCatalogoDetalle(int idCatalogoDetalle) {
		this.idCatalogoDetalle = idCatalogoDetalle;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "PagosCatalogo [idCatalogoDetalle=" + idCatalogoDetalle + ", descripcion=" + descripcion + ", valor="
				+ valor + "]";
	}
}
