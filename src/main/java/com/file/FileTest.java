package com.file;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * exper
 *
 * @author hailong
 * @Description: inputstream获取大小
 * @date 2016年5月3日 上午10:27:39
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        List<String> file = Files.readAllLines(Paths.get("/Users/mahailong/Downloads/totalCount"));

        List<String> landmarkList = Lists.newArrayListWithCapacity(17225);
        List<String> cityIdList = Lists.newArrayListWithCapacity(17225);
        List<String> totalCountList = Lists.newArrayListWithCapacity(17225);
        file.forEach(s -> {
            String[] array = StringUtils.split(s, ",");
            landmarkList.add(array[0]);
            cityIdList.add(array[1]);
            totalCountList.add(array[2]);
        });
        //写文件
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("/Users/mahailong/Downloads/20181202"));
        totalCountList.forEach(s -> {
            try {
                bufferedWriter.write(s);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedWriter.close();
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
