package com.hnu.ethereum.bean;

import java.util.HashMap;

import com.hnu.ethereum.utils.JsonUtils;


/**
 * @Description: rpc结果集
 * @author: SIMON
 * @date:2016年11月30日
 * @version V1.0
 */
public class ResultRPC implements java.io.Serializable {

	private String jsonrpc;
	private long id;	
	private Object result = null;// 数据行
	private HashMap<String,String> error = new HashMap<String,String>();// 错误对象

	private String errorCode;
	private String errorMsg;
	
	public String getJsonrpc() {
		return jsonrpc;
	}

	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public long getId() {
		return id;
	}

	public HashMap<String,String> getError() {
		return error;
	}

	public String getErrorCode(){
		errorCode = getError().get("code");
		return errorCode;
	}
	
	public String getErrorMsg(){
		errorMsg = getError().get("message");
		return errorMsg;
		
	}


	public Object getResult() {
		return result;
	}


	public ResultRPC setResultRPC(Object Objerror, Object result) {
		this.id = getId();
		this.error = (HashMap<String, String>) Objerror;
		this.result = result;
		return this;
	}


	public ResultRPC() {
		this.id = 1;
		this.errorCode = "0";
		this.errorMsg = "0";
		this.error.put("code", errorCode);
		this.error.put("message",errorMsg);
		result = new HashMap<String, Object>();
	}


	public void clear() {
		this.error = null;
		this.id = 0;
		this.result = null;
	}

	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}
}
