package com.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * 功能描述：<br />
 * 客户端SOCKET应用程序与服务器端SOCKET应用程序的流程很相似，最大的差别在于：<br />
 * 1、服务器端SOCKET应用程序主要用于侦听及接收客户端的连接，而客户端的SOCKET 应用程序则用于尝试与服务器端建立连接
 * 
 * 2、客户端SOCKET应用程序发送信息指令至服务器端，并接收服务器端所返回的结果； 而服务器端SOCEKT应用程序则处理指令逻辑，并将结果或错误信息发送至客户端
 * 
 * 常见的客户端应用有：<br />
 * CHAT客户端，FTP客户端，POP3客户端，SMTP客户端和TELNET客户端<br />
 * 
 * 建立客户端SOCKET应用程序的步骤大致如下：
 * 
 * 1、建立客户端SOCKET，在建立时需指定欲连接服务器端的主机名称（或IP）与INTERNET 通信端口 <br />
 * 
 * 2。发送特定信息或指令至服务器端
 * 
 * 3、接收服务器端返回的执行结果或错误信息，并以特定格式显示，例如HTTP通信协议会通过 HTML显示
 * 
 * 4、当客户端不需服务器端的处理时，便关闭SOCEKT通信链接
 * 
 */
public class CientSocketTest {

    private static Socket socket;

    public static void main(String[] args) throws Exception {
        // CientSocketTest.connectServer("127.0.0.1", 8888);
        Socket socket = new Socket("127.0.0.1", 8888);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        System.out.println("客户端");
        String s = "你是谁";
        System.out.println("客户端:" + s);
        out.println(s);
        out.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("服务端:" + br.readLine());
    }

    /**
     * 功能描述：连接服务器
     * 
     * @param host 服务器端的主机名称或者IP地址
     * @param port 服务器端通信端口
     */
    @SuppressWarnings("unused")
    public static void connectServer(String host, int port) {
        try {
            CientSocketTest.socket = new Socket(InetAddress.getByName(host), port);
            DataOutputStream out = new DataOutputStream(CientSocketTest.socket.getOutputStream());// 建立通信通道

            String str = "我要请假流程信息!";
            out.writeUTF(str);

            DataInputStream in = new DataInputStream(CientSocketTest.socket.getInputStream());
            byte[] inByte = new byte[1024];
            in.read(inByte);
            String response = new String(inByte, 0, inByte.length);
            System.out.println(response.trim());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                CientSocketTest.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
