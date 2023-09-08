/**
 * 
 */
package com.tokio.pagos.Been;

import com.google.gson.Gson;

import java.util.List;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class PagoReferencia {
	int idTransaccion;
	String folio;
	int idTipoMovimiento;
	int idEstatus;
	String fechaTransaccion;
	int tipoPago;
	String correo;
	List<PolizaPagar> listaPagoPolizas;

	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public int getIdTipoMovimiento() {
		return idTipoMovimiento;
	}

	public void setIdTipoMovimiento(int idTipoMovimiento) {
		this.idTipoMovimiento = idTipoMovimiento;
	}

	public int getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(String fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public int getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(int tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<PolizaPagar> getListaPagoPolizas() {
		return listaPagoPolizas;
	}

	public void setListaPagoPolizas(List<PolizaPagar> listaPagoPolizas) {
		this.listaPagoPolizas = listaPagoPolizas;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this).toString();
	}

}
