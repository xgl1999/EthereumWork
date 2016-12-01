package edu.hnu.ethereum.bean;



import java.util.HashMap;
import java.util.List;

import edu.hnu.ethereum.bean.NodeInfo.Protocol;
import edu.hnu.ethereum.bean.NodeInfo.Protocol.Eth;

public class NodeInfo {
	private String id;
	private String name;
	private String enode;
	private String ip;
	private Port ports;
	private String listenAddr;
	private Protocol protocols;
	
	
	public NodeInfo setNodeInfo(NodeInfo nodeinfo) {
		this.id = nodeinfo.getId();
		this.name= nodeinfo.getName();
		this.enode= nodeinfo.getEnode();
		this.ip = nodeinfo.getIp();
		this.listenAddr = nodeinfo.getListenAddr();
		this.ports = nodeinfo.getPorts();
		this.protocols = nodeinfo.getProtocols();
		return this;
	}
	
	public class Port { 
		 String discovery;
		 String listener;
		 
		public String getDiscovery() {
			return discovery;
		}
		public void setDiscovery(String discovery) {
			this.discovery = discovery;
		}
		public String getListener() {
			return listener;
		}
		public void setListener(String listener) {
			this.listener = listener;
		}
		 
    } 
	
	public class Protocol { 
		
		Eth eth;
		public Eth getEth() {
			return eth;
		}

		public void setEth(Eth eth) {
			this.eth = eth;
		}
		
		
		public class Eth { 
			String network;
			String difficulty;
			String genesis;
			String head;
			public String getNetwork() {
				return network;
			}
			public void setNetwork(String network) {
				this.network = network;
			}
			public String getDifficulty() {
				return difficulty;
			}
			public void setDifficulty(String difficulty) {
				this.difficulty = difficulty;
			}
			public String getGenesis() {
				return genesis;
			}
			public void setGenesis(String genesis) {
				this.genesis = genesis;
			}
			public String getHead() {
				return head;
			}
			public void setHead(String head) {
				this.head = head;
			}
			
		}
    }

	public String getEnode() {
		return enode;
	}

	public void setEnode(String enode) {
		this.enode = enode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getListenAddr() {
		return listenAddr;
	}

	public void setListenAddr(String listenAddr) {
		this.listenAddr = listenAddr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Port getPorts() {
		return ports;
	}

	public void setPorts(Port ports) {
		this.ports = ports;
	}

	public Protocol getProtocols() {
		return protocols;
	}

	public void setProtocols(Protocol protocols) {
		this.protocols = protocols;
	}

	
}
