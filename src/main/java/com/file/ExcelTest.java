package com.file;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by mahailong on 17/5/8.
 */
public class ExcelTest {

    public static void main(String[] args) throws IOException {
        List<Select> list = parseExcel("/Users/mahailong/Downloads/123.xlsx");
        List<Select> result = list.stream().filter(select -> select.getGrade().equals("经济")).collect(Collectors.toList());
        System.out.println(StringUtils.join(result.stream().map(Select::getId).collect(Collectors.toList()), ","));

    }

    public static List<Select> parseExcel(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfSheets = new XSSFWorkbook(is);
        List<Select> list = Lists.newArrayList();

        XSSFSheet xssfSheet = xssfSheets.getSheetAt(1);
        for (int i = 0; i <= xssfSheet.getLastRowNum(); i++) {
            if (Objects.isNull(xssfSheet.getRow(i).getCell(0))) {
                break;
            }
            XSSFRow xssfRow = xssfSheet.getRow(i);
            Select select = new Select();
            select.setId(xssfRow.getCell(0).toString().trim());
            select.setName(xssfRow.getCell(1).toString());
            select.setGrade(xssfRow.getCell(2).toString());

            list.add(select);
        }
        return list;
    }
}
