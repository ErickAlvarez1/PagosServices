/**
 * 
 */
package com.tokio.pagos.Been;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class ListaPagadoresPPP {
	String pagador;
	String rfc;
	String uuid;
	String referencia;
	Float valor;
	public String getPagador() {
		return pagador;
	}
	public void setPagador(String pagador) {
		this.pagador = pagador;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "ListaPagadoresPPP [pagador=" + pagador + ", rfc=" + rfc + ", uuid=" + uuid + ", referencia="
				+ referencia + ", valor=" + valor + "]";
	}
	
	
	
}
