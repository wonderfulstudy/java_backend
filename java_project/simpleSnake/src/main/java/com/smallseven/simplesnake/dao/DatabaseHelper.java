/** 
 * @Description: 数据库操作类
 * @Author: smallSeven
 * @Date: 2020-04-01 14:03:33
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-04-03 16:45:49
 * @FilePath: /simpleSnake/src/main/java/com/smallseven/simplesnake/dao/DatabaseHelper.java
 */

package com.smallseven.simplesnake.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smallseven.simplesnake.services.User;

public class DatabaseHelper {
    private String jdbcUser = "root";
    private String jdbcPassword = "123456";
    private String jdbcUrl = "jdbc:mysql://localhost:3306/simpleSnakeDB";
    private String jdbcDriver = "com.mysql.jdbc.Driver";

    public DatabaseHelper() {

    }

    public void testConnection() {
        try {
            Class.forName(jdbcDriver);
            Connection connection =DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
