package com.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * 创建流
 *
 * @author mahl
 * @create 2017-11-05
 */
public class CreateStreamTest {

    public static void main(String[] args) throws IOException {
        //streamOf();
        //array();
        file();
    }

    /**
     * 由值创建流
     */
    private static void streamOf() {
        int result = Stream.of(1, 2, 3, 4, 5)
                .mapToInt(item -> item)
                .reduce(0, Integer::sum);
        System.out.println(result);
    }

    /**
     * 数组创建流
     */
    private static void array() {
        int[] array = {1, 2, 3, 4, 5};
        OptionalInt result = Arrays.stream(array).max();
        System.out.println(result.getAsInt());
    }

    /**
     * 文件生成流
     */
    private static void file() throws IOException {
        Files.lines(Paths.get("/Users/mahailong/work/test/data"))
                .flatMap(item -> Arrays.stream(item.split("")))
                .forEach(item -> System.out.println(item));
    }
}
