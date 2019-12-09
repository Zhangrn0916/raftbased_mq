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
		return null;	
	}

}
