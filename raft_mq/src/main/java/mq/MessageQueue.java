package mq;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

import utils.Message;

public class MessageQueue implements Serializable {
	//按照Topic把Message分类 等于过滤器
	private ConcurrentHashMap<String,Queue<Message>> queue;
	
	public  MessageQueue () {
		queue = new ConcurrentHashMap<String,Queue<Message>>();
	}
	
	public void writeMessage(Message msg) {
		if(queue.contains(msg.getTopic())){
			queue.get(msg.getTopic()).add(msg);	
		}else{
			queue.put(msg.getTopic(),new LinkedList<Message>());
		}
	}
	
	public Queue<Message> getQueueByTopic(String topic){
		return queue.get(topic);
	}
	
}
