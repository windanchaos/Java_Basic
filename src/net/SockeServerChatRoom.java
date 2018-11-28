package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.event.TreeWillExpandListener;
import javax.xml.stream.events.StartDocument;

public class SockeServerChatRoom {
	private ArrayList<Channel> list = new ArrayList<Channel>();

	public static void main(String[] args) throws IOException {
		new SockeServerChatRoom().Start();

	}

	public void Start() throws IOException {
		ServerSocket server = new ServerSocket(8888);
		while (true) {
			Socket socket = server.accept();
			Channel channel = new Channel(socket);
			Thread thread = new Thread(channel);
			list.add(channel);
			thread.start();
			System.out.println(thread.getName());
			System.out.println("消息线程数："+list.size());

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

	class Channel implements Runnable {
		private Socket socket;
		private boolean flag = true;
		private DataOutputStream dataout;
		private DataInputStream datain;
		private String clientMsg;

		// 构造
		public Channel(Socket socket) throws IOException {
			this.socket = socket;
			this.dataout = new DataOutputStream(socket.getOutputStream());
			this.datain = new DataInputStream(socket.getInputStream());
		}

		// 发消息
		public void sendMsg(String clientMsg) throws IOException {
			if (flag && null != clientMsg && !clientMsg.equals("")) {
				dataout.writeUTF(clientMsg);
				dataout.flush();
			}
		}

		// 获取客户端消息
		public String getClientMsg() throws IOException {
			if (!flag) {
				return "";
			}
			clientMsg = datain.readUTF();
			System.out.println("log "+clientMsg);
			return clientMsg;
		}
		//发送给其他客户端
		public void sendOthers(String msg) throws IOException {
			for (Channel c : list) {
				c.sendMsg(msg);
			}
			}
		@Override
		public void run() {
			while(true) {
					try {
						String msg=getClientMsg();
						sendOthers(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

				}
			}
		}
	}
}
