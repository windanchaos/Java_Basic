package net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.event.TreeWillExpandListener;

public class SockeServerDemo {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		while (true) {
			Socket socket = server.accept();

			Receive sr = new Receive(socket);
			Thread thread2 = new Thread(sr);
			thread2.start();

			System.out.println("阻塞完成，客户端连接成功");

			Send sd = new Send(socket);
			sd.sendMsg("欢迎来到德莱联盟");
			Thread thread = new Thread(sd);
			thread.start();

		}

	}

	public static void server(Socket socket) throws IOException {
		// 服务端读写流
		DataInputStream dataIn = new DataInputStream(socket.getInputStream());
		String clientMsg = dataIn.readUTF();
		System.out.println(clientMsg);

		// 服务端写出流
		DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
		String serverMsg = "服务端发送给你的消息，加油！";
		dataOut.write(serverMsg.getBytes());
		dataOut.flush();
	}
}

class Send implements Runnable {
	private Socket socket;
	private boolean flag = true;
	private DataOutputStream dataout;

	// 构造
	public Send(Socket socket) throws IOException {
		this.socket = socket;
		this.dataout = new DataOutputStream(socket.getOutputStream());
	}

	// 发消息
	public void sendMsg(String msg) throws IOException {
		if (null == msg) {
			msg = "服务端给你的消息";
		}
		if (flag) {
			dataout.writeUTF(msg);
			dataout.flush();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				String msg = new BufferedReader(new InputStreamReader(System.in)).readLine();
				sendMsg(msg);
			} catch (IOException e) {
				flag = false;
			}
		}
	}
}

class Receive implements Runnable {
	private Socket socket;
	private boolean flag = true;
	private DataInputStream datain;

	// 构造
	public Receive(Socket socket) throws IOException {
		this.socket = socket;
		this.datain = new DataInputStream(socket.getInputStream());
	}

	// 发消息
	public void getClientMsg() throws IOException {
		if (flag) {
			String msg = datain.readUTF();
			System.out.println(msg);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				getClientMsg();
			} catch (IOException e) {
				flag = false;
			}
		}
	}
}