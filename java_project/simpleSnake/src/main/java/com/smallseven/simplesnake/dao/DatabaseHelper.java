/** 
 * @Description: 数据库操作类
 * @Author: smallSeven
 * @Date: 2020-04-01 14:03:33
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-04-04 19:27:32
 * @FilePath: /simpleSnake/src/main/java/com/smallseven/simplesnake/dao/DatabaseHelper.java
 */

package com.smallseven.simplesnake.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {
    /** 
     * @Description: jdbc四大参数
     * @param jdbcUser 数据库root用户名
     * @param jdbcPassword root密码
     * @param jdbcUrl 数据库连接
     * @param jdbcDriver 数据库驱动
     * @return: 
     */
    private String jdbcUser = "root";
    private String jdbcPassword = "123456";
    private String jdbcUrl = "jdbc:mysql://localhost:3306/snakeDB";
    private String jdbcDriver = "com.mysql.jdbc.Driver";

    public DatabaseHelper() {

    }

    
    public void testConnection() {
        /** 
         * @Description: 测试数据连接方法
         * @param connection 数据库连接对象
         * @param statement 
         * @return: 
         */
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(jdbcDriver);
            connection =DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);// 获取连接
            statement = connection.createStatement();// 获取statement实例，用以执行SQL语句
            resultSet = statement.executeQuery("SELECT * FROM user");//实行sql语句
            while (resultSet.next()){// 遍历结果集
                System.out.println(resultSet.getString(2));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            if(connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("找不到驱动程序类，加载驱动失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }finally{
            if (connection != null) return connection;
        }
        return connection;
    }

    public boolean connectionClose(Connection connection){
        if (connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println("数据库连接关闭失败！");
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }

    public Statement getStatement(Connection connection){
        if (connection != null){
            Statement statement = null;
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                //TODO: handle exception
                System.out.println("获取Statement实例失败！");
                e.printStackTrace();
                return null;
            }finally{
                if (statement != null) return statement;
            }
        }
        return null;
    }

    public User selectAllUser(){
        User user = new User();

        return user;
    }

    public static void main(String[] args) {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        databaseHelper.testConnection();
    }
}
