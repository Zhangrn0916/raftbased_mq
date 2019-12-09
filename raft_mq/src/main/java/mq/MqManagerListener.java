package mq;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import utils.IpAddress;
import utils.Message;

public class MqManagerListener extends Thread{
	private MqManager local;
	private ServerSocketChannel ssChannel;
	public MqManagerListener (MqManager manager) {
		local = manager;
	    ssChannel = null;
		try {
			ssChannel = ServerSocketChannel.open();
		    ssChannel.configureBlocking(true);
		    ssChannel.socket().bind(new InetSocketAddress(manager.getIp().getPort()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("Listening on: " + local.getIp().toString());
            ObjectInputStream  ois = null; 
			try {
				//接受Producer的消息
				SocketChannel sChannel = ssChannel.accept();
				ois = new ObjectInputStream(sChannel.socket().getInputStream());
				Message msg = (Message)ois.readObject();
				
				
				//普通消息:
				if(msg.getType() == 0) {
					local.updateMsgToBroker(msg);
					System.out.println("Received Message: " + msg.toString());
				}else if(msg.getType() == 1) {   //Push模式:接收到Consumer的注册消息
					local.addConsumer(msg.getTopic(), msg.getConsumer());
					local.updateConsumerToBroker();
					System.out.println("Received Message: " + msg.toString());
				}
				ois.close();
				
				
				Thread.sleep(50);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

}
