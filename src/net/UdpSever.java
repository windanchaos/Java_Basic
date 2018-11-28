/**  
 * Project Name:Java_Basic  
 * File Name:UdpSever.java  
 * Package Name:net  
 * Date:2018年10月19日下午10:35:23  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpSever
{

	public static void main(String[] args) throws IOException
	{
		//socket通道
		DatagramSocket datagramSocket=new DatagramSocket(8888);
		while(true) {
		//接受数据的容器
		byte[] container=new byte[1024];
		//容器封装
		DatagramPacket packet=new DatagramPacket(container, container.length);
		datagramSocket.receive(packet);
		
		byte[] data=packet.getData();
		int length=packet.getLength();
		
		System.out.println(new String(data,0,data.length));
		}
	}

}
