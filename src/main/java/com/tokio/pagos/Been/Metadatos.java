/**
 * 
 */
package com.tokio.pagos.Been;

/**
 * @author jonathanfviverosmoreno
 *
 */
public class Metadatos {
	int totalRow;
	int code;
	String msg;
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Metadatos [totalRow=" + totalRow + ", code=" + code + ", msg=" + msg + "]";
	}
	
	
}
