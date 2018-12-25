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
	    * Զ�������ļ�����ȡ����p
	    * @param filePath �ļ������ַ ��http://www.baidu.com/1.txt
	    * @return String
	    */
	   public static String DownAndReadFile(String filePath){
		   String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());	   
		   File savePath = new File("D://"+date);//�������ļ�
		   if (!savePath.exists()) { 
			   savePath.mkdir(); 
	       }
		   String[] urlname = filePath.split("/");
		   int len = urlname.length-1;
		   String uname = urlname[len];//��ȡ�ļ���
		   try {
			   File file = new File(savePath+"//"+uname);//�������ļ�
			   if(file!=null && !file.exists()){
				   file.createNewFile();
			   }
			   OutputStream oputstream = new FileOutputStream(file);
			   URL url = new URL(filePath);
			   HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			   uc.setDoInput(true);//�����Ƿ�Ҫ�� URL ���Ӷ�ȡ����,Ĭ��Ϊtrue
			   uc.connect();
			   InputStream iputstream = uc.getInputStream();
			   System.out.println("file size is:"+uc.getContentLength());//��ӡ�ļ�����
			   byte[] buffer = new byte[4*1024];
			   int byteRead = -1;	
			   while((byteRead=(iputstream.read(buffer)))!= -1){
				   oputstream.write(buffer, 0, byteRead);
			   }
			   oputstream.flush();	
			   iputstream.close();
			   oputstream.close();
			   //��ȡ�ļ�
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
			System.out.println("��ȡʧ�ܣ�");
			e.printStackTrace();
		}   
		   return null;
	   }
}
