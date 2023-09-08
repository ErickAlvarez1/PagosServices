package com.tokio.pagos.Impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.tokio.pagos.PagosServices;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {

}, service = PagosServices.class)
public class PagosServicesImpl implements PagosServices {

	private static final Log _log = LogFactoryUtil.getLog(PagosServicesImpl.class);
	String host = PropsUtil.get("ambiente.configuracion.host");
	String puerto = PropsUtil.get("ambiente.configuracion.puerto");
	int contadorPeticion = 0;

	public ValidaResponse wsActualizarEstatus(Estatus estatus) throws PagosException {
		String direction = "/PaginaWeb/wsActualizarEstatus";
		String webservice = "wsActualizarEstatus";

		JsonObject request = new JsonObject();
		request.addProperty("idMovimiento", estatus.getIdMovimiento());
		request.addProperty("idTransaccion", estatus.getIdTransaccion());
		request.addProperty("folio", estatus.getFolio());
		request.addProperty("codigoEstatus", estatus.getCodigoEstatus());

		JsonObject meta = new JsonObject();
		meta.addProperty("rowNum", 0);
		meta.addProperty("mUsuario", "");
		meta.addProperty("mModulo", "Pago Poliza");
		meta.addProperty("mWebService", webservice);
		meta.addProperty("mPantalla", "Pago Póliza");
		meta.addProperty("mParametros", "");

		request.add("metadatos", meta);
		ValidaResponse actualiza = (ValidaResponse) getObjResponse(direction, request.toString(), ValidaResponse.class);

		return actualiza;
	}

	public SolicitarPagoResponse wsSolicitarPago(int idTransaccion, String folio, int idTipoMovimiento, int idEstatus,
			String fechaTransaccion, int tipoPago, String correo, List<PolizaPagar> polizas, String usuario,
			String pantalla, String modulo) throws PagosException {

		String direction = "/PaginaWeb/wsSolicitarPago";
		String webservice = "wsSolicitarPago";

		JsonObject request = new JsonObject();
		request.addProperty("idTransaccion", idTransaccion);
		request.addProperty("folio", folio);
		request.addProperty("idTipoMovimiento", idTipoMovimiento);
		request.addProperty("idEstatus", idEstatus);
		request.addProperty("fechaTransaccion", fechaTransaccion);
		request.addProperty("tipoPago", tipoPago);
		request.addProperty("correo", correo);

		JsonArray lstPolizas = new JsonArray();
		for (PolizaPagar polizaPagar : polizas) {
			lstPolizas.add(polizaPagar.toJsonObj());
			;
		}
		request.add("listaPagoPolizas", lstPolizas);

		JsonObject meta = new JsonObject();
		meta.addProperty("rowNum", 0);
		meta.addProperty("mUsuario", usuario);
		meta.addProperty("mModulo", modulo);
		meta.addProperty("mWebService", webservice);
		meta.addProperty("mPantalla", pantalla);
		meta.addProperty("mParametros", "");

		request.add("metadatos", meta);

		SolicitarPagoResponse solicitarPagoResponse = (SolicitarPagoResponse) getObjResponse(direction,
				request.toString(), SolicitarPagoResponse.class);
		return solicitarPagoResponse;
	}

	public ListaPolizasPendientesPagoResponse wsListaPolizasPendientesPago(String poliza, String codigoCliente,
			String monto, int tipoPago, int idMoneda, String usuario, String pantalla, String modulo)
			throws PagosException {

		String direction = "/PaginaWeb/wsListaPolizasPendientesPago";
		String webservice = "wsListaPolizasPendientesPago";

		String request = "{\"codigoCliente\":\"" + codigoCliente + "\", \"poliza\":\"" + poliza + "\"," + "\"monto\":\""
				+ monto + "\",\"tipoPago\":" + tipoPago + ", \"idMoneda\":" + idMoneda + "," + " \"metadatos\":"
				+ "{\"rowNum\":\"0\", \"mUsuario\":\"" + usuario + "\", \"mModulo\": \"" + modulo
				+ "\", \"mWebService\":\"" + webservice + "\"," + "\"mPantalla\":\"" + pantalla
				+ "\", \"mParametros\":null}" + "}";

		ListaPolizasPendientesPagoResponse listaPolizasPendientesPagoResponse = (ListaPolizasPendientesPagoResponse) getObjResponse(
				direction, request, ListaPolizasPendientesPagoResponse.class);
		return listaPolizasPendientesPagoResponse;
	}

	public SimpleResponse getTipoCambio() throws PagosException {

		String direction = "/PortalAgentes/getTipoCambio";

		String request = "";

		// se obtiene servicio
		String response = null;
		try {
			response = getService(direction, request);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PagosException(1, "Error al consultar el servicio");
		}

		// se utiliza libreria json para convertir json a objeto
		Gson gson = new Gson();
		SimpleResponse simpleResponse = null;
		try {
			// Se convierte respuesta a objeto
			simpleResponse = gson.fromJson(response, SimpleResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
			throw new PagosException(2, "Error al convertir json to Object");
		}

		return simpleResponse;
	}

	public PagosCatalogoResponse wsPagosCatalogo(String codigo, int activo, String usuario, String pantalla,
			String modulo) throws PagosException {

		String direction = "/PaginaWeb/wsCatalogo";
		String webservice = "wsCatalogo";

		String request = "{\"codigo\":\"" + codigo + "\", \"activo\":\"+1\"," + " \"metadatos\":"
				+ "{\"rowNum\":\"0\", \"mUsuario\":\"" + usuario + "\", \"mModulo\": \"" + modulo
				+ "\", \"mWebService\":\"" + webservice + "\"," + "\"mPantalla\":\"" + pantalla
				+ "\", \"mParametros\":null}" + "}";

		PagosCatalogoResponse pagosCatalogoResponse = (PagosCatalogoResponse) getObjResponse(direction, request,
				PagosCatalogoResponse.class);
		return pagosCatalogoResponse;
	}

	public SolicitarPagoResponse wsSolicitarPagoReferencia(PagoReferencia referencia, String usuario, String pantalla)
			throws PagosException {

		String direction = "/Paginaweb/wsSolicitarPagoReferencia";
		String webservice = "wsSolicitarPagoReferencia";

		JsonObject request = new JsonObject();
		request.addProperty("idTransaccion", referencia.getIdTransaccion());
		request.addProperty("folio", "");
		request.addProperty("idTipoMovimiento", referencia.getIdTipoMovimiento());
		request.addProperty("idEstatus", referencia.getIdEstatus());
		request.addProperty("fechaTransaccion", referencia.getFechaTransaccion());
		request.addProperty("tipoPago", referencia.getTipoPago());
		request.addProperty("correo", referencia.getCorreo());

		JsonArray lstPolizas = new JsonArray();
		for (PolizaPagar polizaPagar : referencia.getListaPagoPolizas()) {
			lstPolizas.add(polizaPagar.toJsonObj());
		}
		request.add("listaPagoPolizas", lstPolizas);

		JsonObject meta = new JsonObject();
		meta.addProperty("rowNum", 0);
		meta.addProperty("mUsuario", usuario);
		meta.addProperty("mModulo", "wsSolicitarPagoReferencia");
		meta.addProperty("mWebService", webservice);
		meta.addProperty("mPantalla", pantalla);
		meta.addProperty("mParametros", "");

		request.add("metadatos", meta);
		SolicitarPagoResponse ref = (SolicitarPagoResponse) getObjResponse(direction, request.toString(),
				SolicitarPagoResponse.class);
		return ref;
	}

	public ListaCatClientesPD wsCatClientesPD() throws PagosException {

		String direction = "/Paginaweb/wsCatClientesPD";
		String webservice = "wsCatClientesPD";

		ListaCatClientesPD resp = (ListaCatClientesPD) getObjResponse(direction, "", ListaCatClientesPD.class);
		return resp;
	}

	public ResponsePrimasDeposito wsPrimasDeposito(String codigoCliente, String usuario, String pantalla)
			throws PagosException {
		String direction = "/Paginaweb/wsPrimasDeposito";
		String webservice = "wsPrimasDeposito";

		JsonObject request = new JsonObject();
		request.addProperty("codigoCliente", codigoCliente);
		JsonObject meta = new JsonObject();
		meta.addProperty("rowNum", 0);
		meta.addProperty("mUsuario", usuario);
		meta.addProperty("mModulo", "Aplicación de Primas en Deposito");
		meta.addProperty("mWebService", webservice);
		meta.addProperty("mPantalla", pantalla);
		meta.addProperty("mParametros", "");

		request.add("metadatos", meta);

		ResponsePrimasDeposito resp = (ResponsePrimasDeposito) getObjResponse(direction, request.toString(),
				ResponsePrimasDeposito.class);
		return resp;

	}

	public ResponsePrimasPendientesPago wsPrimasPendientesPago(String poliza, String usuario, String pantalla)
			throws PagosException {
		String direction = "/Paginaweb/wsPrimasPendientesPago";
		String webservice = "wsPrimasPendientesPago";

		JsonObject request = new JsonObject();
		request.addProperty("poliza", poliza);
		JsonObject meta = new JsonObject();
		meta.addProperty("rowNum", 0);
		meta.addProperty("mUsuario", usuario);
		meta.addProperty("mModulo", "Aplicación de Primas en Deposito");
		meta.addProperty("mWebService", webservice);
		meta.addProperty("mPantalla", pantalla);
		meta.addProperty("mParametros", "");

		request.add("metadatos", meta);

		ResponsePrimasPendientesPago resp = (ResponsePrimasPendientesPago) getObjResponse(direction, request.toString(),
				ResponsePrimasPendientesPago.class);
		return resp;
	}

	public SimpleResponse wsAplicarCobranza(String cobranza) throws PagosException {
		String direction = "/Paginaweb/wsAplicarCobranza";
		String webservice = "wsAplicarCobranza";

		SimpleResponse resp = (SimpleResponse) getObjResponse(direction, cobranza, SimpleResponse.class);
		return resp;
	}

	public ListaRegistro getCatalogo(String p_codigo, String p_usuario, String p_pantalla) throws PagosException {
		String direction = "/PortalAgentes/ws_catalogos_detalle";
		String webservice = "ws_catalogos_detalle";

		JsonObject request = new JsonObject();
		request.addProperty("p_rowNum", 0);
		request.addProperty("p_tipTransaccion", "B");
		request.addProperty("p_codigo", p_codigo);
		request.addProperty("p_activo", 1);
		request.addProperty("p_usuario", p_usuario);
		request.addProperty("p_pantalla", p_pantalla);
		request.addProperty("p_webservice", webservice);
		request.addProperty("p_webmethod", webservice);

		ListaRegistro resp = (ListaRegistro) getObjResponse(direction, request.toString(), ListaRegistro.class);

		return resp;
	}

	public ListaAseguradoPD wsCatAseguradosPD() throws PagosException {
		String direction = "/Paginaweb/wsCatAseguradosPD";
		String webservice = "wsCatAseguradosPD";
		ListaAseguradoPD resp = (ListaAseguradoPD) getObjResponse(direction, "", ListaAseguradoPD.class);
		return resp;
	}

	public ListaTransaccionesPD wslistaPagosPD(String codigo, String fechaInicial, String fechaFinal, int estatus,
			String mUsuario, String mPantalla) throws PagosException {
		String direction = "/Paginaweb/wslistaPagosPD";
		String webservice = "wslistaPagosPD";

		JsonObject request = new JsonObject();
		request.addProperty("codigo", codigo);
		request.addProperty("fechaInicial", fechaInicial);
		request.addProperty("fechaFinal", fechaFinal);
		request.addProperty("p_activo", 1);
		request.addProperty("estatus", estatus);
		
		JsonObject meta = new JsonObject();
		meta.addProperty("rowNum", 0);
		meta.addProperty("mUsuario", mUsuario);
		meta.addProperty("mModulo", "Reporte de Aplicaciones automáticas");
		meta.addProperty("mWebService", webservice);
		meta.addProperty("mPantalla", mPantalla);
		meta.addProperty("mParametros", "");

		request.add("metadatos", meta);

		ListaTransaccionesPD resp = (ListaTransaccionesPD) getObjResponse(direction, request.toString(),
				ListaTransaccionesPD.class);

		return resp;
	}

	/* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
	/**
	 * 
	 * @param direction
	 * @param json
	 * @param cls
	 * @return
	 * @throws PagosException
	 */

	private <T> Object getObjResponse(String direction, String json, Class<T> cls) throws PagosException {
		// se obtiene servicio
		String response = null;
		try {
			response = getService(direction, json);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PagosException(1, "Error al consultar el servicio");
		}

		// se utiliza libreria json para convertir json a objeto
		Gson gson = new Gson();
		Object obj;
		try {
			obj = cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		obj = null;
		if (response != "responseServicio no disponible") {
			try {
				// Se convierte respuesta a objeto
				obj = gson.fromJson(response, cls);
			} catch (Exception e) {
				e.printStackTrace();
				throw new PagosException(2, "Error al convertir json to Object");
			}
		}
		return obj;
	}

	private String getService(String direction, String json) {
		HttpURLConnection connection;
		String uri = "http://" + host + ":" + puerto + direction;
		URL url;

		int contador = contadorPeticion;
		contadorPeticion++;

		try {
			url = new URL(uri);
			_log.info("[pagos-pet - " + contador + " ] " + url);
			_log.info("[pagos-pet - " + contador + " ] " + json);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			OutputStream os = connection.getOutputStream();
			os.write(json.getBytes());
			os.flush();

			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED && connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			InputStream inputStream = connection.getInputStream();
			String theString = getStringFromInputStream(inputStream);

			connection.disconnect();
			_log.info("[pagos-pet - " + contador + " ] " + theString);
			return theString;
		} catch (Exception e) {
			_log.info(e.getMessage());
			e.printStackTrace();

			return "Servicio no disponible"; // Default error message
		}
	}

	private String getService(String direction) {
		HttpURLConnection connection;
		String uri = "http://" + host + ":" + puerto + direction;
		URL url;

		try {
			url = new URL(uri);
			System.out.println("GETURL" + url);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED && connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			InputStream inputStream = connection.getInputStream();
			String theString = getStringFromInputStream(inputStream);

			connection.disconnect();
			System.out.println(theString);
			return theString;
		} catch (Exception e) {
			_log.info(e.getMessage());
			e.printStackTrace();

			return "Servicio no disponible"; // Default error message
		}
	}

	private static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;

		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

}
