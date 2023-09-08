package com.tokio.pagos;

import com.tokio.pagos.Been.Estatus;
import com.tokio.pagos.Been.ListaAseguradoPD;
import com.tokio.pagos.Been.ListaCatClientesPD;
import com.tokio.pagos.Been.ListaPolizasPendientesPagoResponse;
import com.tokio.pagos.Been.ListaRegistro;
import com.tokio.pagos.Been.ListaTransaccionesPD;
import com.tokio.pagos.Been.PagoReferencia;
import com.tokio.pagos.Been.PagosCatalogoResponse;
import com.tokio.pagos.Been.PolizaPagar;
import com.tokio.pagos.Been.ResponsePrimasDeposito;
import com.tokio.pagos.Been.ResponsePrimasPendientesPago;
import com.tokio.pagos.Been.SimpleResponse;
import com.tokio.pagos.Been.SolicitarPagoResponse;
import com.tokio.pagos.Been.ValidaResponse;
import com.tokio.pagos.Exception.PagosException;

import java.util.List;

public interface PagosServices {
	
	public ValidaResponse wsActualizarEstatus(Estatus estatus)throws PagosException;
	
	public SolicitarPagoResponse wsSolicitarPago(  int idTransaccion, String folio,
			 int idTipoMovimiento, int idEstatus, String fechaTransaccion, int tipoPago, String correo, List<PolizaPagar> polizas,
			String usuario, String pantalla, String modulo)throws PagosException;
	
	public ListaPolizasPendientesPagoResponse wsListaPolizasPendientesPago(  String poliza, String codigoCliente,
			 String monto, int tipoPago, int idMoneda,
			String usuario, String pantalla, String modulo)throws PagosException;
	
	public SimpleResponse getTipoCambio( )throws PagosException;
	
	public PagosCatalogoResponse wsPagosCatalogo(String codigo, int activo, String usuario, String pantalla,
			String modulo) throws PagosException;
	
	public SolicitarPagoResponse wsSolicitarPagoReferencia(PagoReferencia referencia, String usuario, String pantalla) throws PagosException;
	
	public ListaCatClientesPD wsCatClientesPD() throws PagosException;
	
	public ResponsePrimasDeposito wsPrimasDeposito(String codigoCliente, String usuario, String pantalla) throws PagosException;
	
	public ResponsePrimasPendientesPago wsPrimasPendientesPago(String poliza, String usuario, String pantalla) throws PagosException;
	
	public SimpleResponse wsAplicarCobranza(String cobranza) throws PagosException;
	
	public ListaRegistro getCatalogo(String p_codigo, String p_usuario, String p_pantalla)
			throws PagosException;
	
	public ListaAseguradoPD wsCatAseguradosPD() throws PagosException;
	
	public ListaTransaccionesPD wslistaPagosPD(String codigo, String fechaInicial, String fechaFinal, int estatus,
			String mUsuario, String mPantalla) throws PagosException;

}
