import java.io.IOException;
import java.util.Map;

//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;

import com.hnu.ethereum.api.Personal;
import com.hnu.ethereum.api.TxPool;
import com.hnu.ethereum.api.eth.EthMethod;
import com.hnu.ethereum.bean.EthereMethods;
import com.hnu.ethereum.bean.ResultRPC;
import com.hnu.ethereum.bean.SendTransBean;
import com.hnu.ethereum.utils.EthereMethodsUtils;
import com.hnu.ethereum.utils.JsonUtils;
import com.jfinal.log.Log;


public class EthTest {

	private static Log LOG = Log.getLog(EthTest.class);
		
    public static void main(String[] args) throws IOException {
    	long start =System.currentTimeMillis();
    	ResultRPC resultObj;
    	//String hashvalue ="0xe97a7d4eb2c6ae1813cdb5628a88225c54f1bbb84aef1ec4b9cfb63279f49390";
     	String hashvalue ="0x82c79f829c19da6ce35e749089db875cee200e36cbfebc8dee757ba4f6088840";
//     	String jsonResult =TxPool.txPoolContent();		//待执行的事务
//     	String jsonResult = EthMethod.eth_mining();		//是否在挖矿
    	String jsonResult = EthMethod.eth_getTransactionByHash(hashvalue); 	//根据事务hash查询事务详情
//     	String jsonResult = EthMethod.eth_blockNumber();		//查询当前块号
     	
     	
   //	发起交易
    /* 	SendTransBean sendBean = new SendTransBean();
     	sendBean.setFrom("0x97246717f947af64cfa89450feb23b23badf254b");
     	sendBean.setTo("0xd7bebc7669dabc9cb6df0343aba6a94654ce3e07");
     	sendBean.setValue(100);
     	sendBean.setData("0x1234567890dddd");
     	//TODO 需要编写将字符串转成hex hash值 的函数；
     	String password ="XGL";
     	
     	String jsonResult = Personal.sendTransaction(sendBean, password);
     	*/
     	resultObj =  JsonUtils.parse(jsonResult, ResultRPC.class);
     	LOG.info("【用时：" + (System.currentTimeMillis() - start) + "毫秒】");
    	
    	if (resultObj.getErrorCode() !="0"){
    		LOG.info(resultObj.getErrorMsg());
    	}
    	else{
    		LOG.info( resultObj.toString());
    	}
    	
    	
    }
    
    
/*	public static String httpTest() throws ClientProtocolException, IOException {

		String params = "0x8a55e1f516307d54ae650756f1eb7253ecbd690dcefe82199e60c0e82edf04d0";
		String url = "http://192.168.0.3:8545";
		String json = "{\"jsonrpc\":\"2.0\",\"id\":1,\"method\":\"eth_getTransactionByHash\",\"params\":[\""
				+ params + "\"]}";
		@SuppressWarnings("deprecation")
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		StringEntity postingString = new StringEntity(json);// json传递
		post.setEntity(postingString);
		post.setHeader("Content-type", "application/text");
		long start = System.currentTimeMillis();
		HttpResponse response = httpClient.execute(post);
		String content = EntityUtils.toString(response.getEntity());
		// Log.i("test",content);
		LOG.info("【用时：" + (System.currentTimeMillis() - start) + "毫秒】");
		return content;
	}
*/    
}

