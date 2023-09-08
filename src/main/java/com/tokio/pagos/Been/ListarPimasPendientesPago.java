/**
 * 
 */
package com.tokio.pagos.Been;

import java.util.List;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class ListarPimasPendientesPago {
	String cuota;
	String concepto;
	String certif;
	String numdoc;
	Float valor;
	String moneda;
	List<ListaPagadoresPPP> listaPagadores;
	public String getCuota() {
		return cuota;
	}
	public void setCuota(String cuota) {
		this.cuota = cuota;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getCertif() {
		return certif;
	}
	public void setCertif(String certif) {
		this.certif = certif;
	}
	public String getNumdoc() {
		return numdoc;
	}
	public void setNumdoc(String numdoc) {
		this.numdoc = numdoc;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public List<ListaPagadoresPPP> getListaPagadores() {
		return listaPagadores;
	}
	public void setListaPagadores(List<ListaPagadoresPPP> listaPagadores) {
		this.listaPagadores = listaPagadores;
	}
	@Override
	public String toString() {
		return "ListarPimasPendientesPago [cuota=" + cuota + ", concepto=" + concepto + ", certif=" + certif
				+ ", numdoc=" + numdoc + ", valor=" + valor + ", moneda=" + moneda + ", listaPagadores="
				+ listaPagadores + "]";
	}
	
	
}
