/**
 * @Title: FileNIOTest.java 
 * @author mahailong_d  
 * @date 2015年12月14日 下午1:57:26 
 * @version V1.0   
 */
package com.file.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileNIOUtils {

    public static void read(File file) throws IOException {

        // 从FileInputStream中获取channel对象
        FileInputStream fis = new FileInputStream(file);
        FileChannel channel = fis.getChannel();

        int size = (int) channel.size();

        // 生成一个偏移量为0,容量和最大容量都为1024的ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 5);

        // channel向buffer中读入数据
        channel.read(buffer);

        byte[] array = buffer.array();

        FileNIOUtils.write(array);

        String str = new String(array, 0, size);

        System.out.println(str);
    }

    public static void write(byte[] array) throws IOException {
        File writeFile = new File("/Users/mahailong/Downloads/totalCount");
        FileOutputStream fos = new FileOutputStream(writeFile);
        FileChannel channel = fos.getChannel();

        ByteBuffer bb = ByteBuffer.allocate(1024);
        bb.put(array);

        bb.flip();

        channel.write(bb);
    }

    public static void main(String[] args) throws Exception {

        File file = new File("d:\\work\\请假流程.txt");
        if (!file.exists()) {
            throw new Exception("文件不存在！");
        }

        FileNIOUtils.read(file);
    }
}
