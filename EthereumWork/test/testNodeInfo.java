
import java.util.ArrayList;
import java.util.List;

import edu.hnu.ethereum.bean.NodeInfo;
import edu.hnu.ethereum.bean.NodeInfo.Protocol;
import edu.hnu.ethereum.bean.NodeInfo.Protocol.Eth;
import edu.hnu.ethereum.utils.JsonUtils;

import net.sf.json.JSONObject;
public class testNodeInfo {

	public static String beanToJson(Object bean) {
		 
        JSONObject json = JSONObject.fromObject(bean);
         
        return json.toString();
 
    }
	
	public static void main(String[] args) {
		NodeInfo t = new NodeInfo();
		t.setId("111");
		t.setName("zxs");
		t.setEnode("12345678");
		t.setIp("127.0.0.1");
		t.setListenAddr("127.0.0.1:30303");
		
		NodeInfo.Port p = t.new Port();
		p.setDiscovery("30303");
		p.setListener("30303");
		
		NodeInfo.Protocol pp = t.new  Protocol();
		NodeInfo.Protocol.Eth e = pp.new Eth();
		
		e.setNetwork("48666");
		e.setDifficulty("ddddd");
		e.setGenesis("gggggggggggg");
		e.setHead("hhhhhhhhhhh");
		pp.setEth(e);
		t.setPorts(p);
		t.setProtocols(pp);
		
		NodeInfo nodeinfo = new NodeInfo();
		nodeinfo.setNodeInfo(JsonUtils.parse(JsonUtils.toJson(t), NodeInfo.class)) ;
		System.out.println("Listener:"+ JsonUtils.toJson(nodeinfo.getPorts().getListener()));
		nodeinfo.getProtocols().getEth().getNetwork();
		System.out.println("Network:"+ JsonUtils.toJson(nodeinfo.getProtocols().getEth().getNetwork()));
		
		System.out.println(JsonUtils.toJson(nodeinfo));
	}
}
