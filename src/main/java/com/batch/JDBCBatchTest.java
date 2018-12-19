package com.batch;

import org.apache.commons.lang3.time.StopWatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc批处理： noBatch为原始jdbc插入一条数据，循环100次需要打开关闭数据连接100次，花费时间大概7s左右;
 * haveBatch使用了preparedStatement的预编译addBatch(),然后在打开一次连接中，插入100条数据，然后关闭，花费时间大概200ms左右； 性能很大差异;
 *
 * @author hailong 2016年1月25日上午11:26:11
 */
public class JDBCBatchTest {

    public static void main(String[] args) {

        StopWatch watch = new StopWatch();
        watch.start();
        for (int i = 0; i < 100; i++) {
            JDBCBatchTest.noBatch();
        }
        long l = watch.getTime();
        System.out.println("noBatch spend time:" + l);

        JDBCBatchTest.haveBatch();
        System.out.println("haveBatch spend time:" + (watch.getTime() - l));

    }

    public static void noBatch() {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = JDBCBatchTest.getConnection();
            String sql = "insert into gift values(?, ?, 0)";
            ps = con.prepareStatement(sql);

            String id = UuidUtil.get32UUID();
            String code = UuidUtil.get32UUID();
            ps.setString(1, id);
            ps.setString(2, code);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCBatchTest.close(con, ps);
        }

    }

    public static void haveBatch() {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = JDBCBatchTest.getConnection();
            // 不允许jdbc自动提交事务
            con.setAutoCommit(false);
            String sql = "insert into gift values(?, ?, 0)";
            ps = con.prepareStatement(sql);

            for (int i = 0; i < 100; i++) {
                String id = UuidUtil.get32UUID();
                String code = UuidUtil.get32UUID();
                ps.setString(1, id);
                ps.setString(2, code);
                ps.addBatch();
            }

            ps.executeBatch();
        } catch (SQLException e) {
            try {
                // 出现异常全部回滚
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            // 统一提交事务
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCBatchTest.close(con, ps);
        }
    }

    public static Connection getConnection() {
        Connection con = null;

        try {
            // static {
            // try {
            // java.sql.DriverManager.registerDriver(new Driver());
            // } catch (SQLException E) {
            // throw new RuntimeException(“Can’t register driver!”);
            // }
            // }
            Class.forName("com.mysql.jdbc.Driver");// 源码解析：当加载Driver类的时候，如上静态块中会注册实例化一个Driver的对象
            con =
                    DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/platform?useUnicode=true&characterEncoding=utf8", "root",
                            "root");
        } catch (ClassNotFoundException e) {
            System.out.println("加载jdbc驱动出现异常！");
        } catch (SQLException e) {
            System.out.println("DriverManager连接数据库出现异常！");
        }

        return con;
    }

    public static void close(Connection con, PreparedStatement ps) {
        try {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
