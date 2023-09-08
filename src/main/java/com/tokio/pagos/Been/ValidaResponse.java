package com.tokio.pagos.Been;

import java.util.List;

public class ValidaResponse {
	private List<String> strLog;
	private String msg;
	private int code;
	
	public List<String> getStrLog() {
		return strLog;
	}
	public void setStrLog(List<String> strLog) {
		this.strLog = strLog;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "ValidaResponse [strLog=" + strLog + ", msg=" + msg + ", code=" + code + "]";
	}
}
