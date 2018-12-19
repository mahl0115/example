package com.socket.simple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * 功能描述：<br />
 * socket是网络应用程序的核心，在服务器端或客户端网络应用程序中，socket皆为不可缺少的要素
 * 在服务器常见的应用有：FTP服务器，MAIL服务器（SMTP，POP3，IMAP4协议），WEB（HTTP协议）。
 * 
 * 建立服务器端SOCKET的应用程序步骤如下：<br />
 * 
 * 1、建立服务器端的SOCKET，并且以此侦听客户端的连接请求 <br />
 * 
 * 2、当服务器端侦测到来自客户端的连接请求时则接收此请求并建立客户端的SOCKET，该SOCEKT将作为
 * 客户端连接及后续处理发送及接收数据的依据，至此则完成服务器端与客户端的SOCKET通信链接
 * 
 * 3、处理来自客户端的信息，一般称为请求，可视为客户端的指令需求。例如HTTP通信协议的URL请求，<br />
 * 或FTP通信协议的FTP命令（如GET，PUT）等;<br />
 * 
 * 4、根据客户端传来的请求服务器端需经过程序逻辑处理之后，发送回相对应的招待结果或错误信息至
 * 客户端如HTTP服务器须发送回HTML网页内容，而FTP服务器则发送回FTP指令的结果 <br />
 * 
 * 5、当程序完成数据或命令的处理之后，便关闭SOCKET通信链接
 * 
 */
public class simpleServer {

	private static ServerSocket serverSocket;

	public static void main(String[] args) throws Exception {
		int port;

//		if (args.length == 0) {
//			System.out.println("Usage:java simpleServer [port]");
//			System.exit(1);
//		}
		//port = Integer.parseInt(args[0]);
		port = 8081;
		startServer(port);
	}

	/**
	 * 功能描述：启动服务器
	 * 
	 * @param port
	 *            服务器端口
	 * @throws Exception
	 */
	public static void startServer(int port) throws Exception {
		try {
			serverSocket = new ServerSocket(port);
			Thread thread = new Thread(new ListenClient(serverSocket));
			thread.start();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

/**
 * 
 * 功能描述：监听程序
 * 
 */
class ListenClient implements Runnable {
	private ServerSocket serverSocket;
	private Socket clientSocket;

	DataInputStream in;
	DataOutputStream out;

	public ListenClient(ServerSocket serverSocket) throws Exception {
		this.serverSocket = serverSocket;
	}

	@SuppressWarnings("static-access")
	public void run() {
		try {
			while (true) {
				clientSocket = serverSocket.accept();
				
				in = new DataInputStream(clientSocket.getInputStream());
				System.out.println(in.readUTF());
				
				File file = new File("D:\\work\\请假流程.txt");
				File outFile = new File("D:\\请假流程.txt");
				if(!outFile.exists()){
					outFile.createNewFile();
				}
				
				/**
				 * 当文件为utf-8时没有乱码，文件不是utf-8出现乱码
				 */
//				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
//				
//				String line = "";
//				StringBuilder builder = new StringBuilder();
//				while((line = br.readLine()) != null){
//					bw.write(line + "\n");
//				}
//				bw.flush();
				
				/**
				 * 任何格式文件均无乱码，但速度较上个方法慢
				 */
				DataInputStream dis = new DataInputStream(new FileInputStream(file));
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
				
				byte[] b = new byte[1024];
				int line;
				while((line = dis.read(b)) != -1){
					dos.write(b, 0, line);
				}
				dos.flush();
				
				out = new DataOutputStream(clientSocket.getOutputStream());
				out.writeUTF("给你放D盘了!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
};
