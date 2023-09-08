/**
 * 
 */
package com.tokio.pagos.Been;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class TransaccionesPD {
	String noIngreso;
	String asegurado;
	String fechaPago;
	String referencia;
	String estatus;
	String cuenta;
	String moneda;
	Float montoTotal;
	String formaPago;
	String poliza;
	String endoso;
	String recibo;
	Float montoPrima;
	public String getNoIngreso() {
		return noIngreso;
	}
	public void setNoIngreso(String noIngreso) {
		this.noIngreso = noIngreso;
	}
	public String getAsegurado() {
		return asegurado;
	}
	public void setAsegurado(String asegurado) {
		this.asegurado = asegurado;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Float getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public String getEndoso() {
		return endoso;
	}
	public void setEndoso(String endoso) {
		this.endoso = endoso;
	}
	public String getRecibo() {
		return recibo;
	}
	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}
	public Float getMontoPrima() {
		return montoPrima;
	}
	public void setMontoPrima(Float montoPrima) {
		this.montoPrima = montoPrima;
	}
	@Override
	public String toString() {
		return "TransaccionesPD [noIngreso=" + noIngreso + ", asegurado=" + asegurado + ", fechaPago=" + fechaPago
				+ ", referencia=" + referencia + ", estatus=" + estatus + ", cuenta=" + cuenta + ", moneda=" + moneda
				+ ", montoTotal=" + montoTotal + ", formaPago=" + formaPago + ", poliza=" + poliza + ", endoso="
				+ endoso + ", recibo=" + recibo + ", montoPrima=" + montoPrima + "]";
	}
	
	
}
