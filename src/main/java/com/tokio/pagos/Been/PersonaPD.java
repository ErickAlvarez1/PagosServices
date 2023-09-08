package com.tokio.pagos.Been;

public class PersonaPD {
	String codigo;
	String descripcion;
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
	@Override
	public String toString() {
		return "PersonaPD [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
}
