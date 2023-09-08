package com.tokio.pagos.Util;

import java.util.Base64;

public class Codifica {
	

	public static String encode( byte[] bytes  ){
		return new String ( Base64.getEncoder().encodeToString(bytes)  );
	}

	public static byte[] decode( String cadena  ){
		return Base64.getDecoder().decode(cadena.getBytes());
//	    return new String(decodedBytes, Charset.forName("UTF-8"));	    
	}

}
