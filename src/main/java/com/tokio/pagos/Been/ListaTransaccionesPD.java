/**
 * 
 */
package com.tokio.pagos.Been;

import java.util.List;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class ListaTransaccionesPD {
	List<TransaccionesPD> listaTransaccionesPD;

	public List<TransaccionesPD> getListaTransaccionesPD() {
		return listaTransaccionesPD;
	}

	public void setListaTransaccionesPD(List<TransaccionesPD> listaTransaccionesPD) {
		this.listaTransaccionesPD = listaTransaccionesPD;
	}

	@Override
	public String toString() {
		return "ListaTransaccionesPD [listaTransaccionesPD=" + listaTransaccionesPD + "]";
	}
	
}
