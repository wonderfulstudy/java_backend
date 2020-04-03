/** 
 * @Description: 用户类
 * @Author: smallSeven
 * @Date: 2020-04-01 10:00:07
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-04-01 10:14:44
 * @FilePath: /simpleSnake/src/main/java/com/smallseven/simplesnake/services/User.java
 */

package com.smallseven.simplesnake.services;

public class User{
    private String userName;// 用户名
    private String userEmail;// 用户邮箱
    private String userPassword;// 用户密码
    private String maxScore;// 用户当前分数
    
    public User(){
        this("未命名", "email@example.com", "000000");
    }

    public User(String userName, String userEmail, String userPassword){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getUserEmail(){
        return this.userEmail;
    }

    public String getUserPassword(){
        return this.userPassword;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }
}
