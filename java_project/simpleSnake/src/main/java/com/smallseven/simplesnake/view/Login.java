/** 
 * @Description: 贪吃蛇登录界面
 * @Author: smallSeven
 * @Date: 2020-03-31 10:26:15
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-03-31 10:33:01
 * @FilePath: /simpleSnake/src/main/java/com/smallseven/simplesnake/view/Login.java
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

public class Login extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 2671157876542063576L;
    JLabel nameJlabel = new JLabel("用户名：");
    JLabel passwordJlabel = new JLabel("密码：");
    JTextField userName = new JTextField(10);
    JPasswordField userPassword = new JPasswordField(10);
    JButton loginButton = new JButton("登录");
    JButton exitButton = new JButton("退出");
    JButton registerButton = new JButton("注册？");
    
    public Login() {
        setTitle("请登录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 400, 400, 300);
        setResizable(false);
        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints1 = new GridBagConstraints(), constraints2 = new GridBagConstraints();

        loginButton.addActionListener(this);
        exitButton.addActionListener(this);
        registerButton.addActionListener(this);

        jPanel.add(nameJlabel);
        jPanel.add(userName);
        constraints1.gridy = 1;
        jPanel.add(passwordJlabel, constraints1);
        jPanel.add(userPassword, constraints1);
        constraints2.gridy = 2;
        jPanel.add(loginButton, constraints2);
        jPanel.add(exitButton, constraints2);
        jPanel.add(registerButton, constraints2);
        add(jPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton){
            setVisible(false);
            new MainWindows();
        }else if (e.getSource() == exitButton){
            System.exit(0);
        }else if (e.getSource() == registerButton){
            setVisible(false);
            new Register();
        }
    }
    public static void main(final String[] args) {
        new Login();
    }
}
