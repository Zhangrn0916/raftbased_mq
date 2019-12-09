package utils;

import java.io.Serializable;

public class IpAddress implements Serializable {
	private static final long serialVersionUID = 1L;
	private String ip;
	private int port;
	
	public IpAddress(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}
	
	public String getIp() {
		return ip;
	}
	public int getPort() {
		return port;
	}
	
	public String toString() {
		return ip+":"+Integer.toString(port);
	}
	
}
