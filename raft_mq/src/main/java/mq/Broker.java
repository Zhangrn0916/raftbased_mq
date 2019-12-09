package mq;

import java.util.List;

import utils.IpAddress;

public class Broker {
	IpAddress ip;
	IpAddress manager_ip;
	boolean is_leader;
	List<IpAddress> other_brokers;
	//Listening From MqManager 
	
	public String init(){
		//多线程监听当前端口
		return null;	
	}

}
