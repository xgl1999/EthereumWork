package edu.hnu.ethereum.api.eth;

import java.util.Map;

import com.jfinal.log.Log;

import edu.hnu.ethereum.bean.EthereMethods;
import edu.hnu.ethereum.utils.EthereMethodsUtils;
import edu.hnu.ethereum.utils.HttpUtils;
import edu.hnu.ethereum.utils.JsonUtils;
import edu.hnu.ethereum.utils.ParamsJsonUtils;
import net.sf.json.JSONObject;


public class EthMethod {
	private static Log LOG = Log.getLog("EthMethod.class");

	public EthMethod(){}
	private static Map<String, Object> attrs;
	/**
	 * 查看当前是否在挖矿
	 * @return
	 */
	public static String eth_mining(){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getEthMining(),"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
	}
	
	
	/**
	 * 获取当前块号
	 * @return
	 */
	public static String eth_blockNumber(){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getEthBlockNumber(),"");
		String jsonResult = HttpUtils.post(url, params);
		
		return jsonResult;
		
	}
	
	/**
	 * 发送数据
	 * @param prame json数据 
	 * [{
		  "from": "0xb60e8dd61c5d32be8058bb8eb970870f07233155",
		  "to": "0xd46e8dd67c5d32be8058bb8eb970870f07244567",
		  "gas": "0x76c0", // 30400,
		  "gasPrice": "0x9184e72a000", // 10000000000000
		  "value": "0x9184e72a", // 2441406250
		  "data": "0x123abc"
	 *	}
	 *
	 *
	 * [{
	  "from": "0x97246717f947af64cfa89450feb23b23badf254b",
	  "to": "0xd7bebc7669dabc9cb6df0343aba6a94654ce3e07",
	  "value":1,
	  "data": "0x1234567890dddd"
	  }

	 * @return m 
	 */
	public static String eth_sendTransaction(String prame){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getSendTransaction(),"");
		String jsonResult = HttpUtils.post(url, params);
		
		return jsonResult;
		
	}
	

	
	/**
	 * 通过事务transactionHash，查询出交易的详细数据
	 * @param transactionHash 0xe97a7d4eb2c6ae1813cdb5628a88225c54f1bbb84aef1ec4b9cfb63279f49390
	 * @return 
	 */
	public static String eth_getTransactionByHash(String transactionHash){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getEthGetTransactionByHash(),"\""+transactionHash+"\"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
		
	}
	
	/**
	 * 通过事务transactionHash，查询出交易的收据信息，同 eth_getTransactionByHash，
	 * @param transactionHash 0xe97a7d4eb2c6ae1813cdb5628a88225c54f1bbb84aef1ec4b9cfb63279f49390
	 * @return 
	 */
	public static String eth_getTransactionReceipt(String transactionHash){
		
		return null;
		
	}

	
//	eth_getBlockByHash
//	eth_getBlockByNumber
	
	
	
//	eth_getBalance	
//	eth_getStorageAt
//	eth_getTransactionCount 	账号发生了多少笔交易
//	eth_getBlockTransactionCountByNumber 	//Returns the number of transactions in a block from a block matching the given block number.
}
