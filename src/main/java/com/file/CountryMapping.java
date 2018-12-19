package com.file;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * Created by mahailong on 16/10/26.
 */
public class CountryMapping {
    public static void main(String[] args) throws IOException {
        parseExcel("/Users/mahailong/Desktop/国家.xlsx");
    }

    public static void parseExcel(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfSheets = new XSSFWorkbook(is);
        JSONArray array = new JSONArray();
        for (XSSFSheet xssfSheet : xssfSheets) {
            for (int i = 0; i <= xssfSheet.getLastRowNum(); i++) {
                XSSFRow xssfRow = xssfSheet.getRow(i);

                XSSFCell idCell = xssfRow.getCell(0);
                int countryId = new BigDecimal(idCell.toString()).intValue();

                XSSFCell nameCell = xssfRow.getCell(1);
                String name = nameCell.toString();

                XSSFCell askCell = xssfRow.getCell(2);
                String ask = askCell.toString();

                XSSFCell sayEnglishCell = xssfRow.getCell(3);
                int sayEnglish = new BigDecimal(sayEnglishCell.toString()).intValue();

                //id属性
                JSONObject obj = new JSONObject();
                obj.put("id", countryId);
                //name属性
                obj.put("name", name);
                //询问句
                obj.put("askSentence", ask);
                //询问句
                obj.put("sayEnglish", sayEnglish);

                array.add(obj);
            }
        }
        System.out.println(JSONArray.toJSONString(array));
    }
}
