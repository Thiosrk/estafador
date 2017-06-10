package com.module.service.Impl;

import java.sql.*;

/**
 * Created by lenovo on 2017/6/10.
 */
public class mysqlImpl {
    Connection conn;
    Statement stmt;


    private final String dataBasePort = "3306";
    private final String dataBaseName = "estafador";
    private final String dataBaseUser = "root";
    private final String dataBasePassword = "root";

    public mysqlImpl() {
        conn = null;
        String url = "jdbc:mysql://localhost:" + dataBasePort + "/" + dataBaseName + "?" + "user=" + dataBaseUser
                + "&password=" + dataBasePassword + "&useUnicode=true&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");//
            conn = DriverManager.getConnection(url);//
            stmt = conn.createStatement();//
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet query(String sql) throws SQLException {
        ResultSet result = stmt.executeQuery(sql);
        return result;
    }

    public int update(String sql) throws SQLException {
        int result = stmt.executeUpdate(sql);
        return result;
    }

    public void close() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
