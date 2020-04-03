/** 
 * @Description: 数据库操作测试类
 * @Author: smallSeven
 * @Date: 2020-04-01 14:03:33
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-04-03 16:41:08
 * @FilePath: /simpleSnake/src/test/java/com/smallseven/simplesnake/dao/DatabaseHelperTest.java
 */

package com.smallseven.simplesnake.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.smallseven.simplesnake.services.User;

public class DatabaseHelperTest {
    private String jdbcUser = "root";
    private String jdbcPassword = "JYF@08221997a";
    private String jdbcUrl = "jdbc:mysql://localhost:3306/simpleSnakeDB";
    private String jdbcDriver = "com.mysql.jdbc.Driver";

    public DatabaseHelperTest() {

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
