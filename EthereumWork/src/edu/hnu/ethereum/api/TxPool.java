package edu.hnu.ethereum.api;

import edu.hnu.ethereum.bean.EthereMethods;
import edu.hnu.ethereum.utils.EthereMethodsUtils;
import edu.hnu.ethereum.utils.HttpUtils;
import edu.hnu.ethereum.utils.ParamsJsonUtils;

public class TxPool {
	public TxPool(){}
	
	/**
	 * 获取当前未开始或在队列中的事务详细情况
	 * @return
	 */
	public static String txPoolContent(){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getTxpoolContent(),"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
		
	}
	
	/**
	 * 获取当前未开始或在队列中的事务列表
	 * 适合开发人员快速查看事务池中,发现任何潜在的问题。
	 * @return
	 */
	public static String txPoolInspect(){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getTxpoolInspect(),"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
	}
	/**
	 * 查看当前未执行和队列中的等待处理的事务的个数
	 * @return
	 */
	public static String txPoolStatus(){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getTxpoolStatus(),"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
		
	}
	
	
}
