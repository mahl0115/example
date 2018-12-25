package com.mahl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadTest {
	
		public static void main(String[] args) {
			DownAndReadFile("http://www.58pic.com/index.php?m=show&a=download&id=18735566");
		}
	
		/**
	    * 远程下载文件并读取返回p
	    * @param filePath 文件网络地址 如http://www.baidu.com/1.txt
	    * @return String
	    */
	   public static String DownAndReadFile(String filePath){
		   String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());	   
		   File savePath = new File("D://"+date);//创建新文件
		   if (!savePath.exists()) { 
			   savePath.mkdir(); 
	       }
		   String[] urlname = filePath.split("/");
		   int len = urlname.length-1;
		   String uname = urlname[len];//获取文件名
		   try {
			   File file = new File(savePath+"//"+uname);//创建新文件
			   if(file!=null && !file.exists()){
				   file.createNewFile();
			   }
			   OutputStream oputstream = new FileOutputStream(file);
			   URL url = new URL(filePath);
			   HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			   uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
			   uc.connect();
			   InputStream iputstream = uc.getInputStream();
			   System.out.println("file size is:"+uc.getContentLength());//打印文件长度
			   byte[] buffer = new byte[4*1024];
			   int byteRead = -1;	
			   while((byteRead=(iputstream.read(buffer)))!= -1){
				   oputstream.write(buffer, 0, byteRead);
			   }
			   oputstream.flush();	
			   iputstream.close();
			   oputstream.close();
			   //读取文件
			   StringBuffer strb = new StringBuffer();
			   FileInputStream fs = new FileInputStream(new File(savePath+"//"+uname));
			   InputStreamReader isr = new InputStreamReader(fs,"UTF-8");
			   BufferedReader br = new BufferedReader(isr);
			   String data = "";
			   while((data = br.readLine()) != null){
				   strb.append(data + "\n");
			   }
			   br.close();
			   fs.close();
			   isr.close();
			   System.out.println(strb.toString());
			   return strb.toString();
			   
		} catch (Exception e) {
			System.out.println("读取失败！");
			e.printStackTrace();
		}   
		   return null;
	   }
}
