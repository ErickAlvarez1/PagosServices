/**
 * 
 */
package com.tokio.pagos.Been;

import java.util.List;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class ListaRegistro {
	List<Registro> lista;
	int totalRow;
	public List<Registro> getLista() {
		return lista;
	}
	public void setLista(List<Registro> lista) {
		this.lista = lista;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	@Override
	public String toString() {
		return "ListaRegistro [lista=" + lista + ", totalRow=" + totalRow + "]";
	}
	
	
	
}
