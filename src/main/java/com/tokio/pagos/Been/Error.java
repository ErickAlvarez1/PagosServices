package com.tokio.pagos.Been;

public class Error {
	String cause;
	String explanation;
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	@Override
	public String toString() {
		return "Error [cause=" + cause + ", explanation=" + explanation + "]";
	}
	
}
