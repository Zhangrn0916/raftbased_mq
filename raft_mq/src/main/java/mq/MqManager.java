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
	
	//<Topic,Consumer_Ip> 保存Topic的目标Consumer
	private HashMap<String,IpAddress> consumer_list;
	private ProducerListener listener;
	
	public MqManager(IpAddress manager_ip) {
		this.ip = manager_ip;
		this.brokers_list = new ArrayList<IpAddress>();
		this.consumer_list = new HashMap<String,IpAddress>();
		
		listener = new ProducerListener(this);
		listener.start();
	}
	
	
	public String addBroker(IpAddress broker_ip) {
		return null;
	}
	
	//TODO:MQ的写入操作，把消息更新到LeaderBroker中
	public String updateMsgToBroker(Message msg) {
		return null;
	}
		
	public String addNewConsumer(String consumer_key,IpAddress consumer_ip) {
		return null;
	}
		
	
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


	public HashMap<String, IpAddress> getConsumer_list() {
		return consumer_list;
	}


	public ProducerListener getListener() {
		return listener;
	}


}
