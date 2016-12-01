/**
 * 
 */
package edu.hnu.ethereum.api;

import java.lang.reflect.Array;
import java.util.List;

import edu.hnu.ethereum.bean.EthereMethods;
import edu.hnu.ethereum.bean.SendTransBean;
import edu.hnu.ethereum.utils.EthereMethodsUtils;
import edu.hnu.ethereum.utils.HttpUtils;
import edu.hnu.ethereum.utils.JsonUtils;
import edu.hnu.ethereum.utils.ParamsJsonUtils;

/**
 * @author semigo
 *
 */
public class Personal {
	
	private Personal() {}
	
	/**
	 * 创建以太坊账号
	 * @param mypassword
	 * @return
	 * {
     *	"jsonrpc": "2.0",
     *	"id": 1,
     *	"result": "0xd7bebc7669dabc9cb6df0343aba6a94654ce3e07"
     *	}

	 */
	public static String  newAccount(String mypassword) {
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getNewAccount(),"\""+mypassword+"\"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
	}
	
	
	/**
	 * 解锁账号 "params": [string, string, number]
	 * @param account 账号地址
	 * @param password	密码
	 * @param timetemp	解锁时长
	 * 
	 * @return 
	 * {
     *	"jsonrpc": "2.0",
     *	"id": 1,
     *	"result": true
     *	}
	 */
	public static String unlockAccount(String account,String password,int timetemp){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String p = "\""+account+"\",\""+password+"\","+timetemp;
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getUnlockAccount(),p);
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
		
	}
	
	/**
	 * 锁定账号
	 * @param account
	 * @return
	 * {
     *	"jsonrpc": "2.0",
     *	"id": 1,
     *	"result": true
     *	}
	 */
	public static String lockAccount(String account) {
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String p = "\""+account+"\"";
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getLockAccount(),p);
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
		
	} 

	
	/**
	 * 发送事务
	 * @param sendTransBean
	 * @param password
	 * @return 
	 * {
     *	"jsonrpc": "2.0",
     *	"id": 1,
     *	"result": "0x2a40483bbf6cd330c1c945fc1b50e1b017e00813523777edb8530f5a2be046b6"
     *	}

	 */
	public static String sendTransaction(SendTransBean sendBean ,String password){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String p = JsonUtils.toJson(sendBean)+",\""+password+"\"";
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getSendTransaction(),p);
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
		
	}
	
	/**
	 * 列出所有账号的address数组
	 * @return
	 * {
     *	"jsonrpc": "2.0",
     *	"id": 1,
     *	"result": ["0x97246717f947af64cfa89450feb23b23badf254b","0xd7bebc7669dabc9cb6df0343aba6a94654ce3e07", "0xa33b00accb6731aff5dc5216c1625ea0d082be3f"]
     *	}
	 */
	public static String listAccounts(){
		EthereMethods ethereMethods = EthereMethodsUtils.getEthMethods();
		String url = ethereMethods.getEthereumRPC();
		String params =ParamsJsonUtils.getParamsJson(ethereMethods.getSendTransaction(),"");
		String jsonResult = HttpUtils.post(url, params);
		return jsonResult;
			
	}
	
	/**
	 * 导入未加密账号文件字符串，并使用新的密码
	 * 该方法暂不实现
	 * @param keystore
	 * @param password
	 * @return 返回新产生的账号address字符串
	 */
	public static String importRawKey(String keystore ,String password){
		String jsonResult="{\"jsonrpc\": \"2.0\",\"id\": 1,\"error\": {\"code\": -99999,\"message\": \"json:This method is not implemented for the time being！\"}}";
		return jsonResult;
		
	}
	
}
