package consumer;

import java.util.List;

import utils.IpAddress;
import utils.Message;

public class Consumer {
	
	IpAddress ip;
	List<IpAddress> broker_list;
	
	//TODO:Push模式: 在MqManager的Target_consumer中注册
	//TODO:从MqManager获取所有Broker的地址(broker_list)
	
	public List<IpAddress> getBrokerList(IpAddress mq_manager){
		return null;
	}
	
	//TODO:Pull模式从Broker获取信息
	public static Message GetMessageFromBroker(String topic, IpAddress broker) {
		return null;
	}
	

}
