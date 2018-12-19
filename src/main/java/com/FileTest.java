package com;

import java.io.*;

public class FileTest {

    public static void main(String[] args) {
        toUTF8();
    }

    public static void toUTF8() {
        File file = new File("D:\\work\\文档\\es搜索\\es.txt");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "IS"));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(br.readLine());
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
