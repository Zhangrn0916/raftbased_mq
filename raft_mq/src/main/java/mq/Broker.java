package mq;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

import utils.IpAddress;
import utils.Message;

public class Broker {

	IpAddress ip;
	IpAddress manager_ip;
	boolean is_leader;
	List<IpAddress> other_brokers;
	MessageQueue queue_map; //类似过滤器
	
	//<Topic,Consumer_Ip> 保存Topic的目标Consumer:Push模式参数
	private HashMap<String,IpAddress> target_consumers;
	
	
	//TODO:RPC部分: Manager调用leader_broker写入功能
	//TODO:RPC部分: Manager更新target_consumer
	//TODO:RAFT部分:选举 更新Follower的MessageQueue
	//TODO:Consumer从broker获取信息
	
	public Broker(IpAddress ip) {
		this.ip = ip;
		queue_map = new MessageQueue();
	}
	
	public void writeMsg(Message msg) {
		queue_map.writeMessage(msg);
	}
	
	public Queue<Message> getMsgQueue(String topic) {
		return queue_map.getQueueByTopic(topic);
	}
	
	public IpAddress getIp() {
		return ip;
	}

	public List<IpAddress> getOther_brokers() {
		return other_brokers;
	}
	
	
	
}
