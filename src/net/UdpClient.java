/**  
 * Project Name:Java_Basic  
 * File Name:UdpClient.java  
 * Package Name:net  
 * Date:2018年10月19日下午10:35:35  
 * Copyright (c) 2018, yaobo7878@163.com All Rights Reserved.  
 *  
 */
package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class UdpClient
{


	public static void main(String[] args) throws IOException
	{
		DatagramSocket daSocket=new DatagramSocket(7777);
		String msString="客户端数据安德森33";
		byte[] msgbyte=msString.getBytes();
		
		DatagramPacket daPacket=new DatagramPacket(msgbyte,msgbyte.length,new InetSocketAddress("localhost",8888));
		
		daSocket.send(daPacket);
		daSocket.close();
	}

}
