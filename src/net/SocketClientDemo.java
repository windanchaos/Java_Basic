package net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientDemo {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// socket通道
//		InetAddress localHostAddress=InetAddress.getLocalHost();
//		System.out.println(localHostAddress);
		Socket socket = new Socket("localhost", 8888);
		Send send = new Send(socket);
		new Thread(send).start();
		Receive receive = new Receive(socket);
		new Thread(receive).start();

	}

	// 单线程
	public static void chat(Socket client) throws IOException {
		DataInputStream serverMsg = new DataInputStream(client.getInputStream());
		String msg = serverMsg.readUTF();
		System.out.println(msg);

		// 写流

		DataOutputStream clientMsg = new DataOutputStream(client.getOutputStream());
		// msg
		String toServerMsg = "客户端发送的消息！";
		clientMsg.writeUTF(toServerMsg);
		// clientMsg.write(toServerMsg.getBytes());
		clientMsg.flush();

	}

}