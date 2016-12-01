package edu.hnu.ethereum.utils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import edu.hnu.ethereum.bean.EthereMethods;

public class EthereMethodsUtils {
	public static final String METHODS_CONFIG_FILE_NAME = "ethereumethods.xml";	//以太坊接口方法名程
	
	
	/**
	 * 获取以太坊api接口方法名字配置
	 * @return EthereMethods对象
	 */
	public static EthereMethods getEthMethods(){
		File configFile = null;
		Document document = null;
		try {
			String configFilePath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath() + METHODS_CONFIG_FILE_NAME;
			configFile = new File(configFilePath);
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(configFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Node ethereumRPCNode = document.selectSingleNode("/ethereuapp/methodsConfig/ethereumRPC");
		Node ethblockNumberNode = document.selectSingleNode("/ethereuapp/methodsConfig/eth_blockNumber");
		Node ethsendTransactionNode = document.selectSingleNode("/ethereuapp/methodsConfig/eth_sendTransaction");
		Node ethgetTransactionByHashNode = document.selectSingleNode("/ethereuapp/methodsConfig/eth_getTransactionByHash");
		Node ethgetTransactionReceiptNode = document.selectSingleNode("/ethereuapp/methodsConfig/eth_getTransactionReceipt");
		Node ethMiningNode = document.selectSingleNode("/ethereuapp/methodsConfig/eth_mining");
		Node minerStartNode = document.selectSingleNode("/ethereuapp/methodsConfig/miner_start");
		Node minerStopNode = document.selectSingleNode("/ethereuapp/methodsConfig/miner_stop");
		Node adminAddPeerNode = document.selectSingleNode("/ethereuapp/methodsConfig/admin_addPeer");
		Node adminNodeInfoNode = document.selectSingleNode("/ethereuapp/methodsConfig/admin_nodeInfo");
		Node adminPeersNode = document.selectSingleNode("/ethereuapp/methodsConfig/admin_peers");
		Node newAccountNode = document.selectSingleNode("/ethereuapp/methodsConfig/personal_newAccount");
		Node unlockAccountNode = document.selectSingleNode("/ethereuapp/methodsConfig/personal_unlockAccount");
		Node sendTransactionNode = document.selectSingleNode("/ethereuapp/methodsConfig/personal_sendTransaction");
		Node lockAccountNode = document.selectSingleNode("/ethereuapp/methodsConfig/personal_lockAccount");
		Node listAccountsNode = document.selectSingleNode("/ethereuapp/methodsConfig/personal_listAccounts");
		Node importRawKeyNode = document.selectSingleNode("/ethereuapp/methodsConfig/personal_importRawKey");
		Node txpoolContentNode = document.selectSingleNode("/ethereuapp/methodsConfig/txpool_content");
		Node txpoolInspectNode = document.selectSingleNode("/ethereuapp/methodsConfig/txpool_inspect");
		Node txpoolStatusNode = document.selectSingleNode("/ethereuapp/methodsConfig/txpool_status");

		EthereMethods ethereMethods = new EthereMethods();
		
		ethereMethods.setEthereumRPC(ethereumRPCNode.getText());
		ethereMethods.setEthBlockNumber(ethblockNumberNode.getText());
		ethereMethods.setEthSendTransaction(ethsendTransactionNode.getText());
		ethereMethods.setEthGetTransactionReceipt(ethgetTransactionReceiptNode.getText());
		ethereMethods.setEthGetTransactionByHash(ethgetTransactionByHashNode.getText());
		ethereMethods.setEthMining(ethMiningNode.getText());
		ethereMethods.setMinerStart(minerStartNode.getText());
		ethereMethods.setMinerStop(minerStopNode.getText());
		ethereMethods.setAdminAddPeer(adminAddPeerNode.getText());
		ethereMethods.setAdminPeers(adminPeersNode.getText());
		ethereMethods.setAdminnodeInfo(adminNodeInfoNode.getText());
		ethereMethods.setNewAccount(newAccountNode.getText());
		ethereMethods.setUnlockAccount(unlockAccountNode.getText());
		ethereMethods.setLockAccount(lockAccountNode.getText());
		ethereMethods.setListAccounts(listAccountsNode.getText());
		ethereMethods.setSendTransaction(sendTransactionNode.getText());
		ethereMethods.setImportRawKey(importRawKeyNode.getText());
		ethereMethods.setTxpoolContent(txpoolContentNode.getText());
		ethereMethods.setTxpoolInspect(txpoolInspectNode.getText());
		ethereMethods.setTxpoolStatus(txpoolStatusNode.getText());
		
		return ethereMethods;
	}
	
}
