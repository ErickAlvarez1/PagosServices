/**
 * 
 */
package com.tokio.pagos.Been;

import java.util.List;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class ResponsePrimasDeposito {
	String codigo;
	String descripcion;
	List<ListaPrimasDeposito> listaPrimasDeposito;
	List<ListaPolizasPD> listaPolizas;
	Metadatos metadatos;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<ListaPrimasDeposito> getListaPrimasDeposito() {
		return listaPrimasDeposito;
	}
	public void setListaPrimasDeposito(List<ListaPrimasDeposito> listaPrimasDeposito) {
		this.listaPrimasDeposito = listaPrimasDeposito;
	}
	public List<ListaPolizasPD> getListaPolizas() {
		return listaPolizas;
	}
	public void setListaPolizas(List<ListaPolizasPD> listaPolizas) {
		this.listaPolizas = listaPolizas;
	}
	public Metadatos getMetadatos() {
		return metadatos;
	}
	public void setMetadatos(Metadatos metadatos) {
		this.metadatos = metadatos;
	}
	@Override
	public String toString() {
		return "ResponsePrimasDeposito [codigo=" + codigo + ", descripcion=" + descripcion + ", listaPrimasDeposito="
				+ listaPrimasDeposito + ", listaPolizas=" + listaPolizas + ", metadatos=" + metadatos + "]";
	}
	
}
