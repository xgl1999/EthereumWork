/**
 * 
 */
package edu.hnu.ethereum.bean;

/**
 * @author semigo
 *
 */
public class EthereMethods {
	
	private String ethereumRPC;	
	private String ethBlockNumber;// 获取当前块号
	private String ethSendTransaction;	//发送事务，
	private String ethGetTransactionByHash;   //根据事务hash码查看事务的数据内容
	private String ethGetTransactionReceipt;   //根据事务的hash返回收据
	private String ethMining;   //查询当前是否积极挖矿
	private String minerStart;   //开始挖矿
	private String minerStop;   //停止挖矿

	private String adminAddPeer;   //添加节点
	private String adminnodeInfo;   //本地节点信息
	private String adminPeers;   //查看已接入的节点

	private String NewAccount;   //创建一个以太坊账号
	private String sendTransaction;   //发送事务，转账，执行合约
	private String lockAccount;   //锁定账号
	private String unlockAccount;   //解锁账号
	private String listAccounts;   //列出当前节点的所有账号
	private String importRawKey;   //导入一个账号

	private String txpoolContent;   //执行队列所有正在执行或待执行的事务详情，参数，数据
	private String txpoolInspect;   //执行队列所有正在执行或待执行的事务list	
	private String txpoolStatus;   //执行队列所有正在执行或待执行的事务状态数量
	
	
	
	
	public String getEthereumRPC() {
		return ethereumRPC;
	}
	public void setEthereumRPC(String ethereumRPC) {
		this.ethereumRPC = ethereumRPC;
	}
	public String getEthBlockNumber() {
		return ethBlockNumber;
	}
	public void setEthBlockNumber(String ethBlockNumber) {
		this.ethBlockNumber = ethBlockNumber;
	}
	public String getEthSendTransaction() {
		return ethSendTransaction;
	}
	public void setEthSendTransaction(String ethSendTransaction) {
		this.ethSendTransaction = ethSendTransaction;
	}
	public String getEthGetTransactionByHash() {
		return ethGetTransactionByHash;
	}
	public void setEthGetTransactionByHash(String ethGetTransactionByHash) {
		this.ethGetTransactionByHash = ethGetTransactionByHash;
	}
	public String getEthGetTransactionReceipt() {
		return ethGetTransactionReceipt;
	}
	public void setEthGetTransactionReceipt(String ethGetTransactionReceipt) {
		this.ethGetTransactionReceipt = ethGetTransactionReceipt;
	}
	public String getEthMining() {
		return ethMining;
	}
	public void setEthMining(String ethMining) {
		this.ethMining = ethMining;
	}
	public String getMinerStart() {
		return minerStart;
	}
	public void setMinerStart(String minerStart) {
		this.minerStart = minerStart;
	}
	public String getMinerStop() {
		return minerStop;
	}
	public void setMinerStop(String minerStop) {
		this.minerStop = minerStop;
	}
	public String getAdminAddPeer() {
		return adminAddPeer;
	}
	public void setAdminAddPeer(String adminAddPeer) {
		this.adminAddPeer = adminAddPeer;
	}
	public String getAdminnodeInfo() {
		return adminnodeInfo;
	}
	public void setAdminnodeInfo(String adminnodeInfo) {
		this.adminnodeInfo = adminnodeInfo;
	}
	public String getAdminPeers() {
		return adminPeers;
	}
	public void setAdminPeers(String adminPeers) {
		this.adminPeers = adminPeers;
	}
	public String getNewAccount() {
		return NewAccount;
	}
	public void setNewAccount(String newAccount) {
		NewAccount = newAccount;
	}
	public String getSendTransaction() {
		return sendTransaction;
	}
	public void setSendTransaction(String sendTransaction) {
		this.sendTransaction = sendTransaction;
	}
	public String getLockAccount() {
		return lockAccount;
	}
	public void setLockAccount(String lockAccount) {
		this.lockAccount = lockAccount;
	}
	public String getUnlockAccount() {
		return unlockAccount;
	}
	public void setUnlockAccount(String unlockAccount) {
		this.unlockAccount = unlockAccount;
	}
	public String getListAccounts() {
		return listAccounts;
	}
	public void setListAccounts(String listAccounts) {
		this.listAccounts = listAccounts;
	}
	public String getImportRawKey() {
		return importRawKey;
	}
	public void setImportRawKey(String importRawKey) {
		this.importRawKey = importRawKey;
	}
	public String getTxpoolContent() {
		return txpoolContent;
	}
	public void setTxpoolContent(String txpoolContent) {
		this.txpoolContent = txpoolContent;
	}
	public String getTxpoolInspect() {
		return txpoolInspect;
	}
	public void setTxpoolInspect(String txpoolInspect) {
		this.txpoolInspect = txpoolInspect;
	}
	public String getTxpoolStatus() {
		return txpoolStatus;
	}
	public void setTxpoolStatus(String txpoolStatus) {
		this.txpoolStatus = txpoolStatus;
	}

	
	
}
