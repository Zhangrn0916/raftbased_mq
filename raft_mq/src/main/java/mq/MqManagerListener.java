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
				ois.close();
				System.out.println("Received Message: " + msg.toString());
				
//				//Response to Producer
//				ObjectOutputStream oos = new ObjectOutputStream(sChannel.socket().getOutputStream());
//				Message resp = new Message("resp",msg.getTopic()+":"+msg.getNum(),msg.getNum()+1);
//				oos.writeObject(resp);
//	            oos.close();
	
				//把接收到的消息更新到LeaderBroker中
				local.updateMsgToBroker(msg);
				
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
