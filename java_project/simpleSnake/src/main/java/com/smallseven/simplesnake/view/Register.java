/** 
 * @Description: 贪吃蛇注册用户界面
 * @Author: smallSeven
 * @Date: 2020-03-31 10:26:15
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-03-31 10:33:45
 * @FilePath: /simpleSnake/src/main/java/com/smallseven/simplesnake/view/Register.java
 */
package com.smallseven.simplesnake.view;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

 public class Register extends JFrame implements ActionListener{
         /**
          *
          */
         private static final long serialVersionUID = 2315035628297403382L;
         JLabel nameLabel = new JLabel(
                         "用户名："),
            passwordLabel = new JLabel("密码："),
            rpasswordLabel = new JLabel("重复密码："),
            emailLabel = new JLabel("邮箱：");
    JTextField userName = new JTextField(10),
                userEmail = new JTextField(10);
    JPasswordField passwordField = new JPasswordField(10),
                    rPasswordField = new JPasswordField(10);
    JButton registerButton = new JButton("注册"),
            exitButton = new JButton("退出");
    public Register(){
        setTitle("用户注册");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 400, 400, 300);
        setResizable(false);

        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints1 = new GridBagConstraints(),
                            constraints2 = new GridBagConstraints(),
                            constraints3 = new GridBagConstraints(),
                            constraints4 = new GridBagConstraints();

        jPanel.add(nameLabel);
        jPanel.add(userName);
        constraints1.gridy = 1;
        jPanel.add(passwordLabel, constraints1);
        jPanel.add(passwordField, constraints1);
        constraints2.gridy = 2;
        jPanel.add(rpasswordLabel, constraints2);
        jPanel.add(rPasswordField, constraints2);
        constraints3.gridy = 3;
        jPanel.add(emailLabel, constraints3);
        jPanel.add(userEmail, constraints3);
        constraints4.gridy = 4;
        jPanel.add(registerButton, constraints4);
        jPanel.add(exitButton, constraints4);
        add(jPanel);
        setVisible(true);
     }

     @Override
     public void actionPerformed(ActionEvent e){
         if (e.getSource() == registerButton){
                
         }else if (e.getSource() == exitButton){
                System.exit(1);
         }
     }
}
