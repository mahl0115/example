package com.file;

import com.google.common.collect.Maps;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by mahailong on 17/5/8.
 */
public class ExcelTest {

    public static void main(String[] args) throws IOException, InterruptedException {

    }

    public static Map<Integer, Integer> parseExcel(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfSheets = new XSSFWorkbook(is);
        Map<Integer, Integer> obj = Maps.newHashMap();

        for (XSSFSheet xssfSheet : xssfSheets) {
            for (int i = 0; i <= xssfSheet.getLastRowNum(); i++) {
                if (i == 0) {
                    continue;
                }
                XSSFRow xssfRow = xssfSheet.getRow(i);
                obj.put(new BigDecimal(xssfRow.getCell(0).toString()).intValue(), new BigDecimal(xssfRow.getCell(1).toString()).intValue());
            }
        }
        return obj;
    }
}
