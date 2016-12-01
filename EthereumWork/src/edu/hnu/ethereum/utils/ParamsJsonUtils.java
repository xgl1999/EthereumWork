package edu.hnu.ethereum.utils;

public class ParamsJsonUtils {

	public static String getParamsJson(String methods,String params){
		long reqId = System.currentTimeMillis();
		String Params = "{\"jsonrpc\":\"2.0\",\"id\":"+reqId+",\"method\":\""+methods +"\",\"params\":["+params+"]}";
		return Params;
	}
}
