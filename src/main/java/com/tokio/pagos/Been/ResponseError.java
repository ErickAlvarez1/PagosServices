package com.tokio.pagos.Been;

public class ResponseError {
	Error error;
	String result;
	
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "ResponseError [error=" + error + ", result=" + result + "]";
	}
	
}
