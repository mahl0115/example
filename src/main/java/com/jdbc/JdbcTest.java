package com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //test();
        //poi_spread();
        room();
    }

    private static void test() throws SQLException, ClassNotFoundException {
        Connection con = JdbcUtil.getConnection("jdbc:mysql://127.0.0.1:3306/test?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true", "root", "612020");
        String sql = "alter table matching add index mtId_index(mtId);";
        Statement pst = con.createStatement();
        int result = pst.executeUpdate(sql);
        System.out.println("result=" + result);
        con.close();
        pst.close();
    }

    private static void poi_spread() throws SQLException, ClassNotFoundException {
        Connection con = JdbcUtil.getConnection("jdbc:mysql://10.32.106.170:5002/datasync?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true", "dataclean_w", "lFeLQeRSxpSGNd");
        Statement pst = null;
        for (int i = 99; i < 137; i++) {
            String sql = "alter table poi_spread drop partition p" + i + ";";
            pst = con.createStatement();
            int result = pst.executeUpdate(sql);
            System.out.println("result=" + result);
        }
        con.close();
        pst.close();
    }

    private static void room() throws SQLException, ClassNotFoundException {
        Connection con = JdbcUtil.getConnection("jdbc:mysql://10.32.106.170:5002/datasync?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true", "dataclean_w", "lFeLQeRSxpSGNd");
        Statement pst = null;
        for (int i = 98; i < 137; i++) {
            String sql = "alter table room drop partition p" + i + ";";
            pst = con.createStatement();
            int result = pst.executeUpdate(sql);
            System.out.println("result=" + result);
        }
        con.close();
        pst.close();
    }
}
