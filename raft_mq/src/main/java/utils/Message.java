package utils;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;	
	private String topic;
	private String msg_content;
	private int msg_topic_num;
	
	public Message(String msg_key,String msg_content, int msg_num){
		this.topic = msg_key;
		this.msg_content = msg_content;
		this.msg_topic_num = msg_num;
	}
	
	public String toString() {
		return topic+"_"+Integer.toString(msg_topic_num)+"_"+msg_content;
	}
	
}
