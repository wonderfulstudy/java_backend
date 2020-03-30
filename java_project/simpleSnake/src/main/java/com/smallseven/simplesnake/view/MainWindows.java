/**
 * @Description: 程序主界面
 * @Author: smallSeven
 * @Date: 2020-03-29 10:31:02
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-03-29 12:47:04
 * @FilePath: /simpleSnake/src/main/java/com/smallseven/simplesnake/mainWindows.java
 */
package com.smallseven.simplesnake;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainWindows extends JFrame {
    public static final int BLOCK_WIDTH = 15;// 贪吃蛇方格的宽度
    public static final int BLOCK_HEIGHT = 15;// 贪吃蛇方法的高度
    public static final int ROW = 40;// 界面方格行数
    public static final int COLUMN = 40;// 界面方法的列数
    
    public mainWindows() {
        setTitle("Snake");
        setSize(ROW * BLOCK_WIDTH, COLUMN * BLOCK_HEIGHT);
        setLocation(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new mainWindows();
    }
}