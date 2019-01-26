package com.encode;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 
 * @Description: 批量修改文件的编码格式（通常用来修改某一个项目的java文件）
 * @author hailong
 * @date 2016年4月25日 下午2:27:45
 */
public class BatchFilesEncoder {
    /**
     * 文件过滤器，目录和后缀匹配的被筛选出来。
     * 
     * @author pp
     *
     */
    class MyFileFilter implements FileFilter {
        private String[] fileSuffix;

        MyFileFilter(String...fileSuffix) {
            this.fileSuffix = fileSuffix;
        }

        public boolean accept(File pathname) {
            if (pathname.isDirectory()) {
                return true;
            }
            for (int i = 0; i < fileSuffix.length; i++) {
                if (pathname.getName().endsWith(fileSuffix[i])) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 目录和其子目录下面的对文本文件进行编码转换，在你确定了原文件编码的情况下进行，否则文件乱码会更厉害。 后缀规则：如："java":文件名后缀为java,"":就是所有的文件。
     * 
     * @param srcDir 原目录，必须存在
     * @param srcEncode 源编码
     * @param dstDir 目标目录，会被创建
     * @param dstEncode 目标编码
     * @param fileSuffix 文件后缀.
     * @throws Exception
     */
    public void txtFileEncoding(File srcDir, String srcEncode, File dstDir, String dstEncode, String...fileSuffix)
            throws Exception {
        txtFileEncoding(srcDir, srcEncode, dstDir, dstEncode, new MyFileFilter(fileSuffix));
    }

    /**
     * 删除符合后缀的文件 后缀规则：如："java":文件名后缀为java,"":就是所有的文件。
     * 
     * @param srcDir 原目录，必须存在
     * @param fileSuffix 文件后缀.
     * @throws Exception
     */
    public void deleteFile(File srcDir, String...fileSuffix) throws Exception {
        deleteFile(srcDir, new MyFileFilter(fileSuffix));
    }

    /**
     * 删除符合文件过滤器的文件
     * 
     * @param srcDir 原目录，必须存在
     * @param filter 文件过滤器.
     * @throws Exception
     */
    public void deleteFile(File srcDir, FileFilter filter) throws Exception {
        // System.out.println("原目录(getname)："+srcDir.getName());
        if (!srcDir.isDirectory()) {
            throw new Exception("原目录不存在：" + srcDir.getAbsolutePath());
        }
        File[] files = srcDir.listFiles(filter);
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                deleteFile(files[i], filter);
            } else {
                boolean b = files[i].delete();
                if (b) {
                    System.out.println("删除：" + files[i].getAbsolutePath());
                } else {
                    System.out.println("无法删除：" + files[i].getAbsolutePath());
                }
            }
        }
    }

    /**
     * 目录和其子目录下面的对符合文件过滤器的文本文件进行编码转换，在你确定了原文件编码的情况下进行，否则文件乱码会更厉害。
     * 
     * @param srcDir 原目录，必须存在
     * @param srcEncode 源编码
     * @param dstDir 目标目录，会被创建
     * @param dstEncode 目标编码
     * @param filter 文件过滤器.
     * @throws Exception
     */
    public void txtFileEncoding(File srcDir, String srcEncode, File dstDir, String dstEncode, FileFilter filter)
            throws Exception {
        // System.out.println(srcEncode+" to "+dstEncode);
        // System.out.println("原目录(getname)："+srcDir.getName());
        // System.out.println("目标目录(绝对)："+dstDir.getAbsolutePath());
        if (!srcDir.isDirectory()) {
            throw new Exception("原目录不存在：" + srcDir.getAbsolutePath());
        }
        File[] files = srcDir.listFiles(filter);
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                txtFileEncoding(files[i], srcEncode,
                        new File(dstDir.getAbsoluteFile() + File.separator + files[i].getName()), dstEncode, filter);
            } else {
                changeEncode(files[i].getAbsolutePath(), srcEncode,
                        dstDir.getAbsolutePath() + File.separator + files[i].getName(), dstEncode);
            }
        }
    }

    /**
     * 文本文件编码转换
     * 
     * @param srcFileS 原文件地址
     * @param srcEncode 源编码
     * @param dstFileS 目标文件地址
     * @param dstEncode 目标编码
     * @throws Exception
     */
    private void changeEncode(String srcFileS, String srcEncode, String dstFileS, String dstEncode) throws Exception {
        System.out.println("原文件：" + srcFileS);
        System.out.println("目标文件：" + dstFileS);
        File srcFile = new File(srcFileS);
        File dstFile = new File(dstFileS);
        if (!srcFile.exists()) {
            throw new Exception("原文件不存在：" + srcFile.getAbsolutePath());
        }
        if (!dstFile.exists()) {
            File p = dstFile.getParentFile();
            boolean b = false;
            if (!p.isDirectory()) {
                b = p.mkdirs();
                if (b) {
                    if (!dstFile.exists()) {
                        b = dstFile.createNewFile();
                    }
                }
                if (!b) {
                    throw new Exception("文件无法创建：" + dstFile.getAbsolutePath());
                }
            } else {
                if (!dstFile.exists()) {
                    b = dstFile.createNewFile();
                }
                if (!b) {
                    throw new Exception("文件无法创建：" + dstFile.getAbsolutePath());
                }
            }
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(dstFile);

        String str = "";

        // 有小部分地方乱码,改成1024效果好一些，有知道原因的可以分享一下。大量连在一起的汉字转码后可能乱码，但是又不能无限大。谁有解决方法？
        byte[] bytes = new byte[1024];
        byte[] bytes2;
        int num;
        num = in.read(bytes);
        while (num > 0) {
            // System.out.println(bytes);
            str = new String(bytes, 0, num, srcEncode);
            bytes2 = str.getBytes(dstEncode);
            out.write(bytes2);
            num = in.read(bytes);
        }
        // InputStreamReader reader=new InputStreamReader(in);
        // char[] chars=new char[1024];
        // byte[] bytes2;
        // int num;
        // num=reader.read(chars);
        // while(num>0){
        // str=new String(String.valueOf(chars,0,num).getBytes(), srcEncode);
        // bytes2=str.getBytes(dstEncode);
        // out.write(bytes2);
        // num=reader.read(chars);
        // }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BatchFilesEncoder t = new BatchFilesEncoder();
        String srcDir = "E:\\workspace_mars\\notifymq";
        String dstDir = "E:\\workspace_mars\\notifymq2";
        String srcEncode = "GBK";
        String dstEncode = "UTF-8";
        try {
            // t.deleteFile(new File(srcDir), "java");
            t.txtFileEncoding(new File(srcDir), srcEncode, new File(dstDir), dstEncode, "java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
