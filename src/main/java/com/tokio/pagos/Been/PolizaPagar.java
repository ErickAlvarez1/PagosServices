package com.tokio.pagos.Been;

import com.google.gson.JsonObject;

public class PolizaPagar {

	String asegurado;
	String codigoAsegurado;
	String poliza;
	String certif;
	String numdoc;
	String recibo;
	float primaNeta;
	float iva;
	float recargos;
	float derechos;
	float reduccionPrima;
	float primaTotal;
	int moneda;
	ListaMoneda listaMoneda;
	String intencion;
	
	public String getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(String asegurado) {
		this.asegurado = asegurado;
	}

	public String getCodigoAsegurado() {
		return codigoAsegurado;
	}

	public void setCodigoAsegurado(String codigoAsegurado) {
		this.codigoAsegurado = codigoAsegurado;
	}

	public String getPoliza() {
		return poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
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

	public String getRecibo() {
		return recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}

	public float getPrimaNeta() {
		return primaNeta;
	}

	public void setPrimaNeta(float primaNeta) {
		this.primaNeta = primaNeta;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getRecargos() {
		return recargos;
	}

	public void setRecargos(float recargos) {
		this.recargos = recargos;
	}

	public float getDerechos() {
		return derechos;
	}

	public void setDerechos(float derechos) {
		this.derechos = derechos;
	}

	public float getReduccionPrima() {
		return reduccionPrima;
	}

	public void setReduccionPrima(float reduccionPrima) {
		this.reduccionPrima = reduccionPrima;
	}

	public float getPrimaTotal() {
		return primaTotal;
	}

	public void setPrimaTotal(float primaTotal) {
		this.primaTotal = primaTotal;
	}

	public int getMoneda() {
		return moneda;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public ListaMoneda getListaMoneda() {
		return listaMoneda;
	}

	public void setListaMoneda(ListaMoneda listaMoneda) {
		this.listaMoneda = listaMoneda;
	}

	public String getIntencion() {
		return intencion;
	}

	public void setIntencion(String intencion) {
		this.intencion = intencion;
	}

	public JsonObject toJsonObj() {
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("asegurado", asegurado); jsonObj.addProperty("codigoAsegurado", codigoAsegurado);
		jsonObj.addProperty("poliza", poliza); jsonObj.addProperty("certif", certif);
		jsonObj.addProperty("numdoc", numdoc); jsonObj.addProperty("recibo", recibo);
		jsonObj.addProperty("primaNeta", primaNeta); jsonObj.addProperty("iva", iva);
		jsonObj.addProperty("recargos", recargos); jsonObj.addProperty("derechos", derechos);
		jsonObj.addProperty("reduccionPrima", reduccionPrima); jsonObj.addProperty("primaTotal", primaTotal);
		jsonObj.addProperty("moneda", moneda); jsonObj.addProperty("moneda", moneda); jsonObj.addProperty("intencion", intencion);
		return jsonObj;
	}

	@Override
	public String toString() {
		return "PolizaPagar [asegurado=" + asegurado + ", codigoAsegurado=" + codigoAsegurado + ", poliza=" + poliza
				+ ", certif=" + certif + ", numdoc=" + numdoc + ", recibo=" + recibo + ", primaNeta=" + primaNeta
				+ ", iva=" + iva + ", recargos=" + recargos + ", derechos=" + derechos + ", reduccionPrima="
				+ reduccionPrima + ", primaTotal=" + primaTotal + ", moneda=" + moneda + ", listaMoneda=" + listaMoneda
				+ ", intencion=" + intencion + "]";
	}
	
}
