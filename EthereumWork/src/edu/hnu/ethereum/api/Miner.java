package edu.hnu.ethereum.api;

import edu.hnu.ethereum.bean.EthereMethods;
import edu.hnu.ethereum.utils.EthereMethodsUtils;
import edu.hnu.ethereum.utils.HttpUtils;
import edu.hnu.ethereum.utils.ParamsJsonUtils;

public class Miner {
	public Miner(){}
	
	/**
	 * 开始挖矿
	 * @param coreCount 启用coreCount个线程挖矿
	 * @return
	 */
	public synchronized static String minerStart(String coreCount){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getMinerStart(),coreCount);
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
	}
	
	/**
	 * 结束挖矿
	 * @return
	 */
	public synchronized static String minerStop(){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getMinerStop(),"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
		
	}
}
