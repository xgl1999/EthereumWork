/**
 * 
 */
package com.hnu.ethereum.api;

import java.lang.reflect.Array;

import com.hnu.ethereum.bean.EthereMethods;
import com.hnu.ethereum.bean.sendTransBean;
import com.hnu.ethereum.utils.EthereMethodsUtils;
import com.hnu.ethereum.utils.HttpUtils;
import com.hnu.ethereum.utils.JsonUtils;
import com.hnu.ethereum.utils.ParamsJsonUtils;

/**
 * @author semigo
 *
 */
public class Personal {
	
	private Personal() {}
	
	/**
	 * 创建以太坊账号
	 * @return
	 */
	public static String  newAccount(String mypassword) {
		return "";
	}
	
	
	/**
	 * 解锁账号
	 * @param account 账号地址
	 * @param password	密码
	 * @param timetemp	解锁时长
	 * @return
	 */
	public static String unlockAccount(String account,String password,int timetemp){
		return null;
		
	}
	
	/**
	 * 锁定账号
	 * @param account
	 * @return
	 */
	public static String lockAccount(String account) {
		return null;
	} 

	
	/**
	 * 发送事务
	 * @param sendTransBean
	 * @param password
	 * @return
	 */
	public static String sendTransaction(sendTransBean sendBean ,String password){
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
	 */
	public static Array listAccounts(){
		return null;
			
	}
	
	/**
	 * 导入未加密账号文件字符串，并使用新的密码
	 * 改方法暂不实现
	 * @param keystore
	 * @param password
	 * @return 返回新产生的账号address字符串
	 */
	public static String importRawKey(String keystore ,String password){
		return null;
		
	}
	
}
