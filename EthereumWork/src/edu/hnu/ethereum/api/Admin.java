package edu.hnu.ethereum.api;

import edu.hnu.ethereum.bean.EthereMethods;
import edu.hnu.ethereum.utils.EthereMethodsUtils;
import edu.hnu.ethereum.utils.HttpUtils;
import edu.hnu.ethereum.utils.ParamsJsonUtils;

public class Admin {
	public Admin(){}
	
	/**
	 * 查看本节点的信息
	 * @return
	 */
	public static String admin_nodeInfo(){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getAdminnodeInfo(),"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
	}
	
	/**
	 * 链接到一个节点
	 * @return
	 */
	public static String admin_addPeer(){
		return null;
		
	}
	
	/**
	 * 查询当前所有链接到的节点
	 * @return
	 */
	public static String admin_peers(){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getAdminPeers(),"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
		
	}
}
