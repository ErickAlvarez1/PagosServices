/**
 * 
 */
package com.tokio.pagos.Been;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class Estatus {
	private String idMovimiento;
	private String idTransaccion;
	private String folio;
	private int codigoEstatus;
	private String descripcion;
	
	public String getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(String idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public int getCodigoEstatus() {
		return codigoEstatus;
	}
	public void setCodigoEstatus(int codigoEstatus) {
		this.codigoEstatus = codigoEstatus;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Estatus [idMovimiento=" + idMovimiento + ", idTransaccion=" + idTransaccion + ", folio=" + folio
				+ ", codigoEstatus=" + codigoEstatus + ", descripcion=" + descripcion + "]";
	}

}
