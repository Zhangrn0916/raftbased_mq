package producer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import utils.IpAddress;
import utils.Message;


public class Producer {
	//One Way Pass 
	public static String Send(Message msg,IpAddress mq_manager) {
		System.out.println("Sending Msg: 【" +msg.toString()+"】 to IPAddress: " + mq_manager.toString());
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress(mq_manager.getIp(),mq_manager.getPort()));
			
			ObjectOutputStream  oos = new ObjectOutputStream(socketChannel.socket().getOutputStream());
			oos.writeObject(msg);
            oos.close();
            
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public static void main(String[] args) {
		Message msg = new Message("test","content2",2);
		Message msg1 = new Message(new IpAddress("localhost",85),"topic1",1);
		
		IpAddress mq_manager = new IpAddress("localhost",83);
		Send(msg,mq_manager);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Send(msg1,mq_manager);
	}

	
}
