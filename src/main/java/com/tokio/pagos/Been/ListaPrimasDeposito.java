/**
 * 
 */
package com.tokio.pagos.Been;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class ListaPrimasDeposito {
	String formaPago;
	String folio;
	String referencia;
	String concepto;
	String monto;
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
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
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "ListaPrimasDeposito [formaPago=" + formaPago + ", folio=" + folio + ", referencia=" + referencia
				+ ", concepto=" + concepto + ", monto=" + monto + "]";
	}
	
}
