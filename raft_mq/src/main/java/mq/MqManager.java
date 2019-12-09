package mq;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utils.IpAddress;
import utils.Message;

//只负责MyBroker的写入操作
public class MqManager {
	private IpAddress ip;
	private List<IpAddress> brokers_list;
	private IpAddress leader_broker;
	
	//<Topic,Consumer_Ip> 保存Topic的目标Consumer:Push模式参数
	private HashMap<String,IpAddress> target_consumers;
	private MqManagerListener listener;
	
	public MqManager(IpAddress manager_ip) {
		this.ip = manager_ip;
		this.brokers_list = new ArrayList<IpAddress>();
		this.target_consumers = new HashMap<String,IpAddress>();
		
		listener = new MqManagerListener(this);
		listener.start();
	}
	
	//TODO:添加一个Broker并通知其他Broker有新Broker加入
	public String addBroker(IpAddress broker_ip) {
		return null;
	}
	
	//TODO:RPC调用leader Broker 把消息更新到LeaderBroker中
	public String updateMsgToBroker(Message msg) {
		return null;
	}
	
	//TODO:RPC调用leader Broker 把Consumer列表更新到LeaderBroker中
	public String updateConsumerToBroker(HashMap<String,IpAddress> target_consumers) {
		return null;
	}
	
	//TODO:Push模式:接受Consumer的请求并注册在targer_consumer中
		
	
	//测试从Producer收消息
	public static void main(String[] args) {
		MqManager mq_manager = new MqManager(new IpAddress("localhost",83));

	}
	
	
	public IpAddress getIp() {
		return ip;
	}


	public List<IpAddress> getBrokers_list() {
		return brokers_list;
	}


	public IpAddress getLeader_broker() {
		return leader_broker;
	}


	public MqManagerListener getListener() {
		return listener;
	}


}
