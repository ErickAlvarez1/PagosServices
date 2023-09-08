package com.tokio.pagos.Been;

import java.util.List;

public class ListaCatClientesPD {
	List<PersonaPD> listaCatClientesPD;

	public List<PersonaPD> getListaCatClientesPD() {
		return listaCatClientesPD;
	}

	public void setListaCatClientesPD(List<PersonaPD> listaCatClientesPD) {
		this.listaCatClientesPD = listaCatClientesPD;
	}

	@Override
	public String toString() {
		return "ListaCatClientesPD [listaCatClientesPD=" + listaCatClientesPD + "]";
	}

}
