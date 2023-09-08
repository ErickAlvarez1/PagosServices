/**
 * 
 */
package com.tokio.pagos.Been;

import java.util.List;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class ResponsePrimasPendientesPago {
	String tipoPago;
	List<ListarPimasPendientesPago>listaPrimasPendientesPago;
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public List<ListarPimasPendientesPago> getListaPrimasPendientesPago() {
		return listaPrimasPendientesPago;
	}
	public void setListaPrimasPendientesPago(List<ListarPimasPendientesPago> listaPrimasPendientesPago) {
		this.listaPrimasPendientesPago = listaPrimasPendientesPago;
	}
	@Override
	public String toString() {
		return "ResponsePrimasPendientesPago [tipoPago=" + tipoPago + ", listaPrimasPendientesPago="
				+ listaPrimasPendientesPago + "]";
	}
		
}
