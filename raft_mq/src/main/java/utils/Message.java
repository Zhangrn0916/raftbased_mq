package utils;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;



	private String topic;
	private String content;
	private int num;
	
	public Message(String msg_key,String msg_content, int msg_num){
		this.topic = msg_key;
		this.content = msg_content;
		this.num = msg_num;
	}
	
	public String toString() {
		return topic+"_"+Integer.toString(num)+"_"+content;
	}
	
	
	public String getTopic() {
		return topic;
	}

	public String getContent() {
		return content;
	}

	public int getNum() {
		return num;
	}
	
}
