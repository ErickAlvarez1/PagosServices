package com.tokio.pagos.Util;

import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.tokio.pagos.Exception.PagosException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResponseUtil {
	
	
	private static final Log _log = LogFactoryUtil.getLog(ResponseUtil.class);
	String host = PropsUtil.get("ambiente.configuracion.host");
	String puerto = PropsUtil.get("ambiente.configuracion.puerto");
	
	
//	String				Desarrollo
//	String				host = "200.66.89.205";
//	String				QA
//	String				host = "172.25.10.57";
//	String				Produccion
//	String				host = "172.25.10.62"; // balanceador de servicios
//	String				host = "172.25.10.58"; // Nodo 1
//	String				host = "172.25.10.60"; // Nodo 2
// 	String 				puerto =  "80";

	
	
	private <T> Object getObjResponse( String direction, String json, Class<T> cls) throws PagosException{
		//se obtiene servicio
		
		String response = null;
		try{
			response = getService(direction,json);
		}catch(Exception e){
			e.printStackTrace();
			throw new PagosException(1,"Error al consultar el servicio");
		}
		
		//se utiliza libreria json para convertir json a objeto
		Gson gson = new Gson();
		Object obj;
		try {
			obj = cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
		obj = null;
		if (response != "responseServicio no disponible"){
			try {
				//Se convierte respuesta a objeto  
				obj = gson.fromJson(response, cls);
			} catch (Exception e) {
				e.printStackTrace();
		        throw new PagosException(2,"Error al convertir json to Object");
			}
		}
		return obj;
	}
	
	private String getService( String direction, String json){		
		HttpURLConnection 	connection;
		String 				uri = "http://"+host+":"+puerto+direction;
		URL 				url;
			
		try {
			url = new URL(uri);
			_log.info( url);
			_log.info(json);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			OutputStream os = connection.getOutputStream();
			os.write(json.getBytes());
			os.flush();

			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED && connection.getResponseCode()!= 200 ) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ connection.getResponseCode());
			}

			InputStream inputStream = connection.getInputStream();
			String 		theString = getStringFromInputStream(inputStream);
			
			connection.disconnect();
			_log.info( theString );
			return theString;
		} catch (Exception e) {
			_log.info( e.getMessage() );
			e.printStackTrace();
				
			return "Servicio no disponible"; // Default error message
		}
	}
	
	
	private String getService( String direction){		
		HttpURLConnection 	connection;
		String 				uri = "http://"+host+":"+puerto+direction;
		URL 				url;
			
		try {
			url = new URL(uri);
			System.out.println("GETURL" +url);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED && connection.getResponseCode()!= 200 ) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ connection.getResponseCode());
			}

			InputStream inputStream = connection.getInputStream();
			String 		theString = getStringFromInputStream(inputStream);
			
			connection.disconnect();
			System.out.println( theString );
			return theString;
		} catch (Exception e) {
			_log.info( e.getMessage() );
			e.printStackTrace();
				
			return "Servicio no disponible"; // Default error message
		}
	}
	
	
	private static String getStringFromInputStream(InputStream is) {
		BufferedReader 	br = null;
		StringBuilder 	sb = new StringBuilder();
		String 			line;
		
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
