package utils;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;



	private String topic;
	private String content;
	private int num;
	
	/* type = 0 : normal message
	 * type = 1 : consumer register message
	 */
	private int type;
	private IpAddress consumer;
	
	//Normal Message
	public Message(String topic,String msg_content, int msg_num){
		this.topic = topic;
		this.content = msg_content;
		this.num = msg_num;
		this.consumer = null;
		this.type = 0;
	}
	
	//Register Message
	public Message(IpAddress consumer,String topic, int msg_num){
		this.consumer = consumer;
		this.topic = topic;
		this.content = null;
		this.num = msg_num;
		this.type = 1;
	}
	
	public String toString() {
		
		if(this.type == 0) {
			return "[Topic]:"+topic+"_[Num]:"+Integer.toString(num)+"_[Content]:"+content;
		}else {
			return "[Topic]:"+topic+"_[Num]:"+Integer.toString(num)+"_[Consumer]:"+consumer.toString();
		}
	}
	
	public int getType() {
		return this.type;
	}
	
	public String getTopic() {
		return topic;
	}

	public String getContent() {
		return content;
	}
	
	public IpAddress getConsumer() {
		return this.consumer;
	}


	public int getNum() {
		return num;
	}
	
}
