package com.tokio.pagos.Been;

import java.util.List;

public class ListaAseguradoPD {
	List<AseguradoPD> listaCatClientesPD;

	public List<AseguradoPD> getListaCatClientesPD() {
		return listaCatClientesPD;
	}

	public void setListaCatClientesPD(List<AseguradoPD> listaCatClientesPD) {
		this.listaCatClientesPD = listaCatClientesPD;
	}

	@Override
	public String toString() {
		return "ListaAseguradoPD [listaCatClientesPD=" + listaCatClientesPD + "]";
	}

	
	
	
}
