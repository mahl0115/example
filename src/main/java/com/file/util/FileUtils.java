package com.file.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */
public class FileUtils {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/mahailong/Downloads/totalCount");

        BufferedReader br = new BufferedReader(new FileReader(file));

        JSONObject jobj = new JSONObject();
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] partner_id_logo = line.split(" ");
            if (partner_id_logo.length > 1) {
                jobj.put("partner_id", partner_id_logo[0]);
                jobj.put("logo", partner_id_logo[1]);
            }
        }
        System.out.println(jobj.toJSONString());
        br.close();
    }

//    public static void read(File file) throws IOException {
//
//        // 从FileInputStream中获取channel对象
//        FileInputStream fis = new FileInputStream(file);
//        FileChannel channel = fis.getChannel();
//
//        int size = (int) channel.size();
//
//        // 生成一个偏移量为0,容量和最大容量都为1024的ByteBuffer
//        ByteBuffer buffer = ByteBuffer.allocate(1024 * 5);
//
//        // channel向buffer中读入数据
//        channel.read(buffer);
//
//        byte[] array = buffer.array();
//
//        FileNIOTest.write(array);
//
//        String str = new String(array, 0, size);
//
//        System.out.println(str);
//    }
}
