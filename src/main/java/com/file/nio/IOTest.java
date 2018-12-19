package com.file.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class IOTest {
    public static void main(String[] args) throws Exception {

        String sourcePath = "D:\\电影\\test.log";

        String destPath1 = "D:\\test1.log";

        String destPath2 = "D:\\test2.log";

        String destPath3 = "D:\\test3.log";

        String destPath4 = "D:\\test4.log";

        long t1 = System.currentTimeMillis();

        nioCopy(sourcePath, destPath2);
        long t2 = System.currentTimeMillis();
        System.out.println("transferFrom NIO文件通道方法实现文件拷贝耗时:" + (t2 - t1) + "ms");

        nioCopy2(sourcePath, destPath3);
        long t3 = System.currentTimeMillis();
        System.out.println("map内存映射NIO文件拷贝耗时:" + (t3 - t2) + "ms");

        traditionalCopy(sourcePath, destPath1);
        long t4 = System.currentTimeMillis();
        System.out.println("传统IO文件拷贝耗时:" + (t4 - t3) + "ms");

        nioCopy(sourcePath, destPath4);
        long t5 = System.currentTimeMillis();
        System.out.println("标准NIO文件拷贝耗时:" + (t5 - t4) + "ms");
    }

    private static void nioCopy2(String sourcePath, String destPath) throws Exception {

        File source = new File(sourcePath);

        File dest = new File(destPath);

        if (!dest.exists()) {

            dest.createNewFile();

        }

        FileInputStream fis = new FileInputStream(source);

        FileOutputStream fos = new FileOutputStream(dest);

        FileChannel sourceCh = fis.getChannel();

        FileChannel destCh = fos.getChannel();

        MappedByteBuffer mbb = sourceCh.map(FileChannel.MapMode.READ_ONLY, 0, sourceCh.size());

        destCh.write(mbb);

        sourceCh.close();

        destCh.close();

    }

    public static void niocopy3(String sourcePath, String destPath) throws IOException {
        File source = new File(sourcePath);

        File dest = new File(destPath);

        if (!dest.exists()) {

            dest.createNewFile();

        }

        FileInputStream fis = new FileInputStream(source);

        FileOutputStream fos = new FileOutputStream(dest);

        FileChannel sourceCh = fis.getChannel();

        FileChannel destCh = fos.getChannel();

        ByteBuffer bb = ByteBuffer.allocate(1024);
        while (true) {
            bb.clear();

            int len = sourceCh.read(bb);
            if (len == -1) {
                break;
            }
            bb.flip();
            destCh.write(bb);
        }

        sourceCh.close();

        destCh.close();
    }

    private static void traditionalCopy(String sourcePath, String destPath) throws Exception {

        File source = new File(sourcePath);

        File dest = new File(destPath);

        if (!dest.exists()) {

            dest.createNewFile();

        }

        FileInputStream fis = new FileInputStream(source);

        FileOutputStream fos = new FileOutputStream(dest);

        byte[] buf = new byte[512];

        int len = 0;

        while ((len = fis.read(buf)) != -1) {

            fos.write(buf, 0, len);

        }

        fis.close();

        fos.close();

    }

    private static void nioCopy(String sourcePath, String destPath) throws Exception {

        File source = new File(sourcePath);

        File dest = new File(destPath);

        if (!dest.exists()) {

            dest.createNewFile();

        }

        FileInputStream fis = new FileInputStream(source);

        FileOutputStream fos = new FileOutputStream(dest);

        FileChannel sourceCh = fis.getChannel();

        FileChannel destCh = fos.getChannel();

        destCh.transferFrom(sourceCh, 0, sourceCh.size());

        sourceCh.close();

        destCh.close();

    }

}
